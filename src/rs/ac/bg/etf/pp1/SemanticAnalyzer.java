package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean errorDetected = false;
	boolean global = false;
	int nVars;
	
	Struct currentTypeStruct;
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
    public void visit(ProgName progName) {
    	global = true;
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }

    public void visit(Type type){
    	if (type.getTypeName().toString().equals("int")) {
			type.struct = Tab.intType;
		} else if (type.getTypeName().toString().equals("char")) {
			type.struct = Tab.charType;
		} else if (type.getTypeName().toString().equalsIgnoreCase("bool")) {
			type.struct = new Struct(Struct.Bool);
		} else {
			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
			type.struct = Tab.noType;
		}
    	currentTypeStruct=type.struct;

    }
    
    public void visit(MethodTypeName methodTypeName){
    	global = false;
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(), methodTypeName.getType().struct);
    	methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
    }
    
    public void visit(TypeMethodDeclaration typeMethodDeclaration) {
    	Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
    }
    
    public void visit(VoidMethodDeclaration voidMethodDeclaration) {
    	Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
    }
    
    public void visit(MethodVoidName methodVoidName){
    	global = false;
    	currentMethod = Tab.insert(Obj.Meth, methodVoidName.getMethodName(), new Struct(0));
    	methodVoidName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodVoidName.getMethodName(), methodVoidName);
    }
    
    public void visit(NumConstDecl numConstDecl){
    	if (global == true) log.info("global");
		report_info("Deklaracija num konstante " + numConstDecl.getNumConstName(), numConstDecl);
		Obj node = Tab.find(numConstDecl.getNumConstName());
		if(node.equals(Tab.noObj)){
			if(currentTypeStruct.getKind() != Struct.Int) {
				report_error("Greska, simbol "+numConstDecl.getNumConstName()+ " nije odgovarajuceg tipa!" , numConstDecl);
				return;
			}
			node = Tab.insert(Obj.Con, numConstDecl.getNumConstName(), currentTypeStruct);
			node.setAdr(numConstDecl.getN1());
			log.info("U tabelu simbola uneta konstanta: " + numConstDecl.getNumConstName());
		}
		else {
			report_error("Greska, simbol "+numConstDecl.getNumConstName()+ " je vec deklarisan!" , numConstDecl);
		}
					
    }
    
    public void visit(BoolConstDecl boolConstDecl) {
    	if (global == true) log.info("global");
    	report_info("Deklaracija bool konstante " + boolConstDecl.getBoolConstName(), boolConstDecl);
    	Obj node = Tab.find(boolConstDecl.getBoolConstName());
    	if(node.equals(Tab.noObj)){
    		if(!boolConstDecl.getB1().equalsIgnoreCase("true") && !boolConstDecl.getB1().equalsIgnoreCase("false")) {
    			report_error("Greska, nemoguca vrednost za bool konstantu!" , boolConstDecl);
    		}
    		if(currentTypeStruct.getKind() != Struct.Bool) {
				report_error("Greska, simbol "+boolConstDecl.getBoolConstName()+ " nije odgovarajuceg tipa!"+currentTypeStruct.getKind() , boolConstDecl);
				return;
			}
			node = Tab.insert(Obj.Con, boolConstDecl.getBoolConstName(), currentTypeStruct);
			int val;
			if(boolConstDecl.getB1().equalsIgnoreCase("true")) {
				val = 1;
			}
			else val = 0;
			node.setAdr(val);
			log.info("U tabelu simbola uneta konstanta: " + boolConstDecl.getBoolConstName());
		}
		else {
			report_error("Greska, simbol "+boolConstDecl.getBoolConstName()+ " je vec deklarisan!" , boolConstDecl);
		}
    }
    
    public void visit(CharConstDecl charConstDecl) {
    	if (global == true) log.info("global");
		report_info("Deklaracija char konstante " + charConstDecl.getCharConstName(), charConstDecl);
		Obj node = Tab.find(charConstDecl.getCharConstName());
		if(node.equals(Tab.noObj)){
			if(currentTypeStruct.getKind() != Struct.Char) {
				report_error("Greska, simbol "+charConstDecl.getCharConstName()+ " nije odgovarajuceg tipa!" , charConstDecl);
				return;
			}
			node = Tab.insert(Obj.Con, charConstDecl.getCharConstName(), currentTypeStruct);
			node.setAdr(charConstDecl.getC1());
			log.info("U tabelu simbola uneta konstanta: " + charConstDecl.getCharConstName());
		}
		else {
			report_error("Greska, simbol "+charConstDecl.getCharConstName()+ " je vec deklarisan!" , charConstDecl);
		}
    }

	public void visit(VarDeclarationNoArray varDeclNoArray){
		if (global == true) log.info("global");
		report_info("Deklaracija promenljive " + varDeclNoArray.getVarName() , varDeclNoArray);
		Obj node = Tab.find(varDeclNoArray.getVarName());
		if(node.equals(Tab.noObj)){
			node = Tab.insert(Obj.Var, varDeclNoArray.getVarName(), currentTypeStruct);
			log.info("U tabelu simbola uneta promenljiva: " + varDeclNoArray.getVarName());
			varDeclCount++;
		}
		else {
			report_error("Greska, simbol "+varDeclNoArray.getVarName()+ " je vec deklarisan!" , varDeclNoArray);
		}
	}
	
	public void visit(VarDeclarationArray varDeclArray) {
		if (global == true) log.info("global");
		report_info("Deklaracija niza " + varDeclArray.getVarArrayName() , varDeclArray);
		Obj node = Tab.find(varDeclArray.getVarArrayName());
		if(node.equals(Tab.noObj)){
			Struct arrayTypeStruct = new Struct(Struct.Array);
			arrayTypeStruct.setElementType(currentTypeStruct);
			node = Tab.insert(Obj.Var, varDeclArray.getVarArrayName(), arrayTypeStruct);
			log.info("U tabelu simbola uneta promenljiva: " + varDeclArray.getVarArrayName());
			varDeclCount++;
		}
		else {
			report_error("Greska, simbol "+varDeclArray.getVarArrayName()+" je vec deklarisan!" , varDeclArray);
		}
	}
	
	public void visit(FormParameterNoArray formParameterNoArray) {
		report_info("Deklaracija promenljive " + formParameterNoArray.getFormParamName(), formParameterNoArray);
		Obj node = Tab.find(formParameterNoArray.getFormParamName());
		if(node.equals(Tab.noObj)){
			node = Tab.insert(Obj.Var, formParameterNoArray.getFormParamName(), currentTypeStruct);
			log.info("U tabelu simbola uneta promenljiva: " + formParameterNoArray.getFormParamName());
		}
		else {
			report_error("Greska, simbol " + formParameterNoArray.getFormParamName() + " je vec deklarisan!" , formParameterNoArray);
		}
	}
	
	public void visit(FormParameterArray formParameterArray) {
		report_info("Deklaracija niza " + formParameterArray.getFormParamArrayName() , formParameterArray);
		Obj node = Tab.find(formParameterArray.getFormParamArrayName());
		if(node.equals(Tab.noObj)){
			Struct arrayTypeStruct = new Struct(Struct.Array, currentTypeStruct);
			node = Tab.insert(Obj.Var, formParameterArray.getFormParamArrayName(), arrayTypeStruct);
			log.info("U tabelu simbola uneta promenljiva: " + formParameterArray.getFormParamArrayName() );
		}
		else {
			report_error("Greska, simbol "+formParameterArray.getFormParamArrayName() +" je vec deklarisan!" , formParameterArray);
		}
	}
	
	public void visit(DesigNoArray desigNoArray) {
		Obj obj=Tab.find(desigNoArray.getDesigName());
		if(obj.equals(Tab.noObj)) {
			report_error("Greska, koristi se simbol "+desigNoArray.getDesigName() +" koji nije deklarisan!" , desigNoArray);
		}
		else {
			if(obj.getLevel() != 0) {
				if(obj.getKind()==obj.Var) {
					report_info("Koristi se lokalna promenljiva " + desigNoArray.getDesigName(), desigNoArray);
				}
			}
			else {
				if(obj.getKind()==obj.Con) {
					report_info("Koristi se simbolicka konstanta " + desigNoArray.getDesigName(), desigNoArray);
				}
				else if(obj.getKind()==Obj.Var) {
					report_info("Koristi se globalna promenljiva " + desigNoArray.getDesigName(), desigNoArray);
				}
			}
		}
		desigNoArray.obj=obj;
	}
	
	public void visit(DesigArray desigArray) {
		Obj obj = Tab.find(desigArray.getArrayName().getArrayName());
		Struct expr = desigArray.getExpr().struct;
		if(expr.getKind()!=Struct.Int) {
			if(expr.getKind()==Struct.Array && expr.getElemType().getKind()==Struct.Int) {
				
			}
			else {
				report_error("Greska, izraz "+desigArray.getExpr()+" nije tipa int!", desigArray);
			}
		}
		desigArray.obj=obj;
	}
	
	public void visit(ArrayName arrayName) {
		Obj obj=Tab.find(arrayName.getArrayName());
		if(obj.equals(Tab.noObj)) {
			report_error("Greska, koristi se simbol "+arrayName.getArrayName()+" koji nije definisan!" , arrayName);
		}
		else {
			if(obj.getType().getKind()!=Struct.Array) {
				report_error("Greska, simbol "+arrayName.getArrayName()+" nije niz!", arrayName);
				
			}
			else {
				if(obj.getKind()==obj.Var) {
					if(obj.getLevel() != 0) {
						report_info("Koristi se lokalna promenljiva(niz) "+arrayName.getArrayName(), arrayName);
					}
					else report_info("Koristi se globalna promenljiva(niz) "+arrayName.getArrayName(), arrayName);
				}
				else if(obj.getKind()==obj.Con) {
					report_info("Koristi se simbolicka konstanta(niz) "+arrayName.getArrayName(), arrayName);
				} 
			}
		}
		arrayName.obj=obj;
	}
	
	public void visit(Read read) {
		if(read.getDesignator().obj.getKind()!=Obj.Var) {
			report_error("Greska, simbol "+read.getDesignator().obj.getName()+" nije promenjljiva niti element niza!", read);
		}
		if(read.getDesignator().obj.getType().getKind()!=Struct.Int && read.getDesignator().obj.getType().getKind()!=Struct.Char
				&& read.getDesignator().obj.getType().getKind()!=Struct.Bool && read.getDesignator().obj.getType().getKind()!=Struct.Array) {
			report_error("Greska, simbol "+read.getDesignator().obj.getName()+" nije tipa int, char ili bool!", read);
		}
	}
	
	public void visit(PrintExpr print) {
		if(print.getExpr().struct.getKind()!=Struct.Int && print.getExpr().struct.getKind()!=Struct.Char && 
				print.getExpr().struct.getKind()!=Struct.Bool && print.getExpr().struct.getKind()!=Struct.Array) {
			report_error("Greska, izraz "+print.getExpr()+" nije tipa int, char ili bool!", print);
		}
		printCallCount++;
	}
	
	public void visit(PrintExprNum print) {
		if(print.getExpr().struct.getKind()!=Struct.Int && print.getExpr().struct.getKind()!=Struct.Char && 
				print.getExpr().struct.getKind()!=Struct.Bool && print.getExpr().struct.getKind()!=Struct.Array) {
			report_error("Greska, izraz "+print.getExpr()+" nije tipa int, char ili bool!", print);
		}
		printCallCount++;
	}
	
	public void visit(NumConstFactor cnst) {
		cnst.struct = Tab.intType;
	}
	
	public void visit(CharConstFactor cnst) {
		cnst.struct = Tab.charType;
	}
	
	public void visit(BoolConstFactor cnst) {
		cnst.struct = new Struct(Struct.Bool);
	}
	
	public void visit(NewArrayFactor newArrayFact) {
		
		if(newArrayFact.getExpr().struct.getKind()!=Struct.Int) {
			report_error("Greska, izraz "+newArrayFact.getExpr()+" nije tipa int", newArrayFact);
			newArrayFact.struct = Tab.noType;
		}
		else {
			newArrayFact.struct = new Struct(Struct.Array);
			newArrayFact.struct.setElementType(newArrayFact.getType().struct);
		}
		
	}
	
	public void visit(ExprFactor exp) {
		exp.struct = exp.getExpr().struct;
	}
	
	public void visit(DesigNoParen desigNoParen){
		desigNoParen.struct=desigNoParen.getDesignator().obj.getType();
	}
	
	public void visit(SingleFactor singleFactor) {
/*		if(singleFactor.getFactor() instanceof DesigNoParen) {
			DesigNoParen dnp =(DesigNoParen)singleFactor.getFactor();
			singleFactor.struct=dnp.getDesignator().obj.getType();
		}
		else */
			singleFactor.struct=singleFactor.getFactor().struct;
	}
	
	public void visit(FactorList factorList) {
		
		Struct term=factorList.getTerm().struct;
		Struct factor=factorList.getFactor().struct;
		
		if(term.getKind()==Struct.Array && term.getElemType().getKind()==Struct.Int) {
			if(factor.getKind()==Struct.Array && factor.getElemType().getKind()==Struct.Int) {
				factorList.struct=Tab.intType;
				return;
			}
			else if(factor.getKind()==Struct.Int) {
				factorList.struct=Tab.intType;
				return;
			}
		}
		else if(term.getKind()== Struct.Int){
			if(factor.getKind()==Struct.Array && factor.getElemType().getKind()==Struct.Int) {
				factorList.struct=Tab.intType;
				return;
			}
			else if(factor.getKind()==Struct.Int) {
				factorList.struct=Tab.intType;
				return;
			}
		}
		report_error("Greska, svi operandi u izrazu moraju biti int tipa!", factorList);
	
	}
	
	public void visit(OnlyTerm onlyTerm) {
		onlyTerm.struct=onlyTerm.getTerm().struct;
	}
	
	public void visit(ExprAddopTerm exprAddopTerm) {
		Struct expr=exprAddopTerm.getNoTernaryOp().struct;
		Struct term=exprAddopTerm.getTerm().struct;
		
		if(expr.getKind()==Struct.Array && expr.getElemType().getKind()==Struct.Int) {
			if(term.getKind()==Struct.Array && term.getElemType().getKind()==Struct.Int) {
				exprAddopTerm.struct=expr.getElemType();
				return;
			}
			else if(term.getKind()==Struct.Int) {
				exprAddopTerm.struct=expr.getElemType();
				return;
			}
		}
		else if(expr.getKind()== Struct.Int){
			if(term.getKind()==Struct.Array && term.getElemType().getKind()==Struct.Int) {
				exprAddopTerm.struct=Tab.intType;
				return;
			}
			else if(term.getKind()==Struct.Int) {
				exprAddopTerm.struct=Tab.intType;
				return;
			}
		}
		
		report_error("Greska, svi operandi u izrazu moraju biti int tipa!", exprAddopTerm);
		
	}
	
	public void visit(MinusTerm minusTerm) {
		if(minusTerm.getTerm().struct.getKind()==Struct.Int || 
				(minusTerm.getTerm().struct.getKind()==Struct.Array && minusTerm.getTerm().struct.getElemType().getKind()==Struct.Int)) {
			minusTerm.struct=minusTerm.getTerm().struct;
		}
		else {
			report_error("Greska, simbol " + minusTerm+ " nije tipa int!", minusTerm);
			minusTerm.struct=Tab.noType;
		}
			
	}
	
	public void visit(DesigPlusPlus desigPlusPlus) {
		
		if(desigPlusPlus.getDesignator().obj.getKind()!=Obj.Var) {
			report_error("Greska, simbol " + desigPlusPlus.getDesignator().obj.getName()+ " nije promenjljiva!", desigPlusPlus);
			return;
		}
		if(desigPlusPlus.getDesignator().obj.getType().getKind()==Struct.Int || 
				(desigPlusPlus.getDesignator().obj.getType().getKind()==Struct.Array && desigPlusPlus.getDesignator().obj.getType().getElemType().getKind() == Struct.Int)) {
			
		}
		else {
			report_error("Greska, simbol " + desigPlusPlus.getDesignator().obj.getName()+ " nije tipa int!", desigPlusPlus);
		}
		
	}
	
	public void visit(DesigMinusMinus desigMinusMinus) {
		if(desigMinusMinus.getDesignator().obj.getKind()!=Obj.Var) {
			report_error("Greska, simbol " + desigMinusMinus.getDesignator().obj.getName()+ " nije promenjljiva!", desigMinusMinus);
			return;
		}
		if(desigMinusMinus.getDesignator().obj.getType().getKind()==Struct.Int || 
				(desigMinusMinus.getDesignator().obj.getType().getKind()==Struct.Array && desigMinusMinus.getDesignator().obj.getType().getElemType().getKind() == Struct.Int)) {
			
		}
		else {
			report_error("Greska, simbol " + desigMinusMinus.getDesignator().obj.getName()+ " nije tipa int!", desigMinusMinus);
		}
	}
	
	public void visit(DesigExpr desigExpr) {
		
		if(desigExpr.getDesignator().obj.getKind()!=Obj.Var) {
			report_error("Greska, "+desigExpr.getDesignator().obj.getName()+" nije promenljiva!", desigExpr);
			return;
		}
		
		Struct expr = desigExpr.getExpr().struct;
		Struct desig = desigExpr.getDesignator().obj.getType();
		
		if(desig.getKind()==Struct.Array) {
			if(expr.getKind()==Struct.Array) {
				if(desig.getElemType().getKind()!=expr.getElemType().getKind()) {
					report_error("Greska, tipovi nisu kompatibilni pri dodeli!", desigExpr);
					return;
				}
			}
			else {
				if(desig.getElemType().getKind()!=expr.getKind()) {
					report_error("Greska, tipovi nisu kompatibilni pri dodeli!", desigExpr);
					return;
				}
			}
		}
		else {
			if(expr.getKind()==Struct.Array) {
				if(desig.getKind()!=expr.getElemType().getKind()) {
					report_error("Greska, tipovi nisu kompatibilni pri dodeli!", desigExpr);
					return;
				}
			}
			else {
				if(desig.getKind()!=expr.getKind()) {
					report_error("Greska, tipovi nisu kompatibilni pri dodeli!", desigExpr);
					return;
				}
			}
		}
	}
	
	public void visit(YesTernaryOperator yesTernaryOperator) {
		Struct s=yesTernaryOperator.getNoTernaryOp().struct;
		if(s.getKind() == Struct.Bool || (s.getKind() == Struct.Array && s.getElemType().getKind() == Struct.Bool)
				|| s.getKind() == Struct.Int || (s.getKind() == Struct.Array && s.getElemType().getKind() == Struct.Int)) {
			if(yesTernaryOperator.getNoTernaryOp1().struct!=yesTernaryOperator.getNoTernaryOp2().struct) {
				report_error("Greska, drugi i treci operand moraju biti istog tipa!", yesTernaryOperator);
			}
			else yesTernaryOperator.struct=yesTernaryOperator.getNoTernaryOp1().struct;
		}
		else {
			report_error("Greska, prvi operand ternarnog operatora mora biti bool tipa!", yesTernaryOperator);
			return;
		}		
	}
	
	public void visit(NoTernaryOperator noTernaryOperator) {
		noTernaryOperator.struct=noTernaryOperator.getNoTernaryOp().struct;
	}
	
	public boolean passed(){
    	return !errorDetected;
    }
}
