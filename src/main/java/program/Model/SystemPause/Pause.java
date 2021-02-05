package program.Model.SystemPause;
import program.Model.Command;
import program.Model.SetLights.Fields.Duration;
import yajco.annotation.Before;

/* Trieda definujuca prikaz systemoveho cakania. Casovy interval po ktorom sa vykona dalsi prikaz.
 *  Rozsiruje zakladnu triedu prikaz (Command)
 *  V konkretnej syntaxi zapisana ako "PAUSE"
 * */
public class Pause extends Command {

    private final Duration number;
    @Before("wait")
    public Pause( @Before("COLON") Duration number) {
        this.number = number;
    }

    @Override
    public void execute() {
        System.out.println("Pauza systemu na: " + number.getValue() + " milisekund");
    }
}
