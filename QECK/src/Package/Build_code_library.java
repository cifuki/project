package Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import prepossessing.txtHelper;

public class  Build_code_library{
	
	//判断索引库是否已创建
    public boolean existsIndex(String indexPath) throws Exception {
        File file = new File(indexPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String indexSufix = "/segments.gen";
        // 根据索引文件segments.gen是否存在判断是否是第一次创建索引
        File indexFile = new File(indexPath + indexSufix);
        return indexFile.exists();
    }

    public void createIndex(String dataDir,String IndexDir) throws Exception {
         Directory directory = FSDirectory.open(new File(IndexDir));
         Analyzer analyzer = new IKAnalyzer();
         IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
         IndexWriter indexWriter = new IndexWriter(directory, config);
         txtHelper th=new txtHelper();
         File dir = new File(dataDir);
         for (File f : dir.listFiles()) {
              String fileName = f.getName();
              fileName=th.prepareline(fileName);
              String fileContent = FileUtils.readFileToString(f);
              fileContent=th.prepareline(fileContent);
              
              Field fileNameField = new TextField("filename", fileName, Store.YES);
              Field fileContentField = new TextField("content", fileContent, Store.YES);
              
              Document document = new Document();
              document.add(fileNameField);
              document.add(fileContentField);
              
              //创建索引，并写入索引库
              indexWriter.addDocument(document);
         }
         //关闭indexwriter
         indexWriter.close();
    }
    
    @Test
	public void main() throws Exception {
		String dataDir=".\\DATA\\methonCodetest";
    	String IndexDir=".\\DATA\\Code_index";
		if(!existsIndex(IndexDir))
			createIndex(dataDir, IndexDir);
	}
	
}
