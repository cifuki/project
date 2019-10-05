package Package;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import prepossessing.txtHelper;

public class Search_code {
	public int N=10;
	/**
	 * 
	 * @param Que   ��ѯ���
	 * @param indexPath  �������λ��
	 * @param WritePath   д���ı�·��
	 * @throws Exception   
	 */
	public void searchCode(String Que,String WritePath) throws Exception{
		String indexPath=".\\DATA\\Code_index";
		try {
			   Directory directory = FSDirectory.open(new File(indexPath));
		       IndexReader indexReader = DirectoryReader.open(directory);
		       IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		       
		       Analyzer analyzer = new IKAnalyzer();
		       QueryParser parser = new QueryParser("content", analyzer);
		       Query query = parser.parse(Que);
		       TopDocs topDocs = indexSearcher.search(query, N);
		       System.out.println("��ѯ�������������"+ topDocs.totalHits);
		       /************д���ı�**************/
		       PrintStream pStream = new PrintStream(WritePath);
			   PrintStream originalOutputStream = System.out;
			   System.setOut(pStream);
		       for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
		            //scoreDoc.doc���Ծ���document�����id
		            //����document��id�ҵ�document����
		            Document document = indexSearcher.doc(scoreDoc.doc);
		            System.out.println("-->ID: "+scoreDoc.doc);
		            System.out.println("-->content: "+document.get("content"));
		            System.out.println("==========================================================");
		       }
		       System.setOut(originalOutputStream);
		       /************��ѯ����*****************/
		       System.out.println("��ѯ�����");
		       indexReader.close();
		}catch(Exception e){
    		e.printStackTrace();
    	}
  }
  
  
  
  
  
  
  
  
}
