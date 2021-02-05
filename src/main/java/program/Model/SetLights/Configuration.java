package program.Model.SetLights;
import program.Model.SetLights.Fields.Color;
import yajco.annotation.After;

/* Zapis: [1..3:1..27].[1..3:1..27].[1..3:1..27], #hex (Color)
* Zoznam vsetkych svetiel, ktore sa maju zmenit na konkretnu farbu
*/

public class Configuration {

    private Color color;
    private Lines lines;

    public Configuration(@After(",") Lines lines , Color color) {
        this.color = color;
        this.lines = lines;
    }

    public Color getColor() {
        return color;
    }

    public Lines getLines() {
        return lines;
    }
}
