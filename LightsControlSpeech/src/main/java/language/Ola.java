package language;

import language.model.Speech;
import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;
import parser.ParseException;
import parser.SpeechParser;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Ola {

    private static final String COMMAND_OK = "Vykonavam prikaz";
    private static final String COMMAND_FAIL = "Nepoznam prikaz";

    private static final String URL = "tcp://openlab.kpi.fei.tuke.sk:1883";
    private static final String talkTopic = "openlab/audio";
    private static final String hearTopic = "experiments/voice/recognition/vs604qm";
    private static IMqttClient mqttClient;
    private static MqttConnectOptions options;
    private static SpeechParser speechParser;
    private static ExecuteSpeechCmd esc;

    public Ola(ExecuteSpeechCmd esc) {
        Ola.esc = esc;
        String subscriberId = UUID.randomUUID().toString();
        speechParser = new SpeechParser();
        try {
            mqttClient = new MqttClient(URL, subscriberId);
            options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            //options.setKeepAliveInterval(10);
            options.setConnectionTimeout(10);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void hearing(){
        mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) {
                JSONObject jsonmsg = new JSONObject(new String(mqttMessage.getPayload()));
                String status = jsonmsg.getString("status");
                if (status.equals("recognized")){
                    String speech = jsonmsg.getString("recognized");
                    try {
                        Speech command  = speechParser.parse(speech);
                        System.out.println("Rec: " + speech);
                        talking(true);
                        command.execute(esc);
                    } catch (ParseException e) {
                        talking(false);
                    }
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
        try {
            mqttClient.connect(options);
            mqttClient.subscribe(hearTopic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void talking(boolean isCmdOK){
        try {
            if (isCmdOK) {
                byte[] bytes = COMMAND_OK.getBytes(StandardCharsets.UTF_8);
                mqttClient.publish(talkTopic, new MqttMessage(bytes));
            } else {
                byte[] bytes = COMMAND_FAIL.getBytes(StandardCharsets.UTF_8);
                mqttClient.publish(talkTopic, new MqttMessage(bytes));
            }
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
}
