package rest;
import language.Ola;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Api {

    public static void main(String[] args) {
        SpringApplication.run(Api.class, args);
        Ola ola = new Ola(ConfigurationParser.getInstance());
        ola.hearing();
    }
}
