package program.model.loop;
import program.instance.Instance;
import program.model.Value;
import yajco.annotation.Before;

/*Concrete values of all parameters in loop
* Variable is saved to Variables class (second constructor)*/

public class LoopParameterValue extends Value {

    private String variable;

    public LoopParameterValue(int number) {
        super.setValue(number);
    }

    public LoopParameterValue(String variable, @Before("ASSIGN") int number){
        super.setValue(number);
        Instance.INSTANCE.getVariables().setVariable(variable, number);
        this.variable = variable;
    }

    String getVariable() {
        return variable;
    }

    @Override
    protected int getValue() {
        return super.getValue();
    }
}
