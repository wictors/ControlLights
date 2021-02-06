package program.Model.SetLights.Fields;
import program.Instance.Instance;
import program.Model.Value;
import program.Model.Variables;

/* Trieda rozsirujuca ciselnu hodnotu.
Reprezentuje milisekundy pre pouzitie trvania systemovej pauzy alebo dlzky rozsvecovania svetiel
Sucast PAUSE a CONFIGURATIONLIGHTS (konfiguracie svetiel)
*/

public class Duration extends Value {

    public Duration(int number) { super.setNumber(number); }

    public Duration(String variable){
        Variables variables = Instance.INSTANCE.getVariables();
        super.setNumber(variables.getVariable(variable));
    }

    @Override
    public int getValue() {
        return super.getValue();
    }
}
