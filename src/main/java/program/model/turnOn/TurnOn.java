package program.model.turnOn;
import program.instance.Instance;
import program.model.Command;
import yajco.annotation.Before;

/* Trieda definujuca prikaz zapnutia vsetkych svetiel.
*  Rozsiruje zakladnu triedu prikaz (Command)
*  V konkretnej syntaxi zapisana ako "ON"
* */
public class TurnOn extends Command {

    @Before("on")
    public TurnOn() {
        super();
    }

    @Override
    public void execute() {
//        Instance.INSTANCE.getConnection().onLights();
        System.out.println("Zapnut vsetky svetla");
    }
}
