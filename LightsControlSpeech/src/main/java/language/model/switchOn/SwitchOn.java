package language.model.switchOn;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.Before;

public class SwitchOn extends Command {

    @Before("Zapni svetla")
    public SwitchOn() {
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        esc.executeCmd("on");
    }
}
