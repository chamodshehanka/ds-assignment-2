package com.fantastic4.restapi.dto;

import java.util.List;

public class Sensor {

    private String sensorID;
    private int floorNo;
    private int roomNo;
    private List<SensorData> sensorData;

    public Sensor() {
    }

    public Sensor(String sensorID, int floorNo, int roomNo, List<SensorData> sensorData) {
        this.sensorID = sensorID;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.sensorData = sensorData;
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

    public List<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<SensorData> sensorData) {
        this.sensorData = sensorData;
    }
}
