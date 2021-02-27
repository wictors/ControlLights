package program.model.setLights;
import program.instance.Instance;
import program.model.Command;
import program.model.Number;
import program.openLab.Connection;
import yajco.annotation.After;
import yajco.annotation.Before;

/* Zapis: lights:0..9+(duration){ [1..3:1..27], ... ,[1..3:1..27] -> color }
*  Celkove nastavenie svetiel aj s casovou dlzkou zmeny svetla
*  Moze byt zadanych viacero konfiguracii svetiel na konkretnu farbu v strukture
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
    public void execute() {
        //setLightsHTTP();
        System.out.println("Zmena svetiel bude trvat: " + duration.getNumber() + " milisekund");
        for (Configuration configuration: configurations) {
            System.out.print("Farba: " + configuration.getColor().getColor() + " pre svetla: ");
            for (Integer light: configuration.getLights().getLightsPosition()) {
                System.out.print(light + ", ");
            }
            System.out.println("");
        }
    }

    private void setLightsHTTP(){
        Connection connection = Instance.INSTANCE.getConnection();
        String[] lights = new String[numberOfLights];
        for (Configuration configuration: configurations) {
            for (Integer light: configuration.getLights().getLightsPosition()) {
                lights[light-1] = configuration.getColor().getColor();
            }
        }
        connection.setColorLights(lights, duration.getNumber());
    }
}
