package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.desktop.controller.AdminController;
import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private void switchToSecondary() throws Exception {
            App.setRoot("fxmldocument");

    }

    @FXML
    private void login() throws Exception{
        AdminController adminController = new AdminController();
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail(email.getText());
        adminDTO.setPassword(email.getText());
        boolean status = adminController.login(adminDTO);
        if(status==true){
            App.setRoot("fxmldocument");
        }
    }

    @FXML
    private void switchToTest() throws IOException{
        App.setRoot("sensordata");
    }
}
