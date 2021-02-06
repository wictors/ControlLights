package program.Model.Loop;

import yajco.annotation.*;

//@Parentheses
public class LoopParameters {

    private LoopParameterValue[] parameters;

    @Before("(")
    @After(")")
    public LoopParameters(@Separator("COLON") @Range(minOccurs = 3, maxOccurs = 3)
                                  LoopParameterValue[] parameters) {
        this.parameters = parameters;
    }

    public int getStartValue(){
        return parameters[0].getValue();
    }

    public int getRepetation(){
        return parameters[1].getValue();
    }

    public int getStep(){
        return parameters[2].getValue();
    }

    public String getVariable(){
        return parameters[0].getVariable();
    }
}
