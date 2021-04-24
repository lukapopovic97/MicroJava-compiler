// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class YesTernaryOperator extends Expr {

    private NoTernaryOp NoTernaryOp;
    private NoTernaryOp NoTernaryOp1;
    private NoTernaryOp NoTernaryOp2;

    public YesTernaryOperator (NoTernaryOp NoTernaryOp, NoTernaryOp NoTernaryOp1, NoTernaryOp NoTernaryOp2) {
        this.NoTernaryOp=NoTernaryOp;
        if(NoTernaryOp!=null) NoTernaryOp.setParent(this);
        this.NoTernaryOp1=NoTernaryOp1;
        if(NoTernaryOp1!=null) NoTernaryOp1.setParent(this);
        this.NoTernaryOp2=NoTernaryOp2;
        if(NoTernaryOp2!=null) NoTernaryOp2.setParent(this);
    }

    public NoTernaryOp getNoTernaryOp() {
        return NoTernaryOp;
    }

    public void setNoTernaryOp(NoTernaryOp NoTernaryOp) {
        this.NoTernaryOp=NoTernaryOp;
    }

    public NoTernaryOp getNoTernaryOp1() {
        return NoTernaryOp1;
    }

    public void setNoTernaryOp1(NoTernaryOp NoTernaryOp1) {
        this.NoTernaryOp1=NoTernaryOp1;
    }

    public NoTernaryOp getNoTernaryOp2() {
        return NoTernaryOp2;
    }

    public void setNoTernaryOp2(NoTernaryOp NoTernaryOp2) {
        this.NoTernaryOp2=NoTernaryOp2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.accept(visitor);
        if(NoTernaryOp1!=null) NoTernaryOp1.accept(visitor);
        if(NoTernaryOp2!=null) NoTernaryOp2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NoTernaryOp!=null) NoTernaryOp.traverseTopDown(visitor);
        if(NoTernaryOp1!=null) NoTernaryOp1.traverseTopDown(visitor);
        if(NoTernaryOp2!=null) NoTernaryOp2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.traverseBottomUp(visitor);
        if(NoTernaryOp1!=null) NoTernaryOp1.traverseBottomUp(visitor);
        if(NoTernaryOp2!=null) NoTernaryOp2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesTernaryOperator(\n");

        if(NoTernaryOp!=null)
            buffer.append(NoTernaryOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NoTernaryOp1!=null)
            buffer.append(NoTernaryOp1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NoTernaryOp2!=null)
            buffer.append(NoTernaryOp2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesTernaryOperator]");
        return buffer.toString();
    }
}
