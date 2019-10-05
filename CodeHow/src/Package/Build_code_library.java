package Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import ast.ASTNodeVisitor;
import helper.txtHelper;


public class Build_code_library {
	public int num=ASTNodeVisitor.methonList.size();
	
	//对methodlist数据文本处理
	private void prepare_result(String path) throws Exception {
		PrintStream pStream = new PrintStream(path);
	    PrintStream originalOutputStream = System.out;
		System.setOut(pStream);
		txtHelper th=new txtHelper();
	    for(int i=0;i<num;i++) {
	    	 String methonName=ASTNodeVisitor.methonNameList.get(i);
	    	 ASTNodeVisitor.methonNameList.set(i, th.prepareline(methonName));
	    	 System.out.println(ASTNodeVisitor.methonNameList.get(i));
	    	 
	    	 String methonBody=ASTNodeVisitor.methonBodyList.get(i);
	    	 ASTNodeVisitor.methonBodyList.set(i, th.prepareline(methonBody));
	    	 System.out.println(ASTNodeVisitor.methonBodyList.get(i));
	    	 
	    	 String API=ASTNodeVisitor.APIStrList.get(i);
	    	 ASTNodeVisitor.APIStrList.set(i, th.prepareline(API));
	    	 System.out.println(ASTNodeVisitor.APIStrList.get(i));
	    	 
	    	 System.out.println("=====================================================================");
	      }
	      System.setOut(originalOutputStream);
	      System.out.println("文本处理已完成");
		
	}
	
	//判断索引库是否已创建
    public static boolean existsIndex(String indexPath) throws Exception {
        File file = new File(indexPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String indexSufix = "/segments.gen";
        // 根据索引文件segments.gen是否存在判断是否是第一次创建索引
        File indexFile = new File(indexPath + indexSufix);
        return indexFile.exists();
    }

    
	//创建索引
	public void createIndex(String path) throws Exception {
		//索引存放的文件夹
    	File IndexDir =new File(path);
        Directory directory = FSDirectory.open(IndexDir);
        Analyzer analyzer = new IKAnalyzer();	//选用IK分词器
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        
        //创建document对象
        Document document = new Document();
        for(int i=0;i<num;i++) {
	   	    String ID=String.valueOf(i);
	   		Field codeID = new TextField("ID",ID, Store.YES);
			Field methonField = new TextField("methon", ASTNodeVisitor.methonList.get(i), Store.YES);
            Field methonNameField = new TextField("methonName", ASTNodeVisitor.methonNameList.get(i), Store.YES);            
            Field methonBodyField = new TextField("methonBody", ASTNodeVisitor.methonBodyList.get(i), Store.YES);               
            Field APIField = new TextField("API", ASTNodeVisitor.APIStrList.get(i), Store.YES);
            
            document.add(codeID);
            document.add(methonField);
            document.add(methonNameField);
            document.add(methonBodyField);
            document.add(APIField);
   		}	         
	    //创建索引，并写入索引库
	    indexWriter.addDocument(document);    			 
          
        if(indexWriter !=null) 
        	indexWriter.close();
	}

	public void main(String indexPath) throws Exception {
		prepare_result(".\\DATA\\output.txt");
		if(!existsIndex(indexPath))
			createIndex(indexPath);
	}
	
	
	
}
