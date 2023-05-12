package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class LineChartSample implements Initializable {
    @FXML
    private BarChart<?,?> barChart; //fxid barchart

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            //defining a series
            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");
            //populating the series with data
            series.getData().add(new XYChart.Data("1", 23));
            series.getData().add(new XYChart.Data("2", 14));
            series.getData().add(new XYChart.Data("3", 15));
            series.getData().add(new XYChart.Data("4", 24));
            series.getData().add(new XYChart.Data("5", 34));
            series.getData().add(new XYChart.Data("6", 36));
            series.getData().add(new XYChart.Data("7", 22));
            series.getData().add(new XYChart.Data("8", 45));
            series.getData().add(new XYChart.Data("9", 43));
            series.getData().add(new XYChart.Data("10", 17));
            series.getData().add(new XYChart.Data("11", 29));
            series.getData().add(new XYChart.Data("12", 25));

            barChart.getData().addAll(series);
    }
}