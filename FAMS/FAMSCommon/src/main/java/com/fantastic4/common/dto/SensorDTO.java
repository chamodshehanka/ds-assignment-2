package com.fantastic4.common.dto;

public class SensorDTO implements SuperDTO {

    private String sensorID;
    private int floorNo;
    private int roomNo;
    private int latestCO2Level;
    private int latestSmokeLevel;
    private boolean status;

    public SensorDTO() {
    }

    public SensorDTO(String sensorID, int floorNo, int roomNo, int co2, int smoke,boolean status) {
        this.sensorID = sensorID;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.latestCO2Level = co2;
        this.latestSmokeLevel = smoke;
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "sensorID:'" + sensorID + '\'' +
                ", floorNo:" + floorNo +
                ", roomNo:" + roomNo +
                ", latestCO2Level:" + latestCO2Level +
                ", latestSmokeLevel:" + latestSmokeLevel +
                ", status=" + status +
                '}';
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

    public void setLatestCO2Level(int co2Level) {
        this.latestCO2Level = co2Level;
    }

    public int getLatestCO2Level() {
        return latestCO2Level;
    }

    public void setLatestSmokeLevel(int smokeLevel) {
        this.latestSmokeLevel = smokeLevel;
    }

    public int getLatestSmokeLevel() {
        return latestSmokeLevel;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

}
