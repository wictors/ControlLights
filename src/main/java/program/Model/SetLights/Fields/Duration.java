package program.Model.SetLights.Fields;
import program.Model.Value;

/* Trieda rozsirujuca ciselnu hodnotu.
Reprezentuje milisekundy pre pouzitie trvania systemovej pauzy alebo dlzky rozsvecovania svetiel
Sucast PAUSE a CONFIGURATIONLIGHTS (konfiguracie svetiel)
*/

public class Duration extends Value {

    public Duration(int number) { super.setNumber(number); }

    public Duration(String variable){
        super.setVariable(variable);
    }

    @Override
    public int getValue() {
        return super.getValue();
    }
}
