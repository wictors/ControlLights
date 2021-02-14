package program.model.setLights;
import yajco.annotation.*;
import java.util.ArrayList;

/* Zapis [1..3:1..27]
* Definuje vsetky svetla zo zapisu podla toho v akom su rade
*  na ich skutocne hodnoty priradene v OpenLabe
* */


public final class Coordinates implements Config {

    private static final int LIGHTSinLINE = 27;
    private final Interval[] lineIntervals;
    private final Interval[] lightIntervals;

    @Before("[")
    @After("]")
    public Coordinates(@Separator(",")Interval[] lineIntervals,
                       @Before("COLON") @Separator(",") Interval[] lightIntervals)
    {
        this.lineIntervals = lineIntervals;
        this.lightIntervals = lightIntervals;
    }

    @Override
    public ArrayList<Integer> getLightsPosition() {
        ArrayList<Integer> lightsPosition = new ArrayList<>();
        for (Interval lineInterval : lineIntervals) {
            for (Integer line : lineInterval.getIntervalNumbers()) {
                for (Interval lightInterval : lightIntervals) {
                    for (Integer light : lightInterval.getIntervalNumbers()) {
                        lightsPosition.add(light + ((line - 1)*LIGHTSinLINE));
                    }
                }
            }

        }
        return lightsPosition;
    }
}
