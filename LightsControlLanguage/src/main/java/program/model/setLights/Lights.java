package program.model.setLights;
import program.ExceptionInConfig;
import yajco.annotation.Separator;
import java.util.ArrayList;

/* After class Configuration
Concrete syntax for coordinates of lights
Notation --> [coordinates], ... ,[coordinates]
*/

public class Lights implements Config {

    private Coordinates[] coordinates;

    public Lights(@Separator(",") Coordinates[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public ArrayList<Integer> getLightsPosition() throws ExceptionInConfig {
        ArrayList<Integer> lightsPosition = new ArrayList<>();
        for (Coordinates coordinate : coordinates) {
            lightsPosition.addAll(coordinate.getLightsPosition());
        }
        return lightsPosition;
    }
}
