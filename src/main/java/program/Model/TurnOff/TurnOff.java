package program.Model.TurnOff;
import program.Model.Command;
import yajco.annotation.Before;

/* Trieda definujuca prikaz vypnutia vsetkych svetiel.
*  Rozsiruje zakladnu triedu prikaz (Command)
*  V konkretnej syntaxi zapisana ako "OFF"
*/
public class TurnOff extends Command {

    @Before("off")
    public TurnOff() {
    }

    @Override
    public void execute() {
        System.out.println("Vypnut vsetky svetla");
    }
}
