package language.model;

/* Abstraktna trieda reprezentujuca jednotlivy cely prikaz v jazyku */

import language.ExecuteSpeechCmd;

public abstract class Command {

    public abstract void execute(ExecuteSpeechCmd esc);
}
