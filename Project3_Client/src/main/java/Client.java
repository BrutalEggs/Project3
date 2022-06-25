import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * created by dmitrii.fateev
 */
public class Client {

    public static void main(String[] args) {
        String sensorName = "Sensor NEW";
        registerSensor(sensorName);

        Random random = new Random();

        for (int i = 0; i < 1000; i ++){
            sendMeasurements((random.nextFloat()*200-100), random.nextBoolean(), sensorName);
        }

    }


    private static void registerSensor(String name){
        String url = "http://localhost:8080/sensors/registration";
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("name",name);

        postRequest(url,jsonData);
    }

    private static void postRequest(String url, Map<String,Object> jsonData){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(jsonData,httpHeaders);
        restTemplate.postForObject(url,request,String.class);
    }

    private static void sendMeasurements(float value, boolean raining, String sensorName){
        String url = "http://localhost:8080/measurements/add";
        Map<String,Object> jsonData = new HashMap<>();
        jsonData.put("value",value);
        jsonData.put("raining",raining);
        jsonData.put("sensor",Map.of("name",sensorName));

        postRequest(url,jsonData);
    }
}
