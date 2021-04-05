package program.model.turnOff;
import program.instance.Instance;
import program.model.Command;
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
//        Instance.INSTANCE.getConnection().offLights();
        System.out.println("Vypnut vsetky svetla");
    }
}
