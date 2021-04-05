package language.model.switchOn;

import language.model.Command;
import language.model.RequestsHTTP;
import yajco.annotation.Before;

public class SwitchOn extends Command {

    @Before("Zapni svetla")
    public SwitchOn() {
    }

    @Override
    public void execute() {
        RequestsHTTP request = new RequestsHTTP();
        request.executeCommand("on");
    }
}
