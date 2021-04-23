package program.model.setLights;
import program.ExceptionInConfig;
import program.model.Number;
import yajco.annotation.Before;
import java.util.ArrayList;

/* After Coordinates class
Concrete value in [:] coordinates or short interval with ".."
*/

public class Interval {

    private Number number;
    private Number startNumber;
    private Number endNumber;


    public Interval(Number startNumber, @Before("..") Number endNumber){
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    /*Interval with shortcut and check number range 1-27*/
    public Interval(Number number) {
        this.number = number;
    }
    ArrayList<Integer> getIntervalNumbers () throws ExceptionInConfig {
        ArrayList<Integer> numbers = new ArrayList<>();
        int num1;
        int num2;
        if (number == null){
            num1 = endNumber.getNumber();
            num2 = startNumber.getNumber();
            if (num2 > 0 && num2 < 28) {
                if ((num1 > 0 && num1 < 28)) {
                    if (num1 >= num2) {
                        numbers.ensureCapacity(endNumber.getNumber() - startNumber.getNumber() + 1);
                        for (int i = startNumber.getNumber(); i <= endNumber.getNumber(); i++) {
                            numbers.add(i);
                        }
                        return numbers;
                    } else {
                        throw new ExceptionInConfig("Start number of interval: " + num2
                                + " must be less or equal than: " + num2);
                    }
                } else {
                    throw new ExceptionInConfig("Number: " + num1 + " out of range 1-27");
                }
            } else {
                throw new ExceptionInConfig("Number: " + num2 + " out of range 1-27");
            }
        } else {
            num1 = number.getNumber();
            if (num1 > 0 && num1 < 28) {
                numbers.add(number.getNumber());
                return numbers;
            }else{
                throw new ExceptionInConfig("Number: " + num1 + " out of range 1-27");
            }
        }
    }
}
