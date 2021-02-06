package program.Model;

/* Abstraktna trieda reprezentujuca ciselnu hodnotu v jazyku*/

public abstract class Value {

    private int number;

    protected void setNumber(int number){
        this.number = number;
    }

    protected int getValue() {
        return number;
    }
}
