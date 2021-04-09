package program.model;

/* Abstraktna trieda reprezentujuca jednotlivy cely prikaz v jazyku */

import program.ExceptionInConfig;

public abstract class Command {

    public abstract void execute() throws ExceptionInConfig;
}
