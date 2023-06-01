package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class MainSceneController extends SceneController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private BarChart<?,?> barChartUserConnections;
    @FXML
    private LineChart<?,?> lineChartTotalRevenue;
    @FXML
    private PieChart pieChartAccountTypes;
    @FXML
    private BarChart<?,?> barChartNewAccounts;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Button buttonCustomers;
    @FXML
    private Button buttonEvents;
    @FXML
    private Button buttonSales;
    @FXML
    private Button buttonDisconnect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series seriesBarUserConnections = new XYChart.Series();
        barChartUserConnections.setTitle("Nombres de connexions d'utilisateurs différents");
        int k = 1;
        while(k < 31) {
            int r = new Random().nextInt(90 + 1) + 10;
            seriesBarUserConnections.getData().add(new XYChart.Data(Integer.toString(k), r));
            k++;
        }
        barChartUserConnections.getData().addAll(seriesBarUserConnections);


        XYChart.Series seriesLineTotalRevenue = new XYChart.Series();
        lineChartTotalRevenue.setTitle("Chiffre d'affaire par mois");
        k = 1;
        while(k < 13) {
            int r = new Random().nextInt(200 + 1) + 150;
            seriesLineTotalRevenue.getData().add(new XYChart.Data(Integer.toString(k), r));
            k++;
        }
        lineChartTotalRevenue.getData().addAll(seriesLineTotalRevenue);


        int a = new Random().nextInt(200 + 1) + 100;
        int b = new Random().nextInt(150 + 1) + 20;
        int c = new Random().nextInt(100 + 1) + 5;
        ObservableList<PieChart.Data> pieChartDataAccountType =
                FXCollections.observableArrayList(
                    new PieChart.Data("Free Users", a),
                    new PieChart.Data("Subscribers", b),
                    new PieChart.Data("Premiums", c));
        pieChartAccountTypes.setTitle("Répartitions de types de compte en %");
        pieChartAccountTypes.setData(pieChartDataAccountType);


        XYChart.Series seriesBarNewAccounts = new XYChart.Series();
        barChartNewAccounts.setTitle("Nombre de nouveaux comptes créés par jour");
        k = 1;
        while(k < 31) {
            int r = new Random().nextInt(10 + 1) + 3;
            seriesBarNewAccounts.getData().add(new XYChart.Data(Integer.toString(k), r));
            k++;
        }
        barChartNewAccounts.getData().addAll(seriesBarNewAccounts);

        buttonRefresh.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "MainScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonCustomers.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "CustomersScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonEvents.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "EventsScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonSales.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "SalesScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonDisconnect.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "LoginScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
    

    
}