package program.model.loop;
import yajco.annotation.*;


/* Notation --- x=1 to 5 step 2 {} /OR/ x=1 to 5 {} */
// Concrete syntax of loop parameters and define their variable
public class LoopParameters {

    private LoopParameterValue variable;
    private LoopParameterValue endValue;
    private LoopParameterValue stepValue;

    public LoopParameters(LoopParameterValue variable, @Before("to") LoopParameterValue endValue,
                          @Before("step") LoopParameterValue stepValue) {
        this.variable = variable;
        this.endValue = endValue;
        this.stepValue = stepValue;
    }

    public LoopParameters(LoopParameterValue variable, @Before("to") LoopParameterValue endValue) {
        this.variable = variable;
        this.endValue = endValue;
        this.stepValue = new LoopParameterValue(1); // DEFAULT 1
    }

    int getStartValue(){
        return variable.getValue();
    }

    int getEndValue(){
        return endValue.getValue();
    }

    int getStep(){
        return stepValue.getValue();
    }

    String getVariable(){
        return variable.getVariable();
    }
}
