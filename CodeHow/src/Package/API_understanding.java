package Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import helper.txtHelper;

public class API_understanding {
	private  Vector APIpublicList = new Vector();    //<String,Float>
	private  Vector APInameList = new Vector();      //<String,Float>
	private  Vector APItextList = new Vector();		 //<String,Float>
	public  Map<String,Float> API_notoverlap_list = new TreeMap<String,Float>();  
	public  Map<String,Float> API_overlap_list = new TreeMap<String,Float>();
	public  Map<String,Float> API_relevant_list = new TreeMap<String,Float>();
	final int N=5;   //����������
	//��ѯ������
	public  void searchIndex(String path,String queryRegion, String Que) throws Exception {
    	File IndexDir =new File(path);
		Sort sort=new Sort(SortField.FIELD_SCORE);
    	try {
    		//ָ���������ŵ�·��
            //D:\temp\0108\index
            Directory directory = FSDirectory.open(IndexDir);
            //����indexReader����
            IndexReader indexReader = DirectoryReader.open(directory);
            //����indexsearcher����
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
       
			Analyzer analyzer = new IKAnalyzer();		//ѡ��IK�ִ���
			//��һ��������Ĭ����
			QueryParser parser = new QueryParser(queryRegion, analyzer);
			//ûд�����Ĭ����
			Query query = parser.parse(Que);
			//System.out.println(query);
			
			// �������ֵ�ֵ��������
			TopDocs tds = indexSearcher.search(query, N);
			Vector APIList = new Vector();
			for (ScoreDoc sd : tds.scoreDocs) {
				Document doc = indexSearcher.doc(sd.doc);
				
				APIList.addElement(doc.get("filename"));
//				System.out.println("-->filename: "+ doc.get("filename"));
				
				//System.out.println("-->content: "+  (doc.get("content"))+"\n");
				
				APIList.addElement(sd.score/10);
//				System.out.println("Grade: " +(sd.score/10)+"\n");
			}
			
			if(queryRegion.equals("filename"))
	    		this.APInameList=APIList;       
	    	if(queryRegion.equals("content"))
	    		this.APItextList=APIList;
	    	
			indexReader.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public  void get_overlap_list() {
		/*****************����һ��������publicList**********************/
		for(int j=0;j<(2*N);j+=2) {
			this.APIpublicList.add(this.APInameList.get(j));
			this.APIpublicList.add(this.APInameList.get(j+1));
		} 
		for(int j=0;j<(2*N);j+=2) {
			this.APIpublicList.add(this.APItextList.get(j));
			this.APIpublicList.add(this.APItextList.get(j+1));
		}
		/****************�ҳ���ͬ�� API_overlap_list************************/
		
		int[] flag = new int[(4*N)];
		for(int i=0;i<(4*N);i++) {flag[i]=1;}
		
		for(int i=0;i<(2*N);i+=2) {
			for(int j=0;j<(2*N);j+=2) {
				if(this.APInameList.get(i).toString().equals(this.APItextList.get(j).toString())) {
					Float grade=(Float) this.APInameList.get(i+1)+(Float)this.APItextList.get(j+1);
					this.API_overlap_list.put(this.APInameList.get(i).toString(), grade);
					flag[i]=0;
					flag[j+10]=0;
				}
			}
		}	
		/*****************�ҳ�����ͬ��д��API_notoverlap_list*********************/
		    for(int i=0;i<(4*N);i+=2) {
		    	if(flag[i]==1)
		    		this.API_notoverlap_list.put(this.APIpublicList.get(i).toString(),(Float)this.APIpublicList.get(i+1));
		    }
		    
		/*****************��ȡ���ֵ����Сֵ*******************************/
		float minscore=1;
		float maxscore=0;
		for (Map.Entry<String, Float> entry : this.API_overlap_list.entrySet()) {     
		    Float value = (Float) entry.getValue(); 
		    if(value<minscore)
		    	minscore=value;
		}
		for (Map.Entry<String, Float> entry : this.API_notoverlap_list.entrySet()) {     
		    Float value = (Float) entry.getValue(); 
		    if(value>maxscore)
		    	maxscore=value;
		}
//		System.out.println(maxscore);
//		System.out.println(minscore);
		
		/*********************��дAPI_notoverlap_list�ķ���******************************/
		for (Map.Entry<String, Float> entry : this.API_notoverlap_list.entrySet()) {     
		    Float value = (Float) entry.getValue(); 
		    Float grade = (float) ((minscore*value)/(maxscore+0.1));
		    this.API_notoverlap_list.put((String) entry.getKey(),grade);
		}
	}
	

	public void get_APIrelevant_list() {
		for (Map.Entry<String, Float> entry : this.API_overlap_list.entrySet()) {     
		    this.API_relevant_list.put(entry.getKey(),entry.getValue());
		}
		for (Map.Entry<String, Float> entry : this.API_notoverlap_list.entrySet()) {     
		    this.API_relevant_list.put(entry.getKey(),entry.getValue());
		}
		/********************** ��ֵ�Ӵ�С����  *********************/
        //��docTable.entrySet()ת��Ϊlist
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(API_relevant_list.entrySet());
        //ͨ�����ϵıȽ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String, Float>>() {
			@Override
			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
         });
//        for (Entry<String, Integer> entry : list) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
	}
 
	public API_understanding Main(String Que) throws Exception {
		API_understanding au=new API_understanding();
		String IndexDir=".\\DATA\\API_index";
    	//System.out.println("================================��filename��ѯ=============================");
    	au.searchIndex(IndexDir,"filename",Que);
    	//System.out.println("================================��content��ѯ==============================");
		au.searchIndex(IndexDir,"content",Que);
//		System.out.println("APInameList:"+APInameList);
//		System.out.println("APItextList:"+APItextList);
		
		au.get_overlap_list();
//		System.out.println("API_overlap_list:"+API_overlap_list);
//		System.out.println("API_notoverlap_list"+API_notoverlap_list);
		
		au.get_APIrelevant_list();
		System.out.println("API_relevantlist:"+au.API_relevant_list);
		return au;
    }
	
}
