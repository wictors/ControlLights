package program.model.setLights;
import program.ExceptionInConfig;
import program.model.Number;
import yajco.annotation.Before;
import java.util.ArrayList;

/*Zapis koordinatov viacerych svetiel v jednoduchej aj skratenej forme
* Jendoducha [1,2,3:10,11,12,13,14,15]
* Skratena   [1..3:10..15]*/

public class Interval {

    private Number number;
    private Number startNumber;
    private Number endNumber;


    public Interval(Number startNumber, @Before("..") Number endNumber){
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public Interval(Number number) {
        this.number = number;
    }
    //todo - startNUMBER < endNUMBER ... osetrit
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
                        throw new ExceptionInConfig("Zaciatocne cislo intervalu: " + num2
                                + " musi byt mensie/rovne ako koncove cislo: " + num2);
                    }
                } else {
                    throw new ExceptionInConfig("Cislo: " + num1 + " mimo rozsahu 1-27");
                }
            } else {
                throw new ExceptionInConfig("Cislo: " + num2 + " mimo rozsahu 1-27");
            }
        } else {
            num1 = number.getNumber();
            if (num1 > 0 && num1 < 28) {
                numbers.add(number.getNumber());
                return numbers;
            }else{
                throw new ExceptionInConfig("Cislo: " + num1 + " je mimo rozsahu 1-27");
            }
        }
    }
}
