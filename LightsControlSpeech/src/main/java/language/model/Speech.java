package language.model;

import language.ExecuteSpeechCmd;
import yajco.annotation.Range;

/* Main class of language (for generated parser)
All command are execute here
ExecuteSPeechCmd instance for send data to LightsControlLanguage via SpringApi module
This instance is in all command.
*/
public class Speech {

    private final Command[] commands;

    public Speech(@Range(minOccurs = 1) Command[] commands) {
        this.commands = commands;
    }

    public void execute(ExecuteSpeechCmd esc){
        for (Command cmd: commands) {
            cmd.execute(esc);
        }
    }
}
