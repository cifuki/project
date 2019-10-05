package Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import ast.ASTNodeVisitor;
import helper.txtHelper;


public class VSM {
	
	//输入一个字符串句子返回一个字符串数组，每个元素都是一个单词
	private String[] participle(String str) {
		StringTokenizer st = new StringTokenizer(str," ,?.!:\"\"''\n#");
    	List<String> wordList = new ArrayList<>();
    	while (st.hasMoreElements()) {
    	    wordList.add(st.nextToken().toLowerCase());
    	}
    	String[] words = wordList.toArray(new String[wordList.size()]);  
//    	for(String s:words) {
//    		System.out.println(s+"\n");
//    	}
		return words;		
	}
	
	//构建词表（一个D）
	public Map<String, Integer> countKey(String code_snippet) {
		Map<String,Integer> docTable = new TreeMap<String,Integer>();
		//String code_snippet=from_code_get_methon.methonList[i];
		txtHelper th=new txtHelper();
		code_snippet=th.prepareline(code_snippet);
		String[] words =  participle(code_snippet);
		// 字典插入与赋值
        for (String word :words) {
        	if (word != "" &&  docTable.containsKey(word)) {  //如果存在次数加1
        		int num = docTable.get(word);    
                docTable.put(word, num+1);
             }
        	else if( word != "")     //否则初值为1
        		docTable.put(word, 1);
        }
		/********************** 将值从大到小排序  *********************/
        //将docTable.entrySet()转换为list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(docTable.entrySet());
        //通过集合的比较其来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue().compareTo(o1.getValue());
            }
         });
