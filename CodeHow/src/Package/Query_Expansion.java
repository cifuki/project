package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause.Occur;

import ast.ASTNodeVisitor;


public class Query_Expansion {
	public Map<String,Float> Grade = new TreeMap<String,Float>();
	public int num=ASTNodeVisitor.methonList.size();
	//�з�
	private String[] participle(String str) {
		StringTokenizer st = new StringTokenizer(str," ,?.!:\"\"''\n#");
    	List<String> wordList = new ArrayList<>();
    	while (st.hasMoreElements()) {
    	    wordList.add(st.nextToken().toLowerCase());
    	}
    	String[] words = wordList.toArray(new String[wordList.size()]);  
//		    	for(String s:words) {
//		    		System.out.println(s+"+++");
//		    	}
		return words;	
	}
	
	//�õ���չ�������ʽ
	private BooleanQuery get_booleanQuery(String Que,String API) {
		 String[] words = participle(Que);
		/******************������ѯ���ʽ*************************/
    	if(API==null) {/*********************����Qtext***********************/
    		BooleanQuery booleanQuery=new BooleanQuery();
    		
            for(int i=0;i<words.length;i++) {
            	Term term1=new Term("methonName", words[i]);
            	Term term2=new Term("methonBody", words[i]);
            	TermQuery query1=new TermQuery(term1);
            	TermQuery query2=new TermQuery(term2);
            	BooleanQuery booleanQuery1=new BooleanQuery();
            	
                booleanQuery1.add(query1, Occur.SHOULD);
                booleanQuery1.add(query2, Occur.SHOULD);
                
                booleanQuery.add(booleanQuery1,Occur.MUST);
            }
           
            return booleanQuery;
    	}
    	else {/*********************����Qapi***********************/
    		BooleanQuery booleanQuery1=new BooleanQuery();
    
    		Term term=new Term("API", API);
    		TermQuery query=new TermQuery(term);
    		booleanQuery1.add(query,Occur.MUST);
    		
            for(String word:words) {
            	if(!API.contains(word)) {
            		Term term1=new Term("methonName", word);
                	Term term2=new Term("methonBody", word);
                	
                	TermQuery query1=new TermQuery(term1);
                	TermQuery query2=new TermQuery(term2);
                	BooleanQuery booleanQuery11=new BooleanQuery();
                	
                    booleanQuery11.add(query1, Occur.SHOULD);
                    booleanQuery11.add(query2, Occur.SHOULD);
                    booleanQuery1.add(booleanQuery11,Occur.MUST);
            	}
            }
            return booleanQuery1;
    	}
	}
	
	//�õ����еĲ������ʽ�����������ƶ�
	public void get_all_booleanQuery(String path,String Que,API_understanding au) throws Exception {
		/******************* ����Q_text*********************/
		BooleanQuery booleanQuery=get_booleanQuery(Que,null);
		System.out.println(booleanQuery);
		/******************����Q_text��d�����ƶ�**********************/
	    for(Integer i=0;i<num;i++) {
	    	VSM vsm=new VSM();
		    Float[] Wtds=vsm.calculate_Wtd(booleanQuery.toString(),i);
		    Float[] Wtqs=vsm.calculate_Wtq(booleanQuery.toString(),i);
		    float grade=vsm.calculate_sim(Wtds,Wtqs);
		    //System.out.println(grade);
		    String id=i.toString();
		    this.Grade.put(id, grade);  
	    }
		/**************** ����Q_api************************/
        for (Map.Entry<String, Float> entry : au.API_relevant_list.entrySet()) {     
		    Object key = entry.getKey(); 
		    String keying=key.toString();
		    BooleanQuery booleanQuery1=get_booleanQuery(Que,keying);
		    System.out.println(booleanQuery1);
		    /******************����Q_api��d�����ƶ�**********************/
		    for(Integer i=0;i<332;i++) {
		    	VSM vsm1=new VSM();
			    Float[] Wtds1=vsm1.calculate_Wtd1(booleanQuery.toString(),keying,i,au);
			    Float[] Wtqs1=vsm1.calculate_Wtq1(booleanQuery.toString(),i);
			    float grade1=vsm1.calculate_sim(Wtds1,Wtqs1);
			    //System.out.println(grade1);
			    Float num = Grade.get(i.toString()); 
			    String id=i.toString();
			    this.Grade.put(id, num+grade1);    //���ƶ����
		    }
		}
	}
	
	//������ƶ�����ʮ��
	public void print_Grade() {
		 //��ֵ�Ӵ�С����  
        //��mapת��Ϊlist
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(Grade.entrySet());
        //ͨ�����ϵıȽ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String, Float>>() {
			@Override
			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
         });
//        for (Entry<String, Float> entry : list) {
//            System.out.println("ID:"+entry.getKey()+" grade:"+entry.getValue());
//        }
        for(int i=0;i<10;i++) {
        	System.out.println("ID:"+list.get(i).getKey()+"\t grade:"+list.get(i).getValue());
        }
	}
	
	public void Main(String path,String Que, API_understanding au) throws Exception {
		this.get_all_booleanQuery(path, Que,au);
		this.print_Grade();
	}

}
