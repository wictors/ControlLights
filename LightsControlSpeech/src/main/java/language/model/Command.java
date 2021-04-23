package language.model;

/* *All command extends this class.
 * Instance of this class is use in main class of language - Speech*/

import language.ExecuteSpeechCmd;

public abstract class Command {

    public abstract void execute(ExecuteSpeechCmd esc);
}
