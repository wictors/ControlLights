package language.model.switchOff;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.Before;


public class SwitchOff extends Command {

    @Before("Vypni svetla")
    public SwitchOff() {
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        esc.executeCmd("off");
    }
}
