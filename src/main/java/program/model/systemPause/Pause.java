package program.model.systemPause;
import program.model.Command;
import program.model.Number;
import yajco.annotation.Before;

/* Trieda definujuca prikaz systemoveho cakania. Casovy interval po ktorom sa vykona dalsi prikaz.
 *  Rozsiruje zakladnu triedu prikaz (Command)
 *  V konkretnej syntaxi zapisana ako "PAUSE"
 * */
public class Pause extends Command {

    private final Number duration;

    @Before("wait")
    public Pause( @Before("COLON") Number duration) {
        this.duration = duration;
    }

    @Override
    public void execute() {
        System.out.println("Pauza systemu na: " + duration.getNumber() + " milisekund");
    }
}
