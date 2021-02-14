package program.model.setLights;
import program.model.setLights.fields.Color;
import yajco.annotation.Before;

/* Zapis: [1..3:1..27], ... ,[1..3:1..27] -> #hex (Color)
* Zoznam vsetkych svetiel, ktore sa maju zmenit na konkretnu farbu
*/

public class Configuration {

    private Color color;
    private Lights lights;

    public Configuration(Lights lights, @Before("->") Color color) {
        this.color = color;
        this.lights = lights;
    }

    Color getColor() {
        return color;
    }

    Lights getLights() {
        return lights;
    }
}
