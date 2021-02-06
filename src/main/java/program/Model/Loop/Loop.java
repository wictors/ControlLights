package program.Model.Loop;

import program.Instance.Instance;
import program.Model.Command;
import program.Model.Variables;
import yajco.annotation.After;
import yajco.annotation.Before;

public class Loop extends Command {

    private Command[] commands;
    private LoopParameters loopParameters;

    @Before("for")
    public Loop(LoopParameters loopParameters,
                @Before("{") @After("}") Command[] commands ) {
        this.loopParameters = loopParameters;
        this.commands = commands;
    }

    @Override
    public void execute() {
        int startValue = loopParameters.getStartValue();
        int step = loopParameters.getStep();
        int endValue = loopParameters.getRepetation() * step;
        String variable = loopParameters.getVariable();
        Variables variables = Instance.INSTANCE.getVariables();
        for (int i = startValue; i <= endValue; i+=step){
            if (variables.containsVariable(variable)){
                variables.setVariable(variable, i);
            }
            for (Command cmd: commands) {
                cmd.execute();
            }
        }
    }
}
