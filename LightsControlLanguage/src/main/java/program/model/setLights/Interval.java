package program.model.setLights;
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
    ArrayList<Integer> getIntervalNumbers (){
        ArrayList<Integer> numbers = new ArrayList<>();
        if (number == null){
            numbers.ensureCapacity(endNumber.getNumber() - startNumber.getNumber() + 1);
            for (int i = startNumber.getNumber(); i<= endNumber.getNumber(); i++){
                numbers.add(i);
            }
            return numbers;
        }
        numbers.add(number.getNumber());
        return numbers;
    }
}
