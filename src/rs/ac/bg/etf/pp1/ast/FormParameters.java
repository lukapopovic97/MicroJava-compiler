// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class FormParameters extends FormPars {

    private FormPars FormPars;
    private SingleFormParamDecl SingleFormParamDecl;

    public FormParameters (FormPars FormPars, SingleFormParamDecl SingleFormParamDecl) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.SingleFormParamDecl=SingleFormParamDecl;
        if(SingleFormParamDecl!=null) SingleFormParamDecl.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(SingleFormParamDecl!=null) SingleFormParamDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(SingleFormParamDecl!=null) SingleFormParamDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(SingleFormParamDecl!=null) SingleFormParamDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParameters(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleFormParamDecl!=null)
            buffer.append(SingleFormParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParameters]");
        return buffer.toString();
    }
}
