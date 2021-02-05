package program.Model.SetLights;
import program.Model.SetLights.Fields.Light;
import program.Model.SetLights.Fields.Line;
import yajco.annotation.*;

import java.util.ArrayList;

/* Zapis [1..3:1..27]
* Definuje vsetky svetla zo zapisu podla toho v akom su rade
*  na ich skutocne hodnoty priradene v OpenLabe
* */

//@Parentheses(left = "[", right = "]")
public final class Lights implements Config {

    private static final int LIGHTSinLINE = 27;
    private final Line line;
    private final Light[] lights;
    private ArrayList<Integer> lightsPosition = new ArrayList<>();

    @Before("[")
    @After("]")
    public Lights(Line line, @Before("COLON") @Separator(",") @Range(minOccurs = 1, maxOccurs = 27)
                                Light[] lights)
    {
        this.line = line;
        this.lights = lights;
    }

    @Override
    public ArrayList<Integer> getLightsPosition() {
        lightsPosition.ensureCapacity(lights.length);
        for (Light light : lights) {
            lightsPosition.add(light.getLight() + (line.getLine()*LIGHTSinLINE) - LIGHTSinLINE);
        }
        return lightsPosition;
    }
}
