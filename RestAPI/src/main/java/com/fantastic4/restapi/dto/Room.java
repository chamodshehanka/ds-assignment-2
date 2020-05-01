package com.fantastic4.restapi.dto;

public class Room {
    private String roomNo;
    private int floorNo;
    private String sensorID;

    public Room() {
    }

    public Room(String roomNo, int floorNo, String sensorID) {
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.sensorID = sensorID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }
}
