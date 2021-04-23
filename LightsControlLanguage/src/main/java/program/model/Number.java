package program.model;
import program.model.Value;

/* Concrete value for all lights in command setLights
*/

public class Number extends Value {

    public Number(int number) {
        super.setValue(number);
    }

    public Number(String variable){
        super.setVariable(variable);
    }

    public int getNumber(){
        return super.getValue();
    }
}
