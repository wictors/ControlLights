package program.instance;
import program.model.Variables;
import program.openLab.OpenLabHTTPCon;

/*Jedinecnost pozadovanych objektov v celom programe.
* Variables, OpenLabHTTPCon --> 1 instancia kdekolvek v programe*/

public enum Instance {
    INSTANCE;
    private Variables variables;
    private OpenLabHTTPCon olHttp;
    //todo - instance of OpenLabHTTPCon

    public Variables getVariables(){
        if(variables == null){
            variables = new Variables();
        }
        return variables;
    }

    public OpenLabHTTPCon getOlHttp() {
        if (olHttp == null){
            olHttp = new OpenLabHTTPCon();
        }
        return olHttp;
    }
}
