// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class FormParameterNoArray extends SingleFormParamDecl {

    private Type Type;
    private String formParamName;

    public FormParameterNoArray (Type Type, String formParamName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formParamName=formParamName;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormParamName() {
        return formParamName;
    }

    public void setFormParamName(String formParamName) {
        this.formParamName=formParamName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParameterNoArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formParamName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParameterNoArray]");
        return buffer.toString();
    }
}
