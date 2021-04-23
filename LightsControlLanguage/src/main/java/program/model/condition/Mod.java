package program.model.condition;
import program.model.Expression;
import program.model.Number;
import yajco.annotation.After;
import yajco.annotation.Before;

// Math expression "%" - modulo.
// Extends abstract class Expression and evaluate value
public class Mod extends Expression {

    @Before("(")
    @After(")")
    public Mod(Number n1, @Before("%") Number n2) {
        super(n1, n2);
    }

    @Override
    public Number evaluate() {
        if (getFirst().getNumber() < getSecond().getNumber()){
            return null;
        }else {
            return new Number(getFirst().getNumber() % getSecond().getNumber());
        }
    }
}
