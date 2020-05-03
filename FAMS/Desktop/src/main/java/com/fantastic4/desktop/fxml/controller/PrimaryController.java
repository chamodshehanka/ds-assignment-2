package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("fxmldocument");
    }
}
