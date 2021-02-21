package program.model.condition;

import program.model.ExpBool;
import program.model.Expression;
import program.model.Number;
import yajco.annotation.After;
import yajco.annotation.Before;

public class GreaterEqThan extends ExpBool {

    @Before("(")
    @After(")")
    public GreaterEqThan(Expression exp1, @Before(">=") Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public boolean evaluateBool() {
        if (expEvaluateNull()) {
            return false;
        }
        return getExp1().getNumber() >= getExp2().getNumber();
    }
}
