package program.model.setLights;
import yajco.annotation.Separator;
import java.util.ArrayList;

/*
Zapis [1..3:1..27], ... ,[1..3:1..27]
Zhromazduje vsetky svetla, ktore maju byt ovplyvnene zo zapisu.
Zapis moze obsahovat zapis pre 3 rady sucasne alebo aj pre 1 samostatne
*/

public class Lights implements Config {

    private Coordinates[] coordinates;

    public Lights(@Separator(",") Coordinates[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public ArrayList<Integer> getLightsPosition() {
        ArrayList<Integer> lightsPosition = new ArrayList<>();
        for (Coordinates coordinate : coordinates) {
            lightsPosition.addAll(coordinate.getLightsPosition());
        }
        return lightsPosition;
    }
}
