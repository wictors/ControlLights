package program.Model.SetLights;
import yajco.annotation.Range;
import yajco.annotation.Separator;
import java.util.ArrayList;

/*
Zapis [1..3:1..27].[1..3:1..27].[1..3:1..27]
Zhromazduje vsetky svetla, ktore maju byt ovplyvnene zo zapisu.
Zapis moze obsahovat zapis pre 3 rady sucasne alebo aj pre 1 samostatne
*/

public class Lines implements Config {

    private Lights[] lines;
    private ArrayList<Integer> lightsPosition = new ArrayList<>();

    public Lines(@Separator(".") @Range(minOccurs = 1, maxOccurs = 3) Lights[] lines) {
        this.lines = lines;
    }

    @Override
    public ArrayList<Integer> getLightsPosition() {
        for (Lights lights: lines) {
            lightsPosition.addAll(lights.getLightsPosition());
        }
        return lightsPosition;
    }
}
