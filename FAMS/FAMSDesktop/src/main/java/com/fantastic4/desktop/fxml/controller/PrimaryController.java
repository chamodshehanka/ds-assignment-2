package com.fantastic4.desktop.fxml.controller;

import java.io.IOException;

import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
}
