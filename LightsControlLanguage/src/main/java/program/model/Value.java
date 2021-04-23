package program.model;

/* Generally values for classes from language model  */

import program.instance.Instance;

public abstract class Value {

    private int value;
    private String variable;
    private boolean isVariable = false;

    void setVariable(String variable){
        isVariable = true;
        this.variable = variable;
    }

    protected void setValue(int value){
        this.value = value;
    }

    protected int getValue() {
        if (isVariable){
            return Instance.INSTANCE.getVariables().getVariable(variable);
        }
        return value;
    }
}
