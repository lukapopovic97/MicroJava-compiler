// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class CharConstDecl extends SingleConstDecl {

    private String charConstName;
    private Character C1;

    public CharConstDecl (String charConstName, Character C1) {
        this.charConstName=charConstName;
        this.C1=C1;
    }

    public String getCharConstName() {
        return charConstName;
    }

    public void setCharConstName(String charConstName) {
        this.charConstName=charConstName;
    }

    public Character getC1() {
        return C1;
    }

    public void setC1(Character C1) {
        this.C1=C1;
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
        buffer.append("CharConstDecl(\n");

        buffer.append(" "+tab+charConstName);
        buffer.append("\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConstDecl]");
        return buffer.toString();
    }
}
