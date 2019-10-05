package Package;

import ast.astMain;
import helper.txtHelper;


public class Main {
		
	public static void main(String[] args) throws Exception {
		/**************************************************/
		String CodeIndex_path = ".\\DATA\\code_index";
		String Que="how to save an image in png format?";
		txtHelper th=new txtHelper();
		Que=th.prepareline(Que);
    	System.out.println("Que: "+Que);
		
		/************************�Ӵ�������ȡAPI��methon������*************************/
		astMain a=new astMain();
		a.main();
    	
		
		/************************����API��ʹ����********************************/
		Build_API_library bal=new Build_API_library();
		bal.Main();
		Build_code_library bcl=new Build_code_library();
		bcl.main(CodeIndex_path);
		
		/*********************API�������õ�API_relevant***************************/
		API_understanding au=new API_understanding();
		au=au.Main(Que);
		
		/**********************��չ��ѯ���ʽ�������ƶ�**********************************/
		Query_Expansion qe=new Query_Expansion();
		qe.Main(CodeIndex_path, Que, au);
		
	}
	
}
