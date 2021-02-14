package program.instance;
import program.model.Variables;

/*Jedinecnost pozadovanych objektov v celom programe.
* Variables, OpenLab --> 1 instancia kdekolvek v programe*/

public enum Instance {
    INSTANCE;
    private Variables variables;
    //todo - instance of OpenLab

    public Variables getVariables(){
        if(variables == null){
            variables = new Variables();
        }
        return variables;
    }
}
