// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class NumConstDecl extends SingleConstDecl {

    private String numConstName;
    private Integer N1;

    public NumConstDecl (String numConstName, Integer N1) {
        this.numConstName=numConstName;
        this.N1=N1;
    }

    public String getNumConstName() {
        return numConstName;
    }

    public void setNumConstName(String numConstName) {
        this.numConstName=numConstName;
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
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
        buffer.append("NumConstDecl(\n");

        buffer.append(" "+tab+numConstName);
        buffer.append("\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConstDecl]");
        return buffer.toString();
    }
}
