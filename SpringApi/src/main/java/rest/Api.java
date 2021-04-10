package rest;
import language.Ola;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

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
        Properties prop = new Properties();
        Properties sysProp = System.getProperties();
        try {
            prop.load(Api.class.getResourceAsStream("/config.properties"));
            mergeProperties(prop,sysProp);
            return true;
        } catch (Exception e) {
            System.err.println("Chyba subor config.properties v adresari Resources");
            return false;
        }
    }

    public static void mergeProperties(Properties... properties) {
        Properties mainProp = Stream.of(properties)
                .collect(Properties::new, Map::putAll, Map::putAll);
        System.setProperties(mainProp);
    }
}
