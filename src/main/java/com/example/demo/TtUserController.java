package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TtUserController {

    @FXML
    private Label ttdashboard;

    @FXML
    protected void printDashboard() {

        ttdashboard.setText("Insertion d'un Dashboard");
    }
}
