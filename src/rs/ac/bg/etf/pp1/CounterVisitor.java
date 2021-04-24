package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.SingleFormParamDecl;
import rs.ac.bg.etf.pp1.ast.SingleFormParameterDeclaration;
import rs.ac.bg.etf.pp1.ast.SingleVarDecl;
import rs.ac.bg.etf.pp1.ast.VarDeclarationArray;
import rs.ac.bg.etf.pp1.ast.VarDeclarationNoArray;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {

	protected int count;
	
	public int getCount(){
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor{
	
		public void visit(SingleFormParameterDeclaration formParamDecl){
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(VarDeclarationNoArray varDecl){
			count++;
		}
		
		public void visit(VarDeclarationArray varDeclArray) {
			count++;
		}
	}
}
