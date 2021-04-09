package program.model.setLights;
import yajco.annotation.Before;

/* Zapis: [1..3:1..27], ... ,[1..3:1..27] -> #hex (LightColor)
* Zoznam vsetkych svetiel, ktore sa maju zmenit na konkretnu farbu
*/

public class Configuration {

    private LightColor lightColor;
    private Lights lights;

    public Configuration(Lights lights, @Before("->") LightColor lightColor) {
        this.lightColor = lightColor;
        this.lights = lights;
    }

    LightColor getLightColor() {
        return lightColor;
    }

    Lights getLights() {
        return lights;
    }
}
