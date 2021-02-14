package program.openLab;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

// TODO - dokoncit HTTP poziadavky pre ovladanie
//  svetiel nacitanim udajov z jednotlivych prikazov

public class OpenLab {

    private static URL zapUrl;
    private static URL vypUrl;
    private static URL svetlaUrl;
    private static boolean vystup;

    OpenLab() {
        try {
            zapUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light/all-on");
            vypUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light/all-off");
            svetlaUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean zapniSvetla (){
        return zapVypSvetla(zapUrl);
    }

    public boolean vypniSvetla(){
        return zapVypSvetla(vypUrl);
    }

    private boolean zapVypSvetla(URL url){
        try {
            vystup = false;
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);

            int status = con.getResponseCode();
            vystup = status <= 299;
            con.disconnect();
            return vystup;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    TODO - treba vlozit pole svetiel
     */
    public boolean nastavSvetla(int trvanie){
        try {
            vystup = false;
            HttpURLConnection con = (HttpURLConnection)svetlaUrl.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            // TODO - SVETLA
            String jsonNaOdoslanie = spravaJson(trvanie);
            byte[] input = jsonNaOdoslanie.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            os.flush();
            os.close();

            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);

            int status = con.getResponseCode();
            vystup = status <= 299;
            con.disconnect();
            return vystup;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    TODO - pole svetiel do JSON
     */
    private String spravaJson(int trvanie){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"colors\":[");
//        for (LightNumber svetlo : svetla) {
//            if (svetlo != null) {
//                sb.append("\"");
//                sb.append(svetlo.getHex());
//                sb.append("\"");
//            }else{
//                sb.append("null");
//            }
//            sb.append(",");
//        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("], \"duration\":").append(trvanie).append("}");

        return sb.toString();
    }


}

