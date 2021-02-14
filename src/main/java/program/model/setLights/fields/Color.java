package program.model.setLights.fields;

/*Trieda reprezentujuca farbu svetla v hexadecimalnom tvare
* Farba je udana priamo v texte konfiguracie
* Sucast prikazu pre nastavenie svetiel na pozadovanu farbu*/


// todo - Kontrola spravnosti HEX. Pokial je farba chybna default / chyba !!!
public class Color {

    private final String color;

    public Color(String hex) {
        this.color = hex;
    }

    public String getColor() {
        return color;
    }
}
