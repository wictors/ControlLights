package rest;
import language.Ola;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;


/* MAIN CLASS - HERE START PROJECT
* Load default properties and user properties
* Start SpringBoot server
* Start to hearing speech in OpenLab  */

@SpringBootApplication
public class Api {

    public static void main(String[] args) {
        if (loadProperties()) {
            SpringApplication.run(Api.class, args);
            Ola ola = new Ola(ConfigurationParser.getInstance());
            ola.hearing();
        }
    }

    public static boolean loadProperties() {
        Properties defaultProp = new Properties();
        Properties sysProp = System.getProperties();
        Properties userProp;
        try {
            defaultProp.load(Api.class.getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            System.err.println("File config.properties missed in dicertory Resources");
            return false;
        }
        Properties newSysProp = mergeProperties(defaultProp,sysProp);
        userProp = userConfigs();
        if (userProp != null){
            mergeProperties(newSysProp,userProp);
        }
        return true;
    }

    public static Properties mergeProperties(Properties... properties) {
        Properties mainProp = Stream.of(properties)
                .collect(Properties::new, Map::putAll, Map::putAll);
        System.setProperties(mainProp);
        return mainProp;
    }

    private static Properties userConfigs(){
        String basePath = System.getProperty("user.dir");
        Properties userProp = new Properties();
        try {
            InputStream input = new FileInputStream(basePath + "\\UserConfigs.properties");
            userProp.load(input);
        } catch (Exception e) {
            System.err.println("UserConfigs.properties not exists in " + basePath);
            return null;
        }
        return userProp;
    }
}
