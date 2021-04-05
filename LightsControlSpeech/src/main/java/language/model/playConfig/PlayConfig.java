package language.model.playConfig;

import language.model.Command;
import language.model.RequestsHTTP;
import yajco.annotation.Before;

public class PlayConfig extends Command {

    private static String nameOfConfiguration;

    @Before("Spusti konfiguraciu")
    public PlayConfig(String configuration) {
        nameOfConfiguration = configuration;
    }

    @Override
    public void execute() {
        RequestsHTTP request = new RequestsHTTP();
        request.playConfig(nameOfConfiguration + ".txt");
    }
}
