package com.fantastic4.desktop.fxml.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SensorTableModel {

    private SimpleStringProperty sensorID = new SimpleStringProperty("");
    private SimpleIntegerProperty floor = new SimpleIntegerProperty(0);
    private SimpleStringProperty room = new SimpleStringProperty("");
    private SimpleIntegerProperty smoke = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty CO2 = new SimpleIntegerProperty(0);
    private SimpleStringProperty status = new SimpleStringProperty("");
    private SimpleStringProperty sensorStatus = new SimpleStringProperty("");

    public SensorTableModel(){
    }

    public SensorTableModel(SimpleStringProperty sensorID, SimpleIntegerProperty floor, SimpleStringProperty room, SimpleIntegerProperty smoke, SimpleIntegerProperty CO2, SimpleStringProperty status, SimpleStringProperty sensorStatus) {
        this.sensorID = sensorID;
        this.floor = floor;
        this.room = room;
        this.smoke = smoke;
        this.CO2 = CO2;
        this.status = status;
        this.sensorStatus = sensorStatus;
    }

    public String getSensorID() {
        return sensorID.get();
    }

    public SimpleStringProperty sensorIDProperty() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID.set(sensorID);
    }

    public int getFloor() {
        return floor.get();
    }

    public SimpleIntegerProperty floorProperty() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor.set(floor);
    }

    public String getRoom() {
        return room.get();
    }

    public SimpleStringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public int getSmoke() {
        return smoke.get();
    }

    public SimpleIntegerProperty smokeProperty() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke.set(smoke);
    }

    public int getCO2() {
        return CO2.get();
    }

    public SimpleIntegerProperty CO2Property() {
        return CO2;
    }

    public void setCO2(int CO2) {
        this.CO2.set(CO2);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getSensorStatus() {
        return sensorStatus.get();
    }

    public SimpleStringProperty sensorStatusProperty() {
        return sensorStatus;
    }

    public void setSensorStatus(String sensorStatus) {
        this.sensorStatus.set(sensorStatus);
    }
}
