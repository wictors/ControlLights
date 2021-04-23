package program.model.setLights;
import program.ExceptionInConfig;
import yajco.annotation.*;
import java.util.ArrayList;

/* After Lights class
Concrete syntax inside []
Notation --> [columns1-3:numbers1-27] shortcut 1..27 (interval), separator ","
*/

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

    /* Change coordinates of light to concrete number of light in OpenLab */
    @Override
    public ArrayList<Integer> getLightsPosition() throws ExceptionInConfig {
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
