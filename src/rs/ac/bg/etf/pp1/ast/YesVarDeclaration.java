// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class YesVarDeclaration extends VarDeclOptional {

    private VarDeclOptional VarDeclOptional;
    private VarDecl VarDecl;

    public YesVarDeclaration (VarDeclOptional VarDeclOptional, VarDecl VarDecl) {
        this.VarDeclOptional=VarDeclOptional;
        if(VarDeclOptional!=null) VarDeclOptional.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarDeclOptional getVarDeclOptional() {
        return VarDeclOptional;
    }

    public void setVarDeclOptional(VarDeclOptional VarDeclOptional) {
        this.VarDeclOptional=VarDeclOptional;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclOptional!=null) VarDeclOptional.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclOptional!=null) VarDeclOptional.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclOptional!=null) VarDeclOptional.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesVarDeclaration(\n");

        if(VarDeclOptional!=null)
            buffer.append(VarDeclOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesVarDeclaration]");
        return buffer.toString();
    }
}
