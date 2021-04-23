package program.model;

import program.ExceptionInConfig;

/*All command extends this class.
* Instance of this class is use in main class of language - Program*/
public abstract class Command {

    public abstract void execute() throws ExceptionInConfig;
}
