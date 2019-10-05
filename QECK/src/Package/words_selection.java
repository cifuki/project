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
	public int N = 5;  //ѡ��5���� 
	public List<String> QA_Pairs = new ArrayList<>();
	
	//����һ���ַ������ӷ���һ���ַ������飬ÿ��Ԫ�ض���һ������
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
	
	//��������õ��ʵ��ĵ�����
	private float calculate_df(String word, Search_QA_pairs sqp) {
			int df=0;
			for(int i=0;i<sqp.N;i++) {
				if(QA_Pairs.get(i).contains(word)) 
					df++;
			}
		    
		  	return df;
		}
		
	//�����ʱ�һ��D��ǰ���ǵ��ʣ������Ǹõ����������ĵ��г��ֵĴ���
	private Map<String, Float> countKey(String code_snippet) {
		Map<String,Float> docTable = new TreeMap<String,Float>();
		//String code_snippet=from_code_get_methon.methonList[i];
		txtHelper th=new txtHelper();
		code_snippet=th.prepareline(code_snippet);
		String[] words =  participle(code_snippet);
		// �ֵ�����븳ֵ
        for (String word :words) {
        	if (word != "" &&  docTable.containsKey(word)) {  //������ڴ�����1
        		Float num = docTable.get(word);    
                docTable.put(word, num+1);
             }
        	else if( word != "")     //�����ֵΪ1
        		docTable.put(word, (float) 1);
        }
        return docTable;
	}
	
	//����һ���ĵ����ÿ���ʵģ�TF*IDF��ֵ
	private Map<String, Float> calculate_W(String doc,Search_QA_pairs sqp) {
		Map<String, Float> docTable=countKey(doc);
		for (Entry<String, Float> entry : docTable.entrySet()) {     
		    float Value = entry.getValue(); 
		    String word=entry.getKey();
		    float df=calculate_df(word, sqp);
		    //�������25%����ɾ���������
		    if(df>(0.25*sqp.N)) {
		    	docTable.put(word,(float) 0);
		    }//�����������TF*IDF
		    else {
		    	//����TF��IDF
		    	double TF= Math.sqrt(Value);
				double IDF = Math.log((double)(sqp.N/(df+1)))+1;
		    	docTable.put(word,(float) (TF*IDF));
		    }
		}
		return docTable;
	}
	
	//�õ��ܵĴʱ�
	public Map<String, Float> get_alldoctable(Search_QA_pairs sqp) throws Exception {
		Map<String,Float> alldocTable = new TreeMap<String,Float>();
		/*********ΪQA_Pairs��ֵ**********/
		List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(sqp.QA.entrySet());
		for (Entry<String, Float> entry : list) {
			QA_Pairs.add(entry.getKey());
        }
		/*********���ϴʱ�***********/
		for(int i=0;i<sqp.N;i++) {
			Map<String, Float> docTable=calculate_W(QA_Pairs.get(i),sqp);
			for (Entry<String, Float> entry : docTable.entrySet()) {     
			    Float Value = entry.getValue(); 
			    String word=entry.getKey();
			    if(Value!=0.0) {
			    	if (alldocTable.containsKey(word)) {  //������������
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
	
	//ѡȡtop-N����
	public String get_words(Map<String, Float> alldocTable) {
		//��ֵ�Ӵ�С����  
        //��mapת��Ϊlist
        List<Map.Entry<String, Float>> list1 = new ArrayList<Map.Entry<String, Float>>(alldocTable.entrySet());
        //ͨ�����ϵıȽ�����ʵ������
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

