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
	 * @param Que   查询语句
	 * @param indexPath  索引存放位置
	 * @param WritePath   写入文本路径
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
		       System.out.println("查询结果的总条数："+ topDocs.totalHits);
		       /************写入文本**************/
		       PrintStream pStream = new PrintStream(WritePath);
			   PrintStream originalOutputStream = System.out;
			   System.setOut(pStream);
		       for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
		            //scoreDoc.doc属性就是document对象的id
		            //根据document的id找到document对象
		            Document document = indexSearcher.doc(scoreDoc.doc);
		            System.out.println("-->ID: "+scoreDoc.doc);
		            System.out.println("-->content: "+document.get("content"));
		            System.out.println("==========================================================");
		       }
		       System.setOut(originalOutputStream);
		       /************查询结束*****************/
		       System.out.println("查询已完成");
		       indexReader.close();
		}catch(Exception e){
    		e.printStackTrace();
    	}
  }
  
  
  
  
  
  
  
  
}
