package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{

	int printCallCount = 0;
	int varDeclCount = 0;
	
	Logger log = Logger.getLogger(getClass());

	public void visit(VarDeclarationNoArray vardeclnoarray){
		varDeclCount++;
	}
	
	public void visit(VarDeclarationArray vardeclarray) {
		varDeclCount++;
	}
	
    public void visit(PrintExpr print) {
		printCallCount++;
	}
    
    public void visit(PrintExprNum printn) {
    	printCallCount++;
    }

}
