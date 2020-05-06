package com.fantastic4.restapi.dto;

public class Floor {
    private String floorID;

    public Floor() {
    }

    public Floor(String floorID) {
        this.floorID = floorID;
    }

    public String getFloorID() {
        return floorID;
    }

    public void setFloorID(String floorID) {
        this.floorID = floorID;
    }
}
