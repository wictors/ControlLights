package program.openLab;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class OpenLabHTTP extends Connection {

    private static URL onUrl;
    private static URL offUrl;
    private static URL changeLightsUrl;
    private static boolean responseOK;

    public OpenLabHTTP() {
        try {
            onUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light/all-on");
            offUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light/all-off");
            changeLightsUrl = new URL("https://openlab.kpi.fei.tuke.sk/rest/light");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean onLights(){
        return switchLights(onUrl);
    }

    public boolean offLights(){
        return switchLights(offUrl);
    }

    private boolean switchLights(URL url){
        try {
            responseOK = false;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            int status = connection.getResponseCode();
            responseOK = status <= 299;
            connection.disconnect();
            return responseOK;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean sendMessage(String message, int duration){
        try {
            responseOK = false;
            HttpURLConnection connection = (HttpURLConnection) changeLightsUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            OutputStream outStream = connection.getOutputStream();
            byte[] input = message.getBytes(StandardCharsets.UTF_8);
            outStream.write(input, 0, input.length);
            outStream.flush();
            outStream.close();

            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            int status = connection.getResponseCode();
            responseOK = status <= 299;

            TimeUnit.MILLISECONDS.sleep(duration);

            connection.disconnect();
            return responseOK;


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setColorLights(String[] lights, int duration){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"colors\":[");
        for (String light : lights) {
            if (light != null) {
                sb.append("\"");
                sb.append(light);
                sb.append("\"");
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("], \"duration\":").append(duration).append("}");

        return sendMessage(sb.toString(), duration);
    }
}

