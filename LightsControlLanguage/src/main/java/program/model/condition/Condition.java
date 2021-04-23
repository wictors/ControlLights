package program.model.condition;

import program.ExceptionInConfig;
import program.model.ExpBool;
import program.model.Command;
import yajco.annotation.After;
import yajco.annotation.Before;

// Main class of IF command.
// References other commands and ExpBool (Equal,Less,Greater,...)
public class Condition extends Command {

    private ExpBool condition;
    private Command[] commands1;
    private Command[] commands2;

    @Before("if")
    public Condition(ExpBool condition, @Before("{") @After("}") Command[] commands1) {
        this.condition = condition;
        this.commands1 = commands1;
    }

    @Before("if")
    public Condition(ExpBool condition, @Before("{") @After("}") Command[] commands1,
                     @Before("else{") @After("}") Command[] commands2) {
        this.condition = condition;
        this.commands1 = commands1;
        this.commands2 = commands2;
    }


    @Override
    public void execute() throws ExceptionInConfig {
        if (commands2 != null) {
            if (condition.evaluateBool()) {
                for (Command cmd : commands1) {
                    cmd.execute();
                }
            }else{
                for (Command cmd : commands2) {
                    cmd.execute();
                }
            }
        }else{
            if (condition.evaluateBool()) {
                for (Command cmd : commands1) {
                    cmd.execute();
                }
            }
        }
    }
}
