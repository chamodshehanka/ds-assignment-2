package com.fantastic4.common.dto;

import java.util.List;

public class SensorDTO implements SuperDTO {

    private String sensorID;
    private int floorNo;
    private int roomNo;
    private List<SensorDataDTO> sensorData;

    public SensorDTO() {
    }

    public SensorDTO(String sensorID, int floorNo, int roomNo, List<SensorDataDTO> sensorData) {
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

    public List<SensorDataDTO> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<SensorDataDTO> sensorData) {
        this.sensorData = sensorData;
    }
}
