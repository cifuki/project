package Package;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
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


public class Build_API_library {
	
	//判断索引库是否已创建
    public  boolean existsIndex(String indexPath) throws Exception {
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
    public  void createIndex(String dataPath,String indexPath) throws Exception {
    	File IndexDir =new File(indexPath);
    	File DateDir = new File(dataPath);
        Directory directory = FSDirectory.open(IndexDir);
        
        Analyzer analyzer = new IKAnalyzer();  //选用IK分词器
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //原始文档的路径
        for (File f : DateDir.listFiles()) {
             //文件名,去掉扩展名
             String fileName = f.getName();
             fileName=fileName.substring(0, fileName.lastIndexOf("."));
             //文件内容
             String fileContent = FileUtils.readFileToString(f);
             //文件的大小
             long fileSize  = FileUtils.sizeOf(f);

             //创建文件名域
             //第一个参数：域的名称
             //第二个参数：域的内容
             //第三个参数：是否存储
             Field fileNameField = new TextField("filename", fileName, Store.YES);
             //文件内容域
             Field fileContentField = new TextField("content", fileContent, Store.YES);
             
             //创建document对象
             Document document = new Document();
             document.add(fileNameField);
             document.add(fileContentField);
             
             //创建索引，并写入索引库
             indexWriter.addDocument(document);
        }
        if(indexWriter !=null) 
        	indexWriter.close();
	}

    public void Main() throws Exception {
    	String dataDir=".\\DATA\\API_result";
    	String IndexDir=".\\DATA\\API_index";
    	if(!existsIndex(IndexDir))
			createIndex(dataDir, IndexDir);
    }

}
