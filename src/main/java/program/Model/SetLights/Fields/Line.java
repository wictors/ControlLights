package program.Model.SetLights.Fields;
import program.Model.Value;

/* Hodnota oznacujuca rad svetiel na strope OpenLabu.
Pri pohlade na hlavnu obrazovku z lava 1. az 3 vpravo.
Prva cislica zo zapisu [1-3:1-27]
*/

public class Line extends Value {

    public Line(int number) {
        super(number);
    }

    // TODO: Kontrola rozsahu 1 - 3, inak nejaky default alebo chyba
    public int getLine(){
        return super.getValue();
    }

}
