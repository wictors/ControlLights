package program.openLab;

import org.eclipse.paho.client.mqttv3.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* MQTT connection to OpenLab
* Send data via MQTT protocol to topic for control lights*/

public class OpenLabMQTT extends Connection {

    private static final String URL = System.getProperty("MQTT_URL");
    private static final String topic = System.getProperty("MQTT_TOPIC_LIGHTS");
    private static final int DEFAULT_DURATION = 0;
    private static IMqttClient sender;
    private static MqttConnectOptions options;

    public OpenLabMQTT() {
        String publisherId = UUID.randomUUID().toString();
        try {
            sender = new MqttClient(URL, publisherId);
            options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private boolean sendMessage(String msg, int duration){
        try {
            sender.connect(options);
            byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
            sender.publish(topic, new MqttMessage(bytes));

            TimeUnit.MILLISECONDS.sleep(duration);

            sender.disconnect();
            return true;
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean onLights() {
        String allOn = "{\"all\": \"000000ff\", \"duration\": 0}";
        return sendMessage(allOn, DEFAULT_DURATION);
    }

    @Override
    public boolean offLights() {
        String allOff = "{\"all\": \"00000000\", \"duration\": 0}";
        return sendMessage(allOff, DEFAULT_DURATION);
    }

    @Override
    public boolean setColorLights(String[] lights, int duration) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"light\": {");
        for(int i = 0; i<lights.length; i++){
            if (lights[i] != null){
                sb.append("\"").append(i).append("\"").append(": ");
                sb.append("\"").append(lights[i]).append("\",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}, \"duration\": ").append(duration).append("}");
        return sendMessage(sb.toString(), duration);
    }
}
