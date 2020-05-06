package com.fantastic4;

import com.fantastic4.models.Sensor;
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
            List<Sensor> sensors = getSensors();
            for (Sensor sensor:sensors
                 ) {
                SensorData sensorData = new SensorData();
                sensorData.setSensorID(sensor.getSensorID());
                sensorData.setCo2Level(new Random().nextInt((10-1)+1)+1);
                sensorData.setSmokeLevel(new Random().nextInt((10-1)+1)+1);
                sensorData.setDate(Long.toString(System.currentTimeMillis()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Sensor> getSensors() throws IOException,InterruptedException{
        List<Sensor> sensorDTOList = new ArrayList<>();
        //Implement HTTP
        return sensorDTOList;
    }

    public void sendSensorData(SensorData sensorData){
        //Implement HTTP
    }

}