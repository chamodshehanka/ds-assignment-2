package com.fantastic4.desktop.fxml.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SensorsTableModel {
    private SimpleStringProperty sensorID = new SimpleStringProperty("");
    private SimpleIntegerProperty floor = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty room = new SimpleIntegerProperty(0);

    public SensorsTableModel(){
    }

    public SensorsTableModel(SimpleStringProperty sensorID, SimpleIntegerProperty floor, SimpleIntegerProperty room) {
        this.sensorID = sensorID;
        this.floor = floor;
        this.room = room;
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

    public int getRoom() {
        return room.get();
    }

    public SimpleIntegerProperty roomProperty() {
        return room;
    }

    public void setRoom(int room) {
        this.room.set(room);
    }
}
