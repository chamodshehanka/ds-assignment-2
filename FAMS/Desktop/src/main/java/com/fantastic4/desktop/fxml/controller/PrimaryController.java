package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.desktop.controller.AdminController;
import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    private void switchToSecondary() throws Exception {
            App.setRoot("fxmldocument");

    }

    @FXML
    private void login() throws Exception{
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail(email.getText());
        adminDTO.setPassword(email.getText());
        AdminDTO admin = AdminController.login(adminDTO);
        if(admin.getName()!=null){
            App.setRoot("fxmldocument");
        }
    }

}
