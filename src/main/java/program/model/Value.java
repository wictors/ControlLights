package program.model;

/* Abstraktna trieda reprezentujuca ciselnu hodnotu v jazyku*/

import program.instance.Instance;

public abstract class Value {

    private int number;
    private String variable;
    private boolean isVariable = false;

    protected  void setVariable(String variable){
        isVariable = true;
        this.variable = variable;
    }

    protected void setNumber(int number){
        this.number = number;
    }

    protected int getValue() {
        if (isVariable){
            return Instance.INSTANCE.getVariables().getVariable(variable);
        }
        return number;
    }
}
