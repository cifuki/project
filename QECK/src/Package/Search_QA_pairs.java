package Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
import org.apache.lucene.search.Collector;
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

import prepossessing.txtHelper;

public class Search_QA_pairs {
	
	public  int N = 10;    //N��Q&A��
	public List<Float> lucenescore = new ArrayList<>();
	public Map<String,Float> QA = new TreeMap<String,Float>();
	
	public  void searchIndex(String path, String Que, Build_QA_library bqal) throws Exception {
    	File IndexDir =new File(path);
    	try {
    		//ָ���������ŵ�·��
            Directory directory = FSDirectory.open(IndexDir);
            //����indexReader����
            IndexReader indexReader = DirectoryReader.open(directory);
            //����indexsearcher����
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
       
			Analyzer analyzer = new IKAnalyzer();		//ѡ��IK�ִ���
			//��һ��������Ĭ����
			QueryParser parser = new QueryParser("content", analyzer);
			//ûд�����Ĭ����
			Query query = parser.parse(Que);
//			System.out.println(query);
			
			// �������ֵ�ֵ��������
			TopDocs tds = indexSearcher.search(query, N);
			
			for (ScoreDoc sd : tds.scoreDocs) {
				//System.out.println(sd.score+"\n");
				lucenescore.add(sd.score);
			}
			/*********���������Сֵ***************/
//			float minS=1000;
//			float maxS=0;
			float[] S= {1000,0}; //minS,maxS
//			float minL=1000;
//			float maxL=0;
			float[] L= {1000,0}; //minL,maxL
			S=get_SO_maxmin(bqal, S[0], S[1]);
			L=get_Lscore_maxmin(L[0], L[1]);
			/************�洢Q&A�ͷ���**************/
			int j=0;
			for(ScoreDoc sd : tds.scoreDocs) {
				Document doc = indexSearcher.doc(sd.doc);
				int i=Integer.parseInt(doc.get("ID"));
				float finalscore=get_finalscore(bqal, i, S[0],S[1],L[0],L[1],j);
//				System.out.println(finalscore+"\n");
				QA.put(doc.get("content"), finalscore);
				j++;
			}
			indexReader.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}

	/******�õ�SO�����������Сֵ*************/
	private float[] get_SO_maxmin(Build_QA_library bqal,float minS,float maxS) {
		for(int i=0;i<bqal.SO_Score.size();i++) {
			float Score=bqal.SO_Score.get(i);
			if(Score>maxS)
				maxS=Score;
			if(Score<minS)
				minS=Score;
		}
		float[] S= {minS,maxS};
		return S;
	}
	
	/********�õ�lucene�����������Сֵ*************/
	private float[] get_Lscore_maxmin(float minL,float maxL) {
		for(int i=0;i<N;i++) {
			float score=lucenescore.get(i);
			if(score>maxL)
				maxL=score;
			if(score<minL)
				minL=score;
		}
		float[] L= {minL,maxL};
		return L;
	}
	
	/***********�õ����շ���**************/
	private float get_finalscore (Build_QA_library bqal,int index, float minS, float maxS, float minL, float maxL, int j) {
		index-=1;
		float finalscore =(lucenescore.get(j)-minL)/(maxL-minL)+(bqal.SO_Score.get(index)-minS)/(maxS-minS);
		return finalscore;
	}

	/*********���������ߵ�N��Q&A**********/
	public void print_Grade() {
		 //��ֵ�Ӵ�С����  
        //��mapת��Ϊlist
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(QA.entrySet());
        //ͨ�����ϵıȽ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String, Float>>() {
			@Override
			public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
				
				return o2.getValue().compareTo(o1.getValue());
			}
         });
//	        for (Entry<String, Float> entry : list) {
//	            System.out.println("ID:"+entry.getKey()+" grade:"+entry.getValue());
//	        }
        for(int i=0;i<N;i++) {
        	System.out.println("Q_A:"+list.get(i).getKey()+"\n grade:"+list.get(i).getValue());
        }
	}
	
	@Test
	public  void Main(String Que,Build_QA_library bqal) throws Exception {
		String IndexDir=".\\DATA\\Q&A_index";
    	searchIndex(IndexDir,Que,bqal);
    	print_Grade();
	}
	
	
	
	
	
	
	
	
	
	
}
