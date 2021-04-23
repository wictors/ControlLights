package program.model;
import java.util.HashMap;

/* Class save variables in language (for example in loop) */

public class Variables {

    private HashMap<String,Integer> variables;

    public Variables() {
        variables = new HashMap<>();
    }

    public void setVariable(String key, int value){
        variables.put(key, value);
    }

    int getVariable(String key){
        return variables.get(key);
    }

    public boolean containsVariable(String key){
        return variables.containsKey(key);
    }
}
