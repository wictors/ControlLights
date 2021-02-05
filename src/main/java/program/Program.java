package program;
import program.Model.Command;
import yajco.annotation.Range;

/*Hlavna trieda reprezentujuca cely konfiguracny dokument
Zoznam vsetkych prikazov svetiel, ktore sa postupne vykonavaju, tak ako boli zapisane
Main class -->> package-info.java
 */

public class Program {

    private final Command[] commands;

    public Program(@Range(minOccurs = 1) Command[] commands) {
        this.commands = commands;
    }

    public void execute(){
        for (Command cmd: commands) {
            cmd.execute();
        }
    }

}
