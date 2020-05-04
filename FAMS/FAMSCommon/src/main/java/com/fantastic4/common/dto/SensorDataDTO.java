package com.fantastic4.common.dto;

public class SensorDataDTO implements SuperDTO{

    private String sensorDataID;
    private String sensorID;
    private int floorNo;
    private int roomNo;
    private int co2Level;
    private int smokeLevel;
    private String date;
    private boolean status;

    public SensorDataDTO() {
    }

    public SensorDataDTO(String sensorDataID, String sensorID, int floorNo, int roomNo, int co2Level, int smokeLevel, String date, boolean status) {
        this.sensorDataID = sensorDataID;
        this.sensorID = sensorID;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.co2Level = co2Level;
        this.smokeLevel = smokeLevel;
        this.date = date;
        this.status = status;
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

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
