// generated with ast extension for cup
// version 0.8
// 10/1/2021 13:56:32


package rs.ac.bg.etf.pp1.ast;

public class ExprAddopTerm extends NoTernaryOp {

    private NoTernaryOp NoTernaryOp;
    private Addop Addop;
    private Term Term;

    public ExprAddopTerm (NoTernaryOp NoTernaryOp, Addop Addop, Term Term) {
        this.NoTernaryOp=NoTernaryOp;
        if(NoTernaryOp!=null) NoTernaryOp.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public NoTernaryOp getNoTernaryOp() {
        return NoTernaryOp;
    }

    public void setNoTernaryOp(NoTernaryOp NoTernaryOp) {
        this.NoTernaryOp=NoTernaryOp;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NoTernaryOp!=null) NoTernaryOp.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NoTernaryOp!=null) NoTernaryOp.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprAddopTerm(\n");

        if(NoTernaryOp!=null)
            buffer.append(NoTernaryOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprAddopTerm]");
        return buffer.toString();
    }
}
