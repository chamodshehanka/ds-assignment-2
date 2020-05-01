package com.fantastic4.restapi.dto;

public class SensorData {
    private String sensorDataID;
    private String date;
    private String time;

    public SensorData() {
    }

    public SensorData(String sensorDataID, String date, String time) {
        this.sensorDataID = sensorDataID;
        this.date = date;
        this.time = time;
    }

    public String getSensorDataID() {
        return sensorDataID;
    }

    public void setSensorDataID(String sensorDataID) {
        this.sensorDataID = sensorDataID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
