package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.junit.Test;

import prepossessing.txtHelper;

public class words_selection {
	public int N = 5;  //选择5个词 
	public List<String> QA_Pairs = new ArrayList<>();
	
	//输入一个字符串句子返回一个字符串数组，每个元素都是一个单词
	private String[] participle(String str) {
		StringTokenizer st = new StringTokenizer(str," ,?.!:\"\"''\n#_");
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
	
	//计算包含该单词的文档个数
	private float calculate_df(String word, Search_QA_pairs sqp) {
			int df=0;
			for(int i=0;i<sqp.N;i++) {
				if(QA_Pairs.get(i).contains(word)) 
					df++;
			}
		    
		  	return df;
		}
		
	//构建词表（一个D）前面是单词，后面是该单词在这条文档中出现的次数
	private Map<String, Float> countKey(String code_snippet) {
		Map<String,Float> docTable = new TreeMap<String,Float>();
		//String code_snippet=from_code_get_methon.methonList[i];
		txtHelper th=new txtHelper();
		code_snippet=th.prepareline(code_snippet);
		String[] words =  participle(code_snippet);
		// 字典插入与赋值
        for (String word :words) {
        	if (word != "" &&  docTable.containsKey(word)) {  //如果存在次数加1
        		Float num = docTable.get(word);    
                docTable.put(word, num+1);
             }
        	else if( word != "")     //否则初值为1
        		docTable.put(word, (float) 1);
        }
        return docTable;
	}
	
	//计算一个文档里的每个词的（TF*IDF）值
	private Map<String, Float> calculate_W(String doc,Search_QA_pairs sqp) {
		Map<String, Float> docTable=countKey(doc);
		for (Entry<String, Float> entry : docTable.entrySet()) {     
		    float Value = entry.getValue(); 
		    String word=entry.getKey();
		    float df=calculate_df(word, sqp);
		    //如果超过25%，则删除这个单词
		    if(df>(0.25*sqp.N)) {
		    	docTable.put(word,(float) 0);
		    }//不超过则计算TF*IDF
		    else {
		    	//计算TF和IDF
		    	double TF= Math.sqrt(Value);
				double IDF = Math.log((double)(sqp.N/(df+1)))+1;
		    	docTable.put(word,(float) (TF*IDF));
		    }
		}
		return docTable;
	}
	
	//得到总的词表
	public Map<String, Float> get_alldoctable(Search_QA_pairs sqp) throws Exception {
		Map<String,Float> alldocTable = new TreeMap<String,Float>();
		/*********为QA_Pairs赋值**********/
		List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(sqp.QA.entrySet());
		for (Entry<String, Float> entry : list) {
			QA_Pairs.add(entry.getKey());
        }
		/*********整合词表***********/
		for(int i=0;i<sqp.N;i++) {
			Map<String, Float> docTable=calculate_W(QA_Pairs.get(i),sqp);
			for (Entry<String, Float> entry : docTable.entrySet()) {     
			    Float Value = entry.getValue(); 
			    String word=entry.getKey();
			    if(Value!=0.0) {
			    	if (alldocTable.containsKey(word)) {  //如果存在则加上
		        		Float num = alldocTable.get(word);
		        		alldocTable.put(word, num+Value);
		             }
		        	else {
		        		alldocTable.put(word,Value);
		        	} 
			    }
			}
		}
		return alldocTable;
	}
	
	//选取top-N个词
	public String get_words(Map<String, Float> alldocTable) {
		//将值从大到小排序  
        //将map转换为list
        List<Map.Entry<String, Float>> list1 = new ArrayList<Map.Entry<String, Float>>(alldocTable.entrySet());
        //通过集合的比较其来实现排序
        Collections.sort(list1,new Comparator<Map.Entry<String, Float>>() {
			@Override
			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
         });
//        for (Entry<String, Float> entry : list) {
//            System.out.println("ID:"+entry.getKey()+" grade:"+entry.getValue());
//        }
        System.out.println("==================================================================");
        String words = "";
        for(int i=0;i<N;i++) {
        	System.out.println("word:"+list1.get(i).getKey()+"\ngrade:"+list1.get(i).getValue());
        	words=words.concat(list1.get(i).getKey()+" ");
        }
        System.out.println("==================================================================");
        return words;
	}
		
	public String main(Search_QA_pairs sqp) throws Exception {
		Map<String,Float> alldocTable = get_alldoctable(sqp);
		String words=get_words(alldocTable);
		return words;
	}
	
}

