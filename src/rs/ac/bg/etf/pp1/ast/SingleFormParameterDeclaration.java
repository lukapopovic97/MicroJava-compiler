// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class SingleFormParameterDeclaration extends FormPars {

    private SingleFormParamDecl SingleFormParamDecl;

    public SingleFormParameterDeclaration (SingleFormParamDecl SingleFormParamDecl) {
        this.SingleFormParamDecl=SingleFormParamDecl;
        if(SingleFormParamDecl!=null) SingleFormParamDecl.setParent(this);
    }

    public SingleFormParamDecl getSingleFormParamDecl() {
        return SingleFormParamDecl;
    }

    public void setSingleFormParamDecl(SingleFormParamDecl SingleFormParamDecl) {
        this.SingleFormParamDecl=SingleFormParamDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleFormParamDecl!=null) SingleFormParamDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleFormParamDecl!=null) SingleFormParamDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleFormParamDecl!=null) SingleFormParamDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleFormParameterDeclaration(\n");

        if(SingleFormParamDecl!=null)
            buffer.append(SingleFormParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleFormParameterDeclaration]");
        return buffer.toString();
    }
}
