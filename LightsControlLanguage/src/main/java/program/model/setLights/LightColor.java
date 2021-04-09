package program.model.setLights;

/*Trieda reprezentujuca farbu svetla v hexadecimalnom tvare
* Farba je udana priamo v texte konfiguracie
* Sucast prikazu pre nastavenie svetiel na pozadovanu farbu*/

import program.ExceptionInConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LightColor {

    private final String color;
    private static final String HEX_WEBCOLOR_PATTERN = "^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$";
    private static Pattern pattern = Pattern.compile(HEX_WEBCOLOR_PATTERN);

    public LightColor(String hex) {
        color = hex;
    }

    String getColor() throws ExceptionInConfig {
        if (color != null) {
            Matcher matcher = pattern.matcher(color);
            if (matcher.matches()){
                return color;
            }
            throw new ExceptionInConfig("Farba: " + color + " nie je HEX pre RGB. Zle cislo.");
        }
        throw new ExceptionInConfig("Chyba farba !");
    }
}