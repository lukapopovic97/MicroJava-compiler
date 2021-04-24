// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Designator Designator);
    public void visit(MethodDecl MethodDecl);
    public void visit(Factor Factor);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstDecl ConstDecl);
    public void visit(FormParsOptional FormParsOptional);
    public void visit(Expr Expr);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(FormPars FormPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(SingleConstDecl SingleConstDecl);
    public void visit(SingleFormParamDecl SingleFormParamDecl);
    public void visit(VarDecl VarDecl);
    public void visit(VarDeclOptional VarDeclOptional);
    public void visit(DeclPart DeclPart);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(Addop Addop);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(DeclList DeclList);
    public void visit(Statement Statement);
    public void visit(Term Term);
    public void visit(NoTernaryOp NoTernaryOp);
    public void visit(StatementList StatementList);
    public void visit(ProcOperation ProcOperation);
    public void visit(DivOperation DivOperation);
    public void visit(MulOperation MulOperation);
    public void visit(MinusOperation MinusOperation);
    public void visit(PlusOperation PlusOperation);
    public void visit(ArrayName ArrayName);
    public void visit(DesigArray DesigArray);
    public void visit(DesigNoArray DesigNoArray);
    public void visit(DesigNoParen DesigNoParen);
    public void visit(ExprFactor ExprFactor);
    public void visit(NewArrayFactor NewArrayFactor);
    public void visit(BoolConstFactor BoolConstFactor);
    public void visit(CharConstFactor CharConstFactor);
    public void visit(NumConstFactor NumConstFactor);
    public void visit(SingleFactor SingleFactor);
    public void visit(FactorList FactorList);
    public void visit(OnlyTerm OnlyTerm);
    public void visit(MinusTerm MinusTerm);
    public void visit(ExprAddopTerm ExprAddopTerm);
    public void visit(YesTernaryOperator YesTernaryOperator);
    public void visit(NoTernaryOperator NoTernaryOperator);
    public void visit(ErrorAssign ErrorAssign);
    public void visit(DesigMinusMinus DesigMinusMinus);
    public void visit(DesigPlusPlus DesigPlusPlus);
    public void visit(DesigExpr DesigExpr);
    public void visit(PrintExprNum PrintExprNum);
    public void visit(PrintExpr PrintExpr);
    public void visit(Read Read);
    public void visit(DesigStmt DesigStmt);
    public void visit(Type Type);
    public void visit(NoStatement NoStatement);
    public void visit(YesStatementList YesStatementList);
    public void visit(NoVarDeclaration NoVarDeclaration);
    public void visit(YesVarDeclaration YesVarDeclaration);
    public void visit(FormParameterNoArray FormParameterNoArray);
    public void visit(FormParameterArray FormParameterArray);
    public void visit(SingleFormParameterDeclaration SingleFormParameterDeclaration);
    public void visit(FormParameters FormParameters);
    public void visit(NoFormPars NoFormPars);
    public void visit(YesFormPars YesFormPars);
    public void visit(MethodVoidName MethodVoidName);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(VoidMethodDeclaration VoidMethodDeclaration);
    public void visit(TypeMethodDeclaration TypeMethodDeclaration);
    public void visit(SingleMethodDeclaration SingleMethodDeclaration);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(VarDeclarationArray VarDeclarationArray);
    public void visit(VarDeclarationNoArray VarDeclarationNoArray);
    public void visit(SingleVarDeclaration SingleVarDeclaration);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(ErrorVarDeclaration ErrorVarDeclaration);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(BoolConstDecl BoolConstDecl);
    public void visit(CharConstDecl CharConstDecl);
    public void visit(NumConstDecl NumConstDecl);
    public void visit(SingleConstDeclaration SingleConstDeclaration);
    public void visit(ConstDeclarationList ConstDeclarationList);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(VarDeclarationPart VarDeclarationPart);
    public void visit(ConstDeclarationPart ConstDeclarationPart);
    public void visit(NoDeclarations NoDeclarations);
    public void visit(DecarationlList DecarationlList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
