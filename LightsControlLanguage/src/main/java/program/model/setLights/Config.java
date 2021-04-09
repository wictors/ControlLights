package program.model.setLights;

import program.ExceptionInConfig;
import java.util.ArrayList;

public interface Config {

    ArrayList<Integer> getLightsPosition() throws ExceptionInConfig;
}
