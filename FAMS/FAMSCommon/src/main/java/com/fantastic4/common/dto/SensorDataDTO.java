package com.fantastic4.common.dto;

public class SensorDataDTO implements SuperDTO{

    private String sensorDataID;
    private String sensorID;
    private int co2Level;
    private int smokeLevel;
    private String date;

    public SensorDataDTO() {
    }

    public SensorDataDTO(String sensorDataID, String sensorID, int co2Level, int smokeLevel, String date, boolean status) {
        this.sensorDataID = sensorDataID;
        this.sensorID = sensorID;
        this.co2Level = co2Level;
        this.smokeLevel = smokeLevel;
        this.date = date;
    }

    public String getSensorDataID() {
        return sensorDataID;
    }

    public void setSensorDataID(String sensorDataID) {
        this.sensorDataID = sensorDataID;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public int getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(int co2Level) {
        this.co2Level = co2Level;
    }

    public int getSmokeLevel() {
        return smokeLevel;
    }

    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
