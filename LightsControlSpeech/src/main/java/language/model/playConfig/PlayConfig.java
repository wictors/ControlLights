package language.model.playConfig;

import language.ExecuteSpeechCmd;
import language.model.Command;
import yajco.annotation.Before;

public class PlayConfig extends Command {

    private static String nameOfConfiguration;

    @Before("Spusti konfiguraciu")
    public PlayConfig(String configuration) {
        nameOfConfiguration = configuration;
    }

    @Override
    public void execute(ExecuteSpeechCmd esc) {
        esc.playConfig(nameOfConfiguration + ".txt");
    }
}
