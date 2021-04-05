package language.model.switchOff;

import language.model.Command;
import language.model.RequestsHTTP;
import yajco.annotation.Before;

public class SwitchOff extends Command {

    @Before("Vypni svetla")
    public SwitchOff() {
    }

    @Override
    public void execute() {
        RequestsHTTP request = new RequestsHTTP();
        request.executeCommand("off");
    }
}
