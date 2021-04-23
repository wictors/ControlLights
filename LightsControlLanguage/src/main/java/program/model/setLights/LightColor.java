package program.model.setLights;

import program.ExceptionInConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Color in hexadecimal number
 * Check correct hexadecimal notation*/
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
            throw new ExceptionInConfig("Color: " + color + " is not HEX. Incorrect !");
        }
        throw new ExceptionInConfig("Missing color !");
    }
}