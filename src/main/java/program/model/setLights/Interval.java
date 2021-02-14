package program.model.setLights;
import program.model.setLights.fields.LightNumber;
import yajco.annotation.Before;
import java.util.ArrayList;

/*Zapis koordinatov viacerych svetiel v jednoduchej aj skratenej forme
* Jendoducha [1,2,3:10,11,12,13,14,15]
* Skratena   [1..3:10..15]*/

public class Interval {

    private LightNumber lightNumber;
    private LightNumber startNumber;
    private LightNumber endNumber;


    public Interval(LightNumber lightNumber) {
        this.lightNumber = lightNumber;
    }

    public Interval(LightNumber startNumber, @Before("..") LightNumber endNumber){
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    //todo - startNUMBER < endNUMBER ... osetrit
    ArrayList<Integer> getIntervalNumbers (){
        ArrayList<Integer> numbers = new ArrayList<>();
        if (lightNumber == null){
            numbers.ensureCapacity(endNumber.getLightNumber() - startNumber.getLightNumber() + 1);
            for (int i = startNumber.getLightNumber(); i<= endNumber.getLightNumber(); i++){
                numbers.add(i);
            }
            return numbers;
        }
        numbers.add(lightNumber.getLightNumber());
        return numbers;
    }
}
