package program.Model.SetLights.Fields;
import program.Model.Value;

/* Hodnota pre konkretne svetlo na strope v urcitom rade.
Cislovanie od hlavnej obrazovky 1 smerom ku vytahu 27
Druha cislica zo zapisu [1-3:1-27]
*/

public class Light extends Value {

    public Light(int number) {
        super(number);
    }

    // TODO: Kontrola rozsahu 1 - 27, inak nejaky default alebo chyba
    public int getLight(){
        return super.getValue();
    }
}
