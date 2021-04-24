// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class TypeMethodDeclaration extends MethodDecl {

    private MethodTypeName MethodTypeName;
    private FormParsOptional FormParsOptional;
    private VarDeclOptional VarDeclOptional;
    private StatementList StatementList;

    public TypeMethodDeclaration (MethodTypeName MethodTypeName, FormParsOptional FormParsOptional, VarDeclOptional VarDeclOptional, StatementList StatementList) {
        this.MethodTypeName=MethodTypeName;
        if(MethodTypeName!=null) MethodTypeName.setParent(this);
        this.FormParsOptional=FormParsOptional;
        if(FormParsOptional!=null) FormParsOptional.setParent(this);
        this.VarDeclOptional=VarDeclOptional;
        if(VarDeclOptional!=null) VarDeclOptional.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodTypeName getMethodTypeName() {
        return MethodTypeName;
    }

    public void setMethodTypeName(MethodTypeName MethodTypeName) {
        this.MethodTypeName=MethodTypeName;
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
        if(MethodTypeName!=null) MethodTypeName.accept(visitor);
        if(FormParsOptional!=null) FormParsOptional.accept(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeName!=null) MethodTypeName.traverseTopDown(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseTopDown(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.traverseBottomUp(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseBottomUp(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeMethodDeclaration(\n");

        if(MethodTypeName!=null)
            buffer.append(MethodTypeName.toString("  "+tab));
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
        buffer.append(") [TypeMethodDeclaration]");
        return buffer.toString();
    }
}
