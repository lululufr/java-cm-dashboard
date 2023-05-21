package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class LineChartSample implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private BarChart<?,?> barChart; //fxid barchart
    @FXML
    private LineChart<?,?> lineChart; //fxid linechart
    @FXML
    private PieChart pieChart; //fxid piechart

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	
            //defining a series
            XYChart.Series seriesBar = new XYChart.Series();
            barChart.setTitle("Nombres de connexions d'utilisateurs différents");
            //populating the series with data
            int k = 1;
            while(k < 31) {
            	int r = new Random().nextInt(90 + 1) + 10;
            	seriesBar.getData().add(new XYChart.Data(Integer.toString(k), r));
            	k++;
            }

            barChart.getData().addAll(seriesBar);
            
            XYChart.Series seriesLine = new XYChart.Series();
            lineChart.setTitle("Chiffre d'affaire par mois");
            //populating the series with data
            int l = 1;
            while(l < 13) {
            	int r = new Random().nextInt(200 + 1) + 150;
            	seriesLine.getData().add(new XYChart.Data(Integer.toString(l), r));
            	l++;
            }

            lineChart.getData().addAll(seriesLine);
            
            int a = new Random().nextInt(200 + 1) + 80;
            int b = new Random().nextInt(150 + 1) + 25;
            int c = new Random().nextInt(100 + 1) + 5;
            
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                    new PieChart.Data("Free Users", a),
                    new PieChart.Data("Subscribers", b),
                    new PieChart.Data("Premiums", c));
            pieChart.setTitle("Répartitions de types de compte en %");
            pieChart.setData(pieChartData);
            
    }
	
	public void switchScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    

    
}