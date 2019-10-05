package ast;

import java.io.File;
import java.io.PrintStream;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class astMain {
	public  String path = ".\\DATA\\methonCodetest";
	
	public  void genast(String path) {
		CompilationUnit comp = GenAST.getCompilationUnit(path);
		ASTNodeVisitor visitor = new ASTNodeVisitor();
		comp.accept(visitor);
	}
	
	public  void main() throws Exception { 
		File file1=new File(path);
	   	 if(file1.exists()) {
	   		 File[] sf=file1.listFiles();
	   		 for(int i =0;i<sf.length;i++) {
	   			if(file1.isDirectory()) {
	   				genast(sf[i].getPath());
	   			}
	   			 }
	   		PrintStream pStream = new PrintStream(".\\DATA\\result2.txt");
		    PrintStream originalOutputStream = System.out;
			System.setOut(pStream);
	   		 for(int i=0;i<ASTNodeVisitor.methonList.size();i++) {
	   			System.out.println(ASTNodeVisitor.methonNameList.get(i));
	   			System.out.println(ASTNodeVisitor.methonBodyList.get(i));
	   			System.out.println("-------------------------------------------------");
	   			System.out.println(ASTNodeVisitor.APIStrList.get(i));
	   			System.out.println("=================================================");
	   		 }
	   		System.setOut(originalOutputStream);
	      } 
	}
}
