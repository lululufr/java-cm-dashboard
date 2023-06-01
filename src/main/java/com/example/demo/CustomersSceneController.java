package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersSceneController extends SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button buttonRefresh;
    @FXML
    private Button buttonReturn;
    @FXML
    private Button buttonEvents;
    @FXML
    private Button buttonSales;
    @FXML
    private Button buttonDisconnect;
    @FXML
    private ComboBox<Customer> comboBoxCustomers;
    @FXML
    private ListView<String> listViewMovements;
    @FXML
    private Label labelCustomerUsername;
    @FXML
    private Label labelCustomerFirstName;
    @FXML
    private Label labelCustomerLastName;
    @FXML
    private Label labelCustomerSubscription;
    @FXML
    private Label labelCustomerEmail;
    @FXML
    private Label labelCustomerPhone;
    @FXML
    private Label labelCustomerAdress;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Customer[] customers = new Customer[3];
        Movement[] movements = Movement.simulateMovements();
        customers[0] = new Customer("JDleBest", "Jean", "Dupont", "Subscribed", "jean.dupont@gmail.com", movements, "06 12 34 56 78", "1 rue de la Paix, Paris");
        customers[1] = new Customer("PierreSympa", "Pierre", "Gentil", "Premium", "pierre.gentil@gmail.com", movements, "06 12 24 36 48", "2 rue de la Paix, Paris");
        customers[2] = new Customer("Melanya", "Melanie", "Vannya", "Free", "melanie.vannya@gmail.com", movements, "06 05 04 03 02", "3 rue de la Paix, Paris");

        ObservableList<Customer> list = FXCollections.observableArrayList(customers);
        comboBoxCustomers.setItems(list);

        comboBoxCustomers.setOnAction(actionEvent -> {
            try {
                labelCustomerUsername.setText("Username : " + comboBoxCustomers.getValue().getUsername());
                labelCustomerSubscription.setText("Type d'abonnement : " + comboBoxCustomers.getValue().getSubscription());
                labelCustomerEmail.setText("Adresse email : " + comboBoxCustomers.getValue().getMail());
                labelCustomerPhone.setText("Numéro de téléphone : " + comboBoxCustomers.getValue().getPhone());
                labelCustomerAdress.setText("Adresse : " + comboBoxCustomers.getValue().getAddress());
                labelCustomerFirstName.setText("Prénom : " + comboBoxCustomers.getValue().getFirstname());
                labelCustomerLastName.setText("Nom : " + comboBoxCustomers.getValue().getLastname());

                listViewMovements.getItems().clear();
                for (int k = 0; k < movements.length; k++) {
                    listViewMovements.getItems().add(movements[k].toString());
                }
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

        buttonRefresh.setOnAction(actionEvent -> {
            try {
                switchScene(actionEvent, scene, root, stage, "CustomersScene.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



    }


}
