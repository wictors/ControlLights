package program.model;

//Basic class for Math and Boolean expression in condition
public class Expression {

    private Number n1;
    private Number n2;
    private Number n;

    public Expression(Number n1, Number n2){
        this.n1 = n1;
        this.n2 = n2;
    }

    public Expression(Number n){
        this.n = n;
    }

    protected Number getFirst() {
        return n1;
    }

    protected Number getSecond() {
        return n2;
    }

    public Number evaluate(){
        return n;
    }
}
