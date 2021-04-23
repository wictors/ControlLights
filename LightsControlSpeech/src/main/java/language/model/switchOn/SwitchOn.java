package language.model.switchOn;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.After;
import yajco.annotation.Before;

/*Speech command switch on all lights.
* White color - first constructor
* Define color - second constructor
* Color must be define in properties else incorrect*/

public class SwitchOn extends Command {

    private String color;

    @Before("zapni svetla")
    public SwitchOn() {
    }

    @Before("zapni svetla")
    public SwitchOn(@After("farba") String name) {
        this.color = name.toUpperCase();
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        if (color == null) {
            esc.executeCmd("on");
        }else{
            String systemColor = System.getProperty(color);
            if (systemColor != null){
                esc.executeCmd("lights:0{ [1..3:1..27] -> " + systemColor + " }");
            }
        }
    }
}
