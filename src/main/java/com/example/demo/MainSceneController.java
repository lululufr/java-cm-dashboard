package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

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
    @FXML
    private Button buttonExport;

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
        buttonExport.setOnAction(actionEvent -> {
        	PDDocument document = new PDDocument();
            PDPage page1 = new PDPage(PDRectangle.A4);
            document.addPage(page1);

            try (PDPageContentStream contentStream1 = new PDPageContentStream(document, page1)) {

                WritableImage graph1 = barChartUserConnections.snapshot(null, null);
                PDImageXObject pdGraph1 = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(graph1, null));
                contentStream1.drawImage(pdGraph1, 50, 500, 500, 300);
                WritableImage graph2 = lineChartTotalRevenue.snapshot(null, null);
                PDImageXObject pdGraph2 = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(graph2, null));
                contentStream1.drawImage(pdGraph2, 50, 150, 500, 300);
                contentStream1.close();

                PDPage page2 = new PDPage(PDRectangle.A4);
                document.addPage(page2);
                PDPageContentStream contentStream2 = new PDPageContentStream(document, page2);
                WritableImage graph3 = pieChartAccountTypes.snapshot(null, null);
                PDImageXObject pdGraph3 = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(graph3, null));
                contentStream2.drawImage(pdGraph3, 50, 500, 500, 300);
                WritableImage graph4 = barChartNewAccounts.snapshot(null, null);
                PDImageXObject pdGraph4 = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(graph4, null));
                contentStream2.drawImage(pdGraph4, 50, 150, 500, 300);
                contentStream2.close();
                
                String[] nameTab = new String[5];
                nameTab[0] = "AIexOWO";
                nameTab[1] = "lululufr";
                nameTab[2] = "FloonKaymon";
                nameTab[3] = "SananesPetitesLunettes";
                nameTab[4] = "PizzaPateGambas75";
                
                PDPage page3 = new PDPage(PDRectangle.A4);
                document.addPage(page3);
                PDPageContentStream contentStream3 = new PDPageContentStream(document, page3);
                contentStream3.setFont(PDType1Font.HELVETICA_BOLD, 12);

                int y = 700;
                for (int i = 0; i <= 4; i++) {
                    String name = nameTab[i];
                    int amountSpent = new Random().nextInt(450) + 50;
                    contentStream3.beginText();
                    contentStream3.newLineAtOffset(100, y);
                    contentStream3.showText(name + ": " + amountSpent + "euros");
                    contentStream3.endText();
                    y -= 20;
                }
                contentStream3.close();

                document.save("CM_data.pdf");
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    

    
}