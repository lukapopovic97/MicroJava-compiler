// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class DesigNoArray extends Designator {

    private String desigName;

    public DesigNoArray (String desigName) {
        this.desigName=desigName;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName=desigName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigNoArray(\n");

        buffer.append(" "+tab+desigName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigNoArray]");
        return buffer.toString();
    }
}
