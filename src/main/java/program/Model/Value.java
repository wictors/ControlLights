package program.Model;

/* Abstraktna trieda reprezentujuca ciselnu hodnotu v jazyku*/

public abstract class Value {

    private final int number;

    public Value(int number) {
        this.number = number;
    }

    protected int getValue() {
        return number;
    }
}
