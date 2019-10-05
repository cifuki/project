package ast;

import java.beans.Expression;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
 
public class ASTNodeVisitor extends ASTVisitor {
 
	public Map m=new HashMap();//��¼�������������
	
	public static List<String> methonNameList = new ArrayList<>();
	public static List<String> methonBodyList = new ArrayList<>();
	public static List<String> methonList = new ArrayList<>();
	public static List<String> APIStrList = new ArrayList<>();
	public String APIStr="";

	//�õ�APIsq 
	@Override
	public boolean visit(MethodInvocation node) {
		if((m!=null) &&(node.getExpression()!=null)) {
		if(m.containsKey(node.getExpression().toString())) {
			//APIStr=APIStr+(m.get(node.getExpression().toString())+"."+node.getName().toString());
			APIStr=APIStr.concat(m.get(node.getExpression().toString())+"."+node.getName().toString());
			//System.out.println(m.get(node.getExpression().toString()));
			//System.out.println(node.getName().toString());
		}else {
			APIStr=APIStr.concat(node.getExpression().toString()+"."+node.getName().toString()+" ");
//			System.out.println(node.getExpression().toString());//obj
//			System.out.println(node.getName().toString());
//			System.out.println(APIStr);
			//APIStr=APIStr+(node.getExpression().toString()+"."+node.getName().toString());
			}
		}
	 return true;  
	}
	
	/*�õ������� ����������Parameter��
	 * ���������еı������滻�ɱ�������
	 * ��ȡtokens
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		String nodeName=node.getName().toString();
		String nodeBody=node.getBody().toString();
		methonNameList.add(nodeName);
		methonBodyList.add(nodeBody);
		for(Object s : node.getBody().statements()) {
			if(s instanceof VariableDeclarationStatement) {
				VariableDeclarationStatement d;
				d = (VariableDeclarationStatement)s;
				//System.out.println("Field:\t" + d.getType());
				
				for(Object f : d.fragments()) {
					VariableDeclarationFragment e=(VariableDeclarationFragment)f;
					//System.out.println("\t" + e.getName());
					m.put(e.getName().toString(), d.getType().toString());
				}
			}
		}
		return true;
	}
 
	
	@Override
	public void endVisit(TypeDeclaration node) {
		
		methonList.add(methonNameList.get(methonNameList.size()-1)+methonBodyList.get(methonBodyList.size()-1));
		APIStrList.add(this.APIStr);
	}
	
	
}