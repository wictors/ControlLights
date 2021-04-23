package program.model.setLights;
import yajco.annotation.Before;

/* Next concrete syntax after main class
Notation --> lights([Lights]) -> color(hex)
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
