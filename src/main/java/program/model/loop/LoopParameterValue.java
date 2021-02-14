package program.model.loop;
import program.instance.Instance;
import program.model.Value;
import yajco.annotation.Before;

/*Hodnoty parametrov vratane definovania premennej v prvom parametri*/

public class LoopParameterValue extends Value {

    private String variable;

    public LoopParameterValue(int number) {
        super.setNumber(number);
    }

    public LoopParameterValue(String variable, @Before("=") int number){
        super.setNumber(number);
        Instance.INSTANCE.getVariables().setVariable(variable, number);
        this.variable = variable;
    }

    String getVariable() {
        if (variable == null){
            return "";
        }
        return variable;
    }

    @Override
    protected int getValue() {
        return super.getValue();
    }
}
