// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class BoolConstDecl extends SingleConstDecl {

    private String boolConstName;
    private String B1;

    public BoolConstDecl (String boolConstName, String B1) {
        this.boolConstName=boolConstName;
        this.B1=B1;
    }

    public String getBoolConstName() {
        return boolConstName;
    }

    public void setBoolConstName(String boolConstName) {
        this.boolConstName=boolConstName;
    }

    public String getB1() {
        return B1;
    }

    public void setB1(String B1) {
        this.B1=B1;
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
        buffer.append("BoolConstDecl(\n");

        buffer.append(" "+tab+boolConstName);
        buffer.append("\n");

        buffer.append(" "+tab+B1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConstDecl]");
        return buffer.toString();
    }
}
