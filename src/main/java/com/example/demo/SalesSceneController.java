package com.example.demo;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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

public class SalesSceneController extends SceneController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private BarChart<?,?> barChartSales;
    @FXML
    private LineChart<?,?> lineChartTotalRevenue;
    @FXML
    private PieChart pieChartDiversityRevenue;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Button buttonCustomers;
    @FXML
    private Button buttonReturn;
    @FXML
    private Button buttonEvents;
    @FXML
    private Button buttonDisconnect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series seriesBarSale = new XYChart.Series();
        int k = 1;
        String[] tabUstensils = new String[8];
        tabUstensils[0] = "Fouet";
        tabUstensils[1] = "Casserole";
        tabUstensils[2] = "Poele";
        tabUstensils[3] = "Couteau de cuisine";
        tabUstensils[4] = "Planche a decouper";
        tabUstensils[5] = "Mixer";
        tabUstensils[6] = "Assietes";
        tabUstensils[7] = "Couverts";
        		
        while(k < 8) {
            int r = new Random().nextInt(20 + 1) + 10;
            seriesBarSale.getData().add(new XYChart.Data(tabUstensils[k], r));
            k++;
        }
        barChartSales.getData().addAll(seriesBarSale);




        int a = new Random().nextInt(200 + 1);
        int b = new Random().nextInt(200 + 1);
        int c = new Random().nextInt(200 + 1);
        int d = new Random().nextInt(100 + 1);
        ObservableList<PieChart.Data> pieChartDataDiversityRevenue =
                FXCollections.observableArrayList(
                    new PieChart.Data("Abonnements", a),
                    new PieChart.Data("Ustensile", b),
                    new PieChart.Data("Livraison nourriture", c),
        			new PieChart.Data("Autres", d));
        pieChartDiversityRevenue.setData(pieChartDataDiversityRevenue);
        
        
         
        XYChart.Series seriesLineTotalRevenue = new XYChart.Series();
        k = 1;
        while(k < 31) {
            int r = new Random().nextInt(200 + 1) + 150;
            seriesLineTotalRevenue.getData().add(new XYChart.Data(Integer.toString(k), r));
            k++;
        }
        lineChartTotalRevenue.getData().addAll(seriesLineTotalRevenue);


        buttonRefresh.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "SalesScene.fxml");
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

        buttonReturn.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "MainScene.fxml");
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

        buttonDisconnect.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "LoginScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
