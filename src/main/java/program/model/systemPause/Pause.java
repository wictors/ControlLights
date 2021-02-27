package program.model.systemPause;
import program.model.Command;
import program.model.Number;
import yajco.annotation.Before;

import java.util.concurrent.TimeUnit;

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
//        try {
//            TimeUnit.MILLISECONDS.sleep(duration.getNumber());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Pauza systemu na: " + duration.getNumber() + " milisekund");
    }
}
