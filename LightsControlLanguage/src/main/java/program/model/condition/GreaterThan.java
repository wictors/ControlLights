package program.model.condition;

import program.model.ExpBool;
import program.model.Expression;
import yajco.annotation.After;
import yajco.annotation.Before;

public class GreaterThan extends ExpBool {

    @Before("(")
    @After(")")
    public GreaterThan(Expression exp1, @Before(">") Expression exp2) {
        super(exp1,exp2);
    }

    @Override
    public boolean evaluateBool() {
        if (expEvaluateNull()) {
            return false;
        }
        return getExp1().getNumber() > getExp2().getNumber();
    }
}
