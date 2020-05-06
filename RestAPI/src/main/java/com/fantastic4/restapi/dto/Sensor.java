package com.fantastic4.restapi.dto;

import java.util.List;

public class Sensor {

    private String sensorID;
    private int floorNo;
    private int roomNo;
    private int latestCO2Level;
    private int latestSmokeLevel;
    private boolean status;

    public Sensor() {
    }

    public Sensor(String sensorID, int floorNo, int roomNo, int latestCO2Level, int latestSmokeLevel, boolean status) {
        this.sensorID = sensorID;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.latestCO2Level = latestCO2Level;
        this.latestSmokeLevel = latestSmokeLevel;
        this.status = status;
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

    public int getLatestCO2Level() {
        return latestCO2Level;
    }

    public void setLatestCO2Level(int co2Level) {
        this.latestCO2Level = co2Level;
    }

    public int getLatestSmokeLevel() {
        return latestSmokeLevel;
    }

    public void setLatestSmokeLevel(int smokeLevel) {
        this.latestSmokeLevel = smokeLevel;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

}
