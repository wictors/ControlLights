package program.instance;
import program.model.Variables;
import program.openLab.Connection;
import program.openLab.OpenLabHTTP;
import program.openLab.OpenLabMQTT;

// Singelton factory for class Variables, Connection(abstract class)
public enum Instance {
    INSTANCE;
    private Variables variables;
    private Connection connection;

    // Instantce of variables class for language
    public Variables getVariables(){
        if(variables == null){
            variables = new Variables();
        }
        return variables;
    }

    /*  Instance of connection class to OpenLab.
    *   MQTT or HTTP. */
    public Connection getConnection() {
        if (connection == null){
            if(System.getProperty("CONNECTION").toUpperCase().equals("HTTP")){
                connection = new OpenLabHTTP();
            }else{
                connection = new OpenLabMQTT();
            }
        }
        return connection;
    }
}
