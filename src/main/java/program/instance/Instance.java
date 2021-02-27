package program.instance;
import program.model.Variables;
import program.openLab.Connection;
import program.openLab.OpenLabHTTP;
import program.openLab.OpenLabMQTT;

/*Jedinecnost pozadovanych objektov v celom programe.
* Variables, OpenLabHTTP --> 1 instancia kdekolvek v programe*/

public enum Instance {
    INSTANCE;
    private Variables variables;
    private Connection connection;

    public Variables getVariables(){
        if(variables == null){
            variables = new Variables();
        }
        return variables;
    }

    /*  Instance of connection to OpenLab.
    *   MQTT or HTTP. */
    public Connection getConnection() {
        if (connection == null){
//            connection = new OpenLabHTTP();
            connection = new OpenLabMQTT();
        }
        return connection;
    }
}
