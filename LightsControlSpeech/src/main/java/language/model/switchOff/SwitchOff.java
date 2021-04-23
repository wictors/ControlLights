package language.model.switchOff;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.Before;

/*Speech command switch off all lights. 1 option at the moment*/

public class SwitchOff extends Command {

    @Before("vypni svetla")
    public SwitchOff() {
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        esc.executeCmd("off");
    }
}
