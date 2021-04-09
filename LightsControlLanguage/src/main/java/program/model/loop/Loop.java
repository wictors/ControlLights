package program.model.loop;
import program.ExceptionInConfig;
import program.instance.Instance;
import program.model.Command;
import program.model.Variables;
import yajco.annotation.After;
import yajco.annotation.Before;

/* Zakladna definicia prikazu cyklu FOR a vykonanie prikazov v nom*/

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
    public void execute() throws ExceptionInConfig {
        int startValue = loopParameters.getStartValue();
        int step = loopParameters.getStep();
        int endValue = loopParameters.getEndValue();
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
