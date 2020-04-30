package com.fantastic4.restapi.dto;

public class SensorDTO {

    private String sensorId;
    private String roomNo,floorNo,co2Level;

    public SensorDTO() {
    }

    public SensorDTO(String sensorId, String roomNo, String floorNo, String co2Level) {
        this.sensorId = sensorId;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.co2Level = co2Level;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(String co2Level) {
        this.co2Level = co2Level;
    }
}
