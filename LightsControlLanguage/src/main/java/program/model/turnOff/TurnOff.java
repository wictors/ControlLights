package program.model.turnOff;
import program.instance.Instance;
import program.model.Command;
import yajco.annotation.Before;

/* CLass represent OFF command
Send request to OpenLab for switch off all lights
*/
public class TurnOff extends Command {

    @Before("off")
    public TurnOff() {
    }

    @Override
    public void execute() {
        Instance.INSTANCE.getConnection().offLights();
    }
}
