package program.model.setLights;
import program.model.Command;
import program.model.setLights.fields.Duration;
import yajco.annotation.After;
import yajco.annotation.Before;

/* Zapis: lights:0..9+(duration){ [1..3:1..27], ... ,[1..3:1..27] -> color }
*  Celkove nastavenie svetiel aj s casovou dlzkou zmeny svetla
*  Moze byt zadanych viacero konfiguracii svetiel na konkretnu farbu v strukture
*/
public class ConfigurationLights extends Command {

    private Duration duration;
    private Configuration[] configurations;

    @Before("lights")
    public ConfigurationLights(@Before("COLON") Duration duration,
                               @Before("{") @After("}") Configuration[] configurations)
    {
        this.duration = duration;
        this.configurations = configurations;
    }


    @Override
    public void execute() {
        System.out.println("Zmena svetiel bude trvat: " + duration.getValue() + " milisekund");
        for (Configuration configuration: configurations) {
            System.out.print("Farba: " + configuration.getColor().getColor() + " pre svetla: ");
            for (Integer light: configuration.getLights().getLightsPosition()) {
                System.out.print(light + ", ");
            }
            System.out.println("");
        }
    }
}
