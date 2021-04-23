package language.model.playConfig;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.Before;

/*Speech command - play configuration {name of configuration}
* Accepted just file which are saved with lowercase and without numbers or spaces */

public class PlayConfig extends Command {

    private static String nameOfConfiguration;

    @Before("prehraj konfiguraciu")
    public PlayConfig(String name) {
        nameOfConfiguration = name;
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        esc.playConfig(nameOfConfiguration + ".txt");
    }
}
