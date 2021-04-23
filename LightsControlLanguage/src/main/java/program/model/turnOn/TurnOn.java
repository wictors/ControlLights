package program.model.turnOn;
import program.instance.Instance;
import program.model.Command;
import yajco.annotation.Before;

/* CLass represent ON command
Send request to OpenLab for switch on all lights (white color)
*/
public class TurnOn extends Command {

    @Before("on")
    public TurnOn() {
        super();
    }

    @Override
    public void execute() {
        Instance.INSTANCE.getConnection().onLights();
    }
}
