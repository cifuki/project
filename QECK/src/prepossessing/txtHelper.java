package prepossessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.tartarus.snowball.ext.PorterStemmer;

public class txtHelper {
	
	//将驼峰命名法的单词分离
    private  String toLine(String word){
        Pattern humpPattern = Pattern.compile("[A-Z][a-z]");
        Matcher matcher = humpPattern.matcher(word);
        StringBuffer str = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(str, " "+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(str);
        return str.toString();
    }
    
    //词干提取
  	private  String stemTerm (String word) {
  		//String word="helping";
  	    PorterStemmer stem = new PorterStemmer();
  	    stem.setCurrent(word);
  	    stem.stem();
  	    return stem.getCurrent();
  		//System.out.println(result);  
  	}
  	
  	//删除停用词
  	private String deleteStopWord (String word) {
  		String[] stopword= {"a","an","and","are","as","at","be","but","by","for","if","in","into","is","it","no","not","of","on","or","such","that","the","their","then","there","these","they","this","to","was","will","with","how","I","Q","A"};
  		for(String sword:stopword) {
  			if(word.equals(sword)) 
  				return " ";
  		}
		return word;
  	}
  	
  //输入一个字符串句子返回一个字符串数组，每个元素都是一个单词
  	private String[] participle(String str) {
  		StringTokenizer st = new StringTokenizer(str," ,?.!:\"\"''\n#_");
      	List<String> wordList = new ArrayList<>();
      	while (st.hasMoreElements()) {
      	    wordList.add(st.nextToken().toLowerCase());
      	}
      	String[] words = wordList.toArray(new String[wordList.size()]);  
//      	for(String s:words) {
//      		System.out.println(s+"\n");
//      	}
  		return words;		
  	}
  	
    //对字符串进行处理
	public  String prepareline(String strLine) {
  		String[] words = participle(strLine);
        for (int i = 0; i < words.length; i++) {
			words[i]=this.toLine(words[i]);
        	words[i]=this.deleteStopWord(words[i]);
        	words[i]=this.stemTerm(words[i]);
        	//System.out.println(words[i]+"+++++++");
        }
        strLine="";
        for(int i=0;i<words.length;i++) {
       	 strLine=strLine.concat(words[i]+" ");
        }
  		return strLine;
  	}
  	
	//读入TXT文件，对文本进行分词等处理
  	public  void ReadWriteFile(String readpath,String writepath ) {
  		File DateDir = new File(readpath);
        for (File f : DateDir.listFiles()) {
             //文件名
             String fileName = f.getName();
             String file_Name=fileName.substring(0, fileName.lastIndexOf("."));
             try (FileReader reader = new FileReader(readpath+"\\".concat(fileName));
                     BufferedReader getcontent = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
             ) {
            	 file_Name=prepareline(file_Name);
            	 /* 写入Txt文件 */  
                 File writeTXT = new File(writepath+"\\"+file_Name+".txt");
                 // 如果没有则要建立一个新的.txt文件  
                 writeTXT.createNewFile(); // 创建新文件  
                 BufferedWriter out = new BufferedWriter(new FileWriter(writeTXT)); 
                 String line;
                 while ((line = getcontent.readLine()) != null) {
                     // 一次读入一行数据
                 	line=prepareline(line);
                    out.write(line);    
                    out.newLine(); 
                 } 
                 out.flush(); // 把缓存区内容压入文件  
                 out.close(); // 最后记得关闭文件  
             } catch (IOException e) {
                 e.printStackTrace();
             }
           }
      }
  	
  	@Test
    public  void APIMain() {
//    	String readpath = ".\\DATA\\Q&A"; 
//    	String writepath = ".\\DATA\\Q&A";
//        ReadWriteFile(readpath,writepath);
//    	System.out.println("文本处理已完成");
    }
}
