package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private ArrayList<String> ops = new ArrayList<String>();
//	private ArrayList<Obj> objs = new ArrayList<Obj>();
	private int condIndicator=0;
	private boolean inArr;
	private int mainPc;
	private int adrToFix1;
	private int adrToFix2;
	
	
	public int getMainPc() {
		return mainPc;
	}

	public void visit(MethodTypeName methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getMethodName())) {
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();

		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);

		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}

	public void visit(MethodVoidName methodVoidName) {
		if ("main".equalsIgnoreCase(methodVoidName.getMethodName())) {
			mainPc = Code.pc;
		}
		methodVoidName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodVoidName.getParent();

		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);

		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}

	public void visit(TypeMethodDeclaration methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(VoidMethodDeclaration methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(PrintExpr printExpr) {
		if (printExpr.getExpr().struct.getKind() == Struct.Array) {
			if (printExpr.getExpr().struct.getElemType().getKind() == Struct.Int
					|| printExpr.getExpr().struct.getElemType().getKind() == Struct.Bool) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else {
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		} else {
			if (printExpr.getExpr().struct.getKind() == Struct.Int
					|| printExpr.getExpr().struct.getKind() == Struct.Bool) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else {
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		}
	}

	public void visit(PrintExprNum printExprNum) {
		int n = printExprNum.getN2().intValue();
		Struct e = printExprNum.getExpr().struct;
		if ((e.getKind() == Struct.Int) || (e.getKind() == Struct.Array && e.getElemType().getKind() == Struct.Int)
				|| (e.getKind() == Struct.Bool)
				|| (e.getKind() == Struct.Array && e.getElemType().getKind() == Struct.Bool)) {
			for (int i = 0; i < n - 1; i++) {
				Code.put(Code.dup);
				Code.loadConst(5);
				Code.put(Code.print);
			}
			Code.loadConst(5);
			Code.put(Code.print);
		} else {
			for (int i = 0; i < n - 1; i++) {
				Code.put(Code.dup);
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}

	public void visit(Read read) {
		
		Obj obj = read.getDesignator().obj;
		Struct s = obj.getType();
		if(s.getKind() == Struct.Array) {
			if(s.getElemType().getKind() == Struct.Int || s.getElemType().getKind() == Struct.Bool) {
				Code.put(Code.read);
				Code.put(Code.astore);
			}
			else {
				Code.put(Code.bread);
				Code.put(Code.bastore);
			}
		}
		else {
			if(s.getKind() == Struct.Int || s.getElemType().getKind() == Struct.Bool) {
				Code.put(Code.read);
			}
			else {
				Code.put(Code.bread);
			}
			Code.store(obj);
		}
	}

	public void visit(NumConstFactor numConstFactor) {
		Code.loadConst(numConstFactor.getN1().intValue());
	}

	public void visit(CharConstFactor charConstFactor) {
		Code.loadConst(charConstFactor.getC1().charValue());
	}

	public void visit(BoolConstFactor boolConstFactor) {
		if (boolConstFactor.getB1().equalsIgnoreCase("true")) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}

	public void visit(NewArrayFactor newArrayFactor) {
		Code.put(Code.newarray);
		if (newArrayFactor.getType().struct.getKind() == Struct.Char) {
			Code.put(0);
		} else
			Code.put(1);
		inArr=true;
	}


	public void visit(DesigExpr desigExpr) {
		Obj obj = desigExpr.getDesignator().obj;
		if(inArr) {
			Code.store(obj);
			inArr=false;
		}
		else if(obj.getType().getKind()==Struct.Array) {
			if(obj.getType().getElemType().getKind()==Struct.Int) {
				Code.put(Code.astore);
			}
			else {
				Code.put(Code.bastore);
			}
		}
		else
			Code.store(obj);
	}

	public void visit(DesigPlusPlus desigPlusPlus) {
		Code.loadConst(1);
		Code.put(Code.add);
		if(desigPlusPlus.getDesignator().obj.getType().getKind()==Struct.Array) {
			Code.put(Code.astore);
		}
		else 
			Code.store(desigPlusPlus.getDesignator().obj);
	}

	public void visit(DesigMinusMinus desigMinusMinus) {
		Code.loadConst(1);
		Code.put(Code.sub);
		if(desigMinusMinus.getDesignator().obj.getType().getKind()==Struct.Array) {
			Code.put(Code.astore);
		}
		else
			Code.store(desigMinusMinus.getDesignator().obj);
	}

	public void visit(MinusTerm minusTerm) {
		Code.put(Code.neg);
		
		
		
		SyntaxNode parent=minusTerm.getParent();
		if(parent instanceof YesTernaryOperator) {
			if(condIndicator==0) {
				Code.put(Code.const_1);
				Code.putFalseJump(Code.gt, 0);
				adrToFix1=Code.pc-2;
				condIndicator++;
				return;
			}
			if(condIndicator==1) {
				condIndicator++;
				Code.putJump(0);
				adrToFix2=Code.pc-2;
				Code.fixup(adrToFix1);
				return;
			}
			if(condIndicator==2) {
				Code.fixup(adrToFix2);
				condIndicator=0;
				return;
			}
		}
	}

	public void visit(PlusOperation add) {
		ops.add("add");
	}

	public void visit(MinusOperation sub) {
		ops.add("sub");
	}

	public void visit(MulOperation mul) {
		ops.add("mul");
	}

	public void visit(DivOperation div) {
		ops.add("div");
	}

	public void visit(ProcOperation per) {
		ops.add("rem");
	}

	public void visit(DesigNoArray desigNoArray) {
		SyntaxNode parent = desigNoArray.getParent();
		if ((parent instanceof DesigMinusMinus) || (parent instanceof DesigPlusPlus) || (parent instanceof DesigNoParen)) {
			Code.load(desigNoArray.obj);
		}
	}

	public void visit(DesigArray desigArray) {
		SyntaxNode parent = desigArray.getParent();
		if ((parent instanceof DesigMinusMinus) || (parent instanceof DesigPlusPlus)) {
			Code.put(Code.dup2);
			Code.put(Code.aload);
		}
		else if (parent instanceof DesigNoParen) {
			if(desigArray.obj.getType().getElemType().getKind()==Struct.Int) {
				Code.put(Code.aload);
			}
			else {
				Code.put(Code.baload);
			}			
		}
	}

	public void visit(ArrayName arrayName) {
/*		if(arrayName.getParent().getParent() instanceof DesigNoParen) {
			if(arrayName.getParent().getParent().getParent().getParent().getParent() instanceof YesTernaryOperator) {
				if(condIndicator==0) return;
				if(condIndicator==1 && cond==false) return;
				if(condIndicator==2 && cond==true) return;
			}
		}
*/		Code.load(arrayName.obj);
	}

	public void visit(ExprAddopTerm exprAddopTerm) {
		String op = ops.remove(ops.size() - 1);
		switch (op) {
		case "add":
			Code.put(Code.add);
			break;
		case "sub":
			Code.put(Code.sub);
			break;
		}
		
		
		
		SyntaxNode parent=exprAddopTerm.getParent();
		if(parent instanceof YesTernaryOperator) {
			if(condIndicator==0) {
				Code.put(Code.const_1);
				Code.putFalseJump(Code.gt, 0);
				adrToFix1=Code.pc-2;
				condIndicator++;
				return;
			}
			if(condIndicator==1) {
				condIndicator++;
				Code.putJump(0);
				adrToFix2=Code.pc-2;
				Code.fixup(adrToFix1);
				return;
			}
			if(condIndicator==2) {
				Code.fixup(adrToFix2);
				condIndicator=0;
				return;
			}
		}
		
		
		
	}

	public void visit(FactorList factorList) {
		String op = ops.remove(ops.size() - 1);
		switch (op) {
		case "mul":
			Code.put(Code.mul);
			break;
		case "div":
			Code.put(Code.div);
			break;
		case "rem":
			Code.put(Code.rem);
			break;
		}
 		
	}
	
	public void visit(OnlyTerm ot) {
		SyntaxNode parent=ot.getParent();
		if(parent instanceof YesTernaryOperator) {
			if(condIndicator==0) {
				Code.put(Code.const_1);
				Code.putFalseJump(Code.gt, 0);
				adrToFix1=Code.pc-2;
				condIndicator++;
				return;
			}
			if(condIndicator==1) {
				condIndicator++;
				Code.putJump(0);
				adrToFix2=Code.pc-2;
				Code.fixup(adrToFix1);
				return;
			}
			if(condIndicator==2) {
				Code.fixup(adrToFix2);
				condIndicator=0;
				return;
			}
		}
		
	}
	
	
}
