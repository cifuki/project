package Package;

import prepossessing.txtHelper;

public class Main {

	public static void main(String[] args) throws Exception {
		String Que="how to read line by line?";
		String writePath="D:\\学习使我快乐\\JAVA\\QECK\\DATA\\search_result\\1.txt";
		txtHelper th =new txtHelper();
		Que=th.prepareline(Que);
		
		Build_code_library bcl=new Build_code_library();
		bcl.main();
		
		Build_QA_library bql=new Build_QA_library();
		bql.Main();
		
		Search_QA_pairs sqp=new Search_QA_pairs();
		sqp.Main(Que, bql);
		
		words_selection ws=new words_selection();
		String words=ws.main(sqp);
		Que=words.concat(Que);
		
		Search_code sc=new Search_code();
		sc.searchCode(Que, writePath);
  }
	
}
