package language.model;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RequestsHTTP {

    private static final String base = "http://localhost:8080/";

    public RequestsHTTP() {
    }

    public void playConfig(String nameOfConfig){
        try {
            URL playConfigURL = new URL(base + "play2?name=" + nameOfConfig);
            postRequest(nameOfConfig, playConfigURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void executeCommand(String command){
        try {
            URL executeCmdURL = new URL(base + "execute?name=" + command);
            postRequest(command, executeCmdURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private void postRequest(String name, URL url){
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            connection.getResponseCode();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
