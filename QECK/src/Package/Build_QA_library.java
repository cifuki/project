package Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import prepossessing.txtHelper;

public class Build_QA_library {
	public  List<Float> SO_Score = new ArrayList<>();
	public  List<String> QAtxt = new ArrayList<>();
	
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
 
    //�õ�Q&Atxt��SO grade
    public void get_SO_Score(String dataPath) throws Exception {
    	File DateDir = new File(dataPath);
    	int i=1;
    	for (File f : DateDir.listFiles()) {
		    Reader r=new FileReader(dataPath+"\\"+i+".txt");
            BufferedReader br=new BufferedReader(r);
            int Q_score=0;
            int A_score=0;
            String line = null;
            String Q_A ="";
            String firstline=br.readLine();
            Q_score=Integer.parseInt(firstline);
            while ((line = br.readLine()) != null){
            	if(line.equals("===============================================================================================")) {
            		line=br.readLine();
            		A_score=Integer.parseInt(line);
            	}else {
            		Q_A=Q_A.concat(line);
            	}
            }
            QAtxt.add(Q_A);
            //ͶƱ���������ݻ��ܵ�list��
            float Score=(float) (0.7*Q_score + 0.3*A_score);
            SO_Score.add(Score);
            i++;
    	}
    }
    
    	
	//��������
    public  void createIndex(String indexPath) throws Exception {
    	File IndexDir =new File(indexPath);
        Directory directory = FSDirectory.open(IndexDir);
        
        Analyzer analyzer = new IKAnalyzer();  //ѡ��IK�ִ���
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //��Q_A�����ı�Ԥ����
        txtHelper th=new txtHelper();
        for(int i=0;i<QAtxt.size();i++) {
        	QAtxt.set(i,th.prepareline(QAtxt.get(i)));
        	Field ID_Field = new TextField("ID",String.valueOf(i+1) ,Store.YES);
            Field QA_Field = new TextField("content",QAtxt.get(i) , Store.YES);
          //����document����
            Document document = new Document();
            document.add(ID_Field);
            document.add(QA_Field);
            //������������д��������
            indexWriter.addDocument(document);
        }
        if(indexWriter !=null) 
        	indexWriter.close();
	}
    
    @Test
    public void Main() throws Exception {
    	String dataDir=".\\DATA\\Q&A";
    	String IndexDir=".\\DATA\\Q&A_index";
    	get_SO_Score(dataDir);
    	if(!existsIndex(IndexDir))
			createIndex(IndexDir);
    }

}
