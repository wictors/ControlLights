package program.model.setLights;
import program.ExceptionInConfig;
import program.instance.Instance;
import program.model.Command;
import program.model.Number;
import program.openLab.Connection;
import yajco.annotation.After;
import yajco.annotation.Before;

/* Main class of SetLights command.
Basic notation --> lights:{duration}{...configurations...}
Send data to OpenLab via connection in execute method
*/
public class ConfigurationLights extends Command {

    private Number duration;
    private Configuration[] configurations;
    private static final int numberOfLights = 81;

    @Before("lights")
    public ConfigurationLights(@Before("COLON") Number duration,
                               @Before("{") @After("}") Configuration[] configurations)
    {
        this.duration = duration;
        this.configurations = configurations;
    }


    @Override
    public void execute() throws ExceptionInConfig {
        setLights();
    }

    private void setLights() throws ExceptionInConfig{
        Connection connection = Instance.INSTANCE.getConnection();
        String[] lights = new String[numberOfLights];
        for (Configuration configuration: configurations) {
            for (Integer light: configuration.getLights().getLightsPosition()) {
                lights[light-1] = configuration.getLightColor().getColor();
            }
        }
        connection.setColorLights(lights, duration.getNumber());
    }
}
