package program.model.setLights.fields;
import program.model.Value;

/* CIselna hodnota pre konkretne svetlo na strope v rade.
Cislovanie od hlavnej obrazovky 1 smerom ku vytahu 27
Cisla za dvojbodkou [1..3:1..27]
*/

public class LightNumber extends Value {

    public LightNumber(int number) {
        super.setNumber(number);
    }

    public LightNumber(String variable){
        super.setVariable(variable);
    }

    // TODO: Kontrola rozsahu 1 - 27, inak nejaky default alebo chyba
    public int getLightNumber(){
        return super.getValue();
    }
}
