package com.fantastic4.desktop.fxml.controller;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable{

    @FXML
    private AnchorPane holderPane;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnSensors;
    @FXML
    private Button btnRoom;
    @FXML
    private AnchorPane profile,sensors,dashboard,rooms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setUIComponents();
    }


//    private void setUIComponents(){
//
//        //Reservation Button
//        Image reservationImage = new Image(getClass()
//                .getResourceAsStream("/images/reservation.png"));
//        btnRes.setGraphic(new ImageView(reservationImage));
//
//        //Payment Button
//        Image paymentImage = new Image(getClass()
//                .getResourceAsStream("/images/payment.png"));
//        btnPayment.setGraphic(new ImageView(paymentImage));
//
//        //Update Button
//        Image updateImage = new Image(getClass()
//                .getResourceAsStream("/images/update.png"));
//        btnUpdate.setGraphic(new ImageView(updateImage));
//
//        //Get Vehicle
//        Image vehicleImage = new Image(getClass()
//                .getResourceAsStream("/images/car.png"));
//        btnGetVehicle.setGraphic(new ImageView(vehicleImage));
//
//    }

    @FXML
    private void switchDashboard(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/livedashboard.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Live Sensor Data Dashboard");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot Load Dashboard");
        }
    }

    @FXML
    private void switchRooms(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/AdminRoomRegister.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Rooms");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot Load Rooms Manager");
        }
    }

    @FXML
    private void switchSensors(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/AdminSensorRegister.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Sensors");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot Load Sensors Manager");
        }
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/profile.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin Profile");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot Load Admin Profile");
        }
    }


}