//        for (Entry<String, Integer> entry : list) {
//            System.out.println("sorted"+entry.getKey()+" "+entry.getValue());
//        }
        return docTable;
	}
	
	//计算tf 
	private float calculate_tf(String word,String doc) {
		Map<String,Integer> docTable=countKey(doc);
		Float sum=(float) 0;
		float fre=0;
		for (Entry<String, Integer> entry : docTable.entrySet()) {     
		    Integer Value = entry.getValue(); 
		    sum+=Value;
		}
		if (word != "" &&  docTable.containsKey(word)) 
			fre=docTable.get(word);//单词出现的次数
		fre = (float) (fre/sum);
		return fre;
	}
	
	//计算idf 
	private double calculate_idf(String word) {
		//包含该单词的文档个数
		int ndoc = 0;
    	File IndexDir =new File(".\\DATA\\codeSerch_index");
    	TermQuery query = new TermQuery(new Term("methon", word));
    	try {
            Directory directory = FSDirectory.open(IndexDir);
            IndexReader indexReader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            TopDocs topDocs=indexSearcher.search(query, 20);
            ndoc=topDocs.totalHits;
			indexReader.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	    /***计算idf******/
		double idf = Math.log(332/(ndoc+0.01));
  	  	//System.out.println(fre);
  	  	//System.out.println(idf);
	  	return idf;
	}
	
	private List<Float> idfs = new ArrayList<Float>();
	
	//计算最大IDF
	private double calculate_maxidf(String[] terms) {
		double max_idf=0;
		idfs.removeAll(idfs);
		for(String term:terms) {
			double idf = calculate_idf(term);
			idfs.add((float) idf);
			if(max_idf<idf) 
				max_idf=idf;
		}
		return max_idf;
	}
	
	//从布尔表达式中得到各个项t1,t2...
	private String[] get_term(String booleanQuery) {
		//+API:awt AWT event multicast save  +(methonName:imag methonBody:imag) +(methonName:png methonBody:png) +(methonName:format methonBody:format)
		String pattern = "\\:([a-z]*)\\)";
		List<String> termList = new ArrayList<>();
		Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(booleanQuery);
	    while(m.find()) {
	    	 termList.add(m.group(1));
	    }   
	    String[] terms = termList.toArray(new String[termList.size()]);
		return terms;
	}

	//计算一个Qtext中的项t1,t2...相对下标为index代码段C的权重
	public Float[] calculate_Wtd(String booleanQuery,int index) {
		List<Float> weights = new ArrayList<Float>();
		String code_snippet=ASTNodeVisitor.methonList.get(index);
		String[] terms=get_term(booleanQuery);
		double max_idf=calculate_maxidf(terms);
		for(int i=0;i<terms.length;i++) {
		    /**************计算一个词word相对一个代码段C的权重***********************/
		    String term=terms[i];
			Float weight;
		    if(calculate_tf(term,code_snippet)==0) {
		    	weight=(float) 0.5;
		    }else {
		    	 weight=(float) (0.5+0.5*calculate_tf(term,code_snippet)*(idfs.get(i)/max_idf));
		    }
		    //System.out.println(weight);
		    weights.add(weight);
		}
		Float[] Weights = weights.toArray(new Float[weights.size()]);
		return Weights;
	}

	//计算一个Qapi中的项t1,t2...相对下标为index代码段C的权重
	public Float[] calculate_Wtd1(String booleanQuery,String API,int index,API_understanding au) {
		String code_snippet=ASTNodeVisitor.methonList.get(index);
		String[] terms=get_term(booleanQuery);
		double max_idf=calculate_maxidf(terms);
		List<Float> weights = new ArrayList<Float>();
		Float weight=au.API_relevant_list.get(API); 
		weights.add(weight);
		for(int i=0;i<terms.length;i++) {
		    /**************计算一个词word相对一个代码段C的权重***********************/
		    String term=terms[i];
		    if(calculate_tf(term,code_snippet)==0) {
		    	weight=(float) 0.5;
		    }else {
		    	 weight=(float) (0.5+0.5*calculate_tf(term,code_snippet)*(idfs.get(i)/max_idf));
		    }
		    //System.out.println(weight);
		    weights.add(weight);
		}
		Float[] Weights = weights.toArray(new Float[weights.size()]);
		return Weights;
	}
	
	
	//计算一个布尔表达式Qtext中的项t1,t2...相对一个布尔表达式Q的权重数组
	public Float[] calculate_Wtq(String booleanQuery,int index) {
		Float weight;
		String[] terms=get_term(booleanQuery);
		String code_snippet=ASTNodeVisitor.methonList.get(index);
		Map<String,Integer> codeTable=countKey(code_snippet);
		List<Float> weights = new ArrayList<Float>();
		for(String term:terms) {
			if (term != "" &&  codeTable.containsKey(term)) {
				if(ASTNodeVisitor.methonNameList.get(index).contains(term)) {
					weight=(float) 1.5;
				}else {
					weight=(float) 1;
				}
			}else {
				weight=(float) 0;
			}
			weights.add(weight);
		}
		Float[] Weights = weights.toArray(new Float[weights.size()]);
		return Weights;
	}

	//计算一个布尔表达式Qapi中的项t1,t2...相对一个布尔表达式Q的权重数组
	public Float[] calculate_Wtq1(String booleanQuery, int index) {
		Float weight;
		String[] terms=get_term(booleanQuery);
		String code_snippet=ASTNodeVisitor.methonList.get(index);
		Map<String,Integer> codeTable=countKey(code_snippet);
		List<Float> weights = new ArrayList<Float>();
		weights.add((float) 1.5);
		if(terms!=null) {
			for(String term:terms) {
				if (term != "" &&  codeTable.containsKey(term)) {
					if(ASTNodeVisitor.methonNameList.get(index).contains(term)) {
						weight=(float) 1.5;
					}else {
					weight=(float) 1;
					}
				}else {
					weight=(float) 0;
				}
				weights.add(weight);
			}
		}
		Float[] Weights = weights.toArray(new Float[weights.size()]);
		return Weights;
	}
	
	
	//计算一个布尔表达式Q与下标为index代码段C的相似度,传入权重数组，求得相似度
	public float calculate_sim(Float[] Wtds,Float[] Wtqs) {
		final int p=3;
		float sim=0;
		float sum=0;
		for(int i=0;i<Wtds.length;i++) {
			sim+=(float)Math.pow(Wtqs[i],p)*Math.pow(Wtds[i],p);
			sum+=(float)Math.pow(Wtqs[i],p);
		}
		if(sum==0) {
			return 0;
		}
		float sim1=(float) Math.pow((sim/sum),1.0/3);
		//System.out.println(sim1);
		return sim1;
	}

}


