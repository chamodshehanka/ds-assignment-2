package com.fantastic4.common.dto;

public class FloorDTO implements SuperDTO {
    private int floorNo;
    private String sensorID;

    public FloorDTO() {
    }

    public FloorDTO(int floorNo) {
        this.floorNo = floorNo;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "FloorDTO{" +
                "floorNo=" + floorNo +
                ", sensorID='" + sensorID + '\'' +
                '}';
    }
}
