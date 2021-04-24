// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class NoTernaryOperator extends Expr {

    private NoTernaryOp NoTernaryOp;

    public NoTernaryOperator (NoTernaryOp NoTernaryOp) {
        this.NoTernaryOp=NoTernaryOp;
        if(NoTernaryOp!=null) NoTernaryOp.setParent(this);
    }

    public NoTernaryOp getNoTernaryOp() {
        return NoTernaryOp;
    }

    public void setNoTernaryOp(NoTernaryOp NoTernaryOp) {
        this.NoTernaryOp=NoTernaryOp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NoTernaryOp!=null) NoTernaryOp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoTernaryOperator(\n");

        if(NoTernaryOp!=null)
            buffer.append(NoTernaryOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoTernaryOperator]");
        return buffer.toString();
    }
}
