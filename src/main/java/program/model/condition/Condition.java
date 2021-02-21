package program.model.condition;

import program.model.ExpBool;
import program.model.Expression;
import program.model.Command;
import yajco.annotation.After;
import yajco.annotation.Before;

public class Condition extends Command {

    private ExpBool condition;
    private Command[] commands;

    @Before("if")
    public Condition(ExpBool condition, @Before("{") @After("}") Command[] commands) {
        this.condition = condition;
        this.commands = commands;
    }


    @Override
    public void execute() {
        if (condition.evaluateBool()){
            for(Command cmd : commands){
                cmd.execute();
            }
        }
    }
}
