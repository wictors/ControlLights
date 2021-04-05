package language.model;

import yajco.annotation.Range;

public class Speech {

    private final Command[] commands;

    public Speech(@Range(minOccurs = 1) Command[] commands) {
        this.commands = commands;
    }

    public void execute(){
        for (Command cmd: commands) {
            cmd.execute();
        }
    }
}
