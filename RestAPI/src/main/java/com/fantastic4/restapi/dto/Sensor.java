package com.fantastic4.restapi.dto;

public class Sensor {

    private String sensorID;

    public Sensor() {
    }

    public Sensor(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }
}
