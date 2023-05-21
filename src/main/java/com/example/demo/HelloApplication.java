package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("COOK MASTER DASHBOARD");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}