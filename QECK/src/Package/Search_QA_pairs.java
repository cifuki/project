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
	
	public  int N = 10;    //N个Q&A对
	public List<Float> lucenescore = new ArrayList<>();
	public Map<String,Float> QA = new TreeMap<String,Float>();
	
	public  void searchIndex(String path, String Que, Build_QA_library bqal) throws Exception {
    	File IndexDir =new File(path);
    	try {
    		//指定索引库存放的路径
            Directory directory = FSDirectory.open(IndexDir);
            //创建indexReader对象
            IndexReader indexReader = DirectoryReader.open(directory);
            //创建indexsearcher对象
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
       
			Analyzer analyzer = new IKAnalyzer();		//选用IK分词器
			//第一个参数是默认域
			QueryParser parser = new QueryParser("content", analyzer);
			//没写域就是默认域
			Query query = parser.parse(Que);
//			System.out.println(query);
			
			// 按照评分的值进行排序
			TopDocs tds = indexSearcher.search(query, N);
			
			for (ScoreDoc sd : tds.scoreDocs) {
				//System.out.println(sd.score+"\n");
				lucenescore.add(sd.score);
			}
			/*********计算最大最小值***************/
//			float minS=1000;
//			float maxS=0;
			float[] S= {1000,0}; //minS,maxS
//			float minL=1000;
//			float maxL=0;
			float[] L= {1000,0}; //minL,maxL
			S=get_SO_maxmin(bqal, S[0], S[1]);
			L=get_Lscore_maxmin(L[0], L[1]);
			/************存储Q&A和分数**************/
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

	/******得到SO分数的最大最小值*************/
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
	
	/********得到lucene分数的最大最小值*************/
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
	
	/***********得到最终分数**************/
	private float get_finalscore (Build_QA_library bqal,int index, float minS, float maxS, float minL, float maxL, int j) {
		index-=1;
		float finalscore =(lucenescore.get(j)-minL)/(maxL-minL)+(bqal.SO_Score.get(index)-minS)/(maxS-minS);
		return finalscore;
	}

	/*********输出分数最高的N个Q&A**********/
	public void print_Grade() {
		 //将值从大到小排序  
        //将map转换为list
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(QA.entrySet());
        //通过集合的比较其来实现排序
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
