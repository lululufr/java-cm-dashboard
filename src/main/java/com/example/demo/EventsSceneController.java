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

public class EventsSceneController extends SceneController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
		@FXML
	    private BarChart<?,?> barChartEvents;
	    @FXML
	    private PieChart pieChartChefCustomers;
	    @FXML
	    private PieChart pieChartChefHours;
	    @FXML
	    private Button buttonRefresh;
	    @FXML
	    private Button buttonCustomers;
	    @FXML
	    private Button buttonReturn;
	    @FXML
	    private Button buttonSales;
	    @FXML
	    private Button buttonDisconnect;

	    @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {

	        XYChart.Series seriesBarEvent = new XYChart.Series();
	        int k = 1;
	        while(k < 15) {
	            int r = new Random().nextInt(20 + 1) + 10;
	            seriesBarEvent.getData().add(new XYChart.Data(Integer.toString(k), r));
	            k++;
	        }
	        barChartEvents.getData().addAll(seriesBarEvent);




	        int a = new Random().nextInt(200 + 1);
	        int b = new Random().nextInt(200 + 1);
	        int c = new Random().nextInt(200 + 1);
	        ObservableList<PieChart.Data> pieChartDataChefCustomers =
	                FXCollections.observableArrayList(
	                    new PieChart.Data("Cuisinier Occitan", a),
	                    new PieChart.Data("Le Crepier", b),
	                    new PieChart.Data("LaCheffe", c));
	        pieChartChefCustomers.setData(pieChartDataChefCustomers);
	        
	        
	         
	        int f = new Random().nextInt(120 + 1) + 35;
	        int g = new Random().nextInt(120 + 1) + 35;
	        int h = new Random().nextInt(120 + 1) + 35;
	        ObservableList<PieChart.Data> pieChartDataChefHours =
	                FXCollections.observableArrayList(
	                    new PieChart.Data("Cuisinier Occitan", f),
	                    new PieChart.Data("Le Crepier", g),
	                    new PieChart.Data("LaCheffe", h));
	        pieChartChefHours.setData(pieChartDataChefHours);


	        buttonRefresh.setOnAction(actionEvent -> {
	            try {
	                switchScene(actionEvent, scene, root, stage, "EventsScene.fxml");
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

