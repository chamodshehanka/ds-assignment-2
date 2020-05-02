package com.fantastic4.common.dto;

public class SensorDTO implements SuperDTO {

    private String sensorID;
    private String roomNo,floorNo,co2Level;

    public SensorDTO() {
    }

    public SensorDTO(String sensorID, String roomNo, String floorNo, String co2Level) {
        this.sensorID = sensorID;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.co2Level = co2Level;
    }

    @Override
    public String toString() {
        return "{" +
                "sensorID:'" + sensorID + '\'' +
                ", roomNo:'" + roomNo + '\'' +
                ", floorNo:'" + floorNo + '\'' +
                ", co2Level:'" + co2Level + '\'' +
                '}';
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
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
