package program.model;
import java.util.HashMap;

/*Trieda pocas behu programu zabezpecuje uchovavanie a citanie
* premennych definovanych pouzivatelom*/

public class Variables {

    private HashMap<String,Integer> variables;

    public Variables() {
        variables = new HashMap<String,Integer>();
    }

    public void setVariable(String key, int value){
        variables.put(key, value);
    }

    public int getVariable(String key){
        return variables.get(key);
    }

    public boolean containsVariable(String key){
        return variables.containsKey(key);
    }
}
