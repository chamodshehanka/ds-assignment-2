package com.fantastic4;

import com.fantastic4.models.SensorDTO;
import com.fantastic4.models.SensorData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class SendSensorData extends TimerTask{

    private final HttpClient client;

    public SendSensorData() {
        client = HttpClient.newHttpClient();
    }

    public void run(){
        try {
            List<SensorDTO> sensorDTOS = getSensors();
            for (SensorDTO sensorDTO : sensorDTOS
                 ) {
                SensorData sensorData = new SensorData();
                sensorData.setSensorID(sensorDTO.getSensorID());
                sensorData.setCo2Level(new Random().nextInt((10-1)+1)+1);
                sensorData.setSmokeLevel(new Random().nextInt((10-1)+1)+1);
                sensorData.setDate(Long.toString(System.currentTimeMillis()));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<SensorDTO> getSensors() throws IOException,InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getAllSensors"))
                .build();

        List<SensorDTO> sensorDTOList = new ArrayList<>();
//        HttpResponse<String> response =
//                client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONArray jsonArray = new JSONArray(response.body());
//        ObjectMapper mapper = new ObjectMapper();
//        jsonArray.forEach(object -> {
//            try {
//                sensorDTOList.add(mapper.readValue(object.toString(), SensorDTO.class));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        });


        return sensorDTOList;
    }

    public void sendSensorData(SensorData sensorData){
        //Implement HTTP
    }

}