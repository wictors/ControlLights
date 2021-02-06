package program.Model.Loop;

import program.Instance.Instance;
import program.Model.Value;
import yajco.annotation.Before;

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

    public String getVariable() {
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
