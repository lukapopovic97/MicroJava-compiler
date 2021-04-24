// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class VoidMethodDeclaration extends MethodDecl {

    private MethodVoidName MethodVoidName;
    private FormParsOptional FormParsOptional;
    private VarDeclOptional VarDeclOptional;
    private StatementList StatementList;

    public VoidMethodDeclaration (MethodVoidName MethodVoidName, FormParsOptional FormParsOptional, VarDeclOptional VarDeclOptional, StatementList StatementList) {
        this.MethodVoidName=MethodVoidName;
        if(MethodVoidName!=null) MethodVoidName.setParent(this);
        this.FormParsOptional=FormParsOptional;
        if(FormParsOptional!=null) FormParsOptional.setParent(this);
        this.VarDeclOptional=VarDeclOptional;
        if(VarDeclOptional!=null) VarDeclOptional.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodVoidName getMethodVoidName() {
        return MethodVoidName;
    }

    public void setMethodVoidName(MethodVoidName MethodVoidName) {
        this.MethodVoidName=MethodVoidName;
    }

    public FormParsOptional getFormParsOptional() {
        return FormParsOptional;
    }

    public void setFormParsOptional(FormParsOptional FormParsOptional) {
        this.FormParsOptional=FormParsOptional;
    }

    public VarDeclOptional getVarDeclOptional() {
        return VarDeclOptional;
    }

    public void setVarDeclOptional(VarDeclOptional VarDeclOptional) {
        this.VarDeclOptional=VarDeclOptional;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodVoidName!=null) MethodVoidName.accept(visitor);
        if(FormParsOptional!=null) FormParsOptional.accept(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVoidName!=null) MethodVoidName.traverseTopDown(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseTopDown(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVoidName!=null) MethodVoidName.traverseBottomUp(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseBottomUp(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VoidMethodDeclaration(\n");

        if(MethodVoidName!=null)
            buffer.append(MethodVoidName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsOptional!=null)
            buffer.append(FormParsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclOptional!=null)
            buffer.append(VarDeclOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VoidMethodDeclaration]");
        return buffer.toString();
    }
}
