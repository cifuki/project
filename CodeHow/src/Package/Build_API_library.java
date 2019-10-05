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
	
	//�ж��������Ƿ��Ѵ���
    public  boolean existsIndex(String indexPath) throws Exception {
        File file = new File(indexPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String indexSufix = "/segments.gen";
        // ���������ļ�segments.gen�Ƿ�����ж��Ƿ��ǵ�һ�δ�������
        File indexFile = new File(indexPath + indexSufix);
        return indexFile.exists();
    }
     
	//��������
    public  void createIndex(String dataPath,String indexPath) throws Exception {
    	File IndexDir =new File(indexPath);
    	File DateDir = new File(dataPath);
        Directory directory = FSDirectory.open(IndexDir);
        
        Analyzer analyzer = new IKAnalyzer();  //ѡ��IK�ִ���
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //ԭʼ�ĵ���·��
        for (File f : DateDir.listFiles()) {
             //�ļ���,ȥ����չ��
             String fileName = f.getName();
             fileName=fileName.substring(0, fileName.lastIndexOf("."));
             //�ļ�����
             String fileContent = FileUtils.readFileToString(f);
             //�ļ��Ĵ�С
             long fileSize  = FileUtils.sizeOf(f);

             //�����ļ�����
             //��һ���������������
             //�ڶ����������������
             //�������������Ƿ�洢
             Field fileNameField = new TextField("filename", fileName, Store.YES);
             //�ļ�������
             Field fileContentField = new TextField("content", fileContent, Store.YES);
             
             //����document����
             Document document = new Document();
             document.add(fileNameField);
             document.add(fileContentField);
             
             //������������д��������
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
