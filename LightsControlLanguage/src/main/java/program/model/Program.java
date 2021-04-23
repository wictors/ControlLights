package program.model;
import program.ExceptionInConfig;
import yajco.annotation.Range;

/* Main class of language (for generated parser)
All command are execute here
*/

public class Program {

    private final Command[] commands;

    public Program(@Range(minOccurs = 1) Command[] commands) {
        this.commands = commands;
    }

    public void execute(){
        for (Command cmd: commands) {
            try {
                cmd.execute();
            } catch (ExceptionInConfig exceptionInConfig) {
                exceptionInConfig.printStackTrace();
            }
        }
    }

}
