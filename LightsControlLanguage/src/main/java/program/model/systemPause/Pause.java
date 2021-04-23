package program.model.systemPause;
import program.model.Command;
import program.model.Number;
import yajco.annotation.Before;

import java.util.concurrent.TimeUnit;

/* Class represent PAUSE command
* Sleep system on concrete duration*/
public class Pause extends Command {

    private final Number duration;

    @Before("wait")
    public Pause( @Before("COLON") Number duration) {
        this.duration = duration;
    }

    @Override
    public void execute() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration.getNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
