package program.model;

public abstract class ExpBool {

    private Expression exp1;
    private Expression exp2;

    public ExpBool(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    protected boolean expEvaluateNull(){
        return (exp1.evaluate() == null) || (exp2.evaluate() == null);
    }

    protected Number getExp1() {
        return exp1.evaluate();
    }

    protected Number getExp2() {
        return exp2.evaluate();
    }

    public abstract boolean evaluateBool();
}
