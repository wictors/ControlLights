package program.model;
import program.model.Value;

/* CIselna hodnota pre konkretne svetlo na strope v rade.
Cislovanie od hlavnej obrazovky 1 smerom ku vytahu 27
Cisla za dvojbodkou [1..3:1..27]
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
