/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.webuild.interfaces.InterfaceAbonnement;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.gui.ajouterAbonnement;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.net.URL;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class AjouterAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfPrix;
    @FXML
    private DatePicker tfdateAchat;
    @FXML
    private DatePicker tfdateExpiration;
    int id_client;
    //VARIABLES
    Date dateAchat, dateExpiration;

    @FXML
    private ComboBox<String> cbType;

// Initialize the type and price fields
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add items to the type combo box
        cbType.getItems().addAll("Gold", "Platinium", "Bronze");

        // Set the price text field to read-only
        tfPrix.setEditable(false);

        // Set the date picker value to today's date
        LocalDate today = LocalDate.now();
        tfdateAchat.setValue(today);
        tfdateAchat.setDisable(true);
        tfdateExpiration.setValue(today.plusYears(1));
        tfdateExpiration.setDisable(true);
    }

    @FXML
    private void ajouterabonnement(ActionEvent event) {
        // Get the input values from the combo box and date picker
        id_client = ProfilClientController.client_id;
        String type = cbType.getValue();
        LocalDate dateExpirationLocal = tfdateExpiration.getValue();

        // Validate the input values
        if (type == null || dateExpirationLocal == null) {
            // If any input value is empty, show an error message
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty field(s)");
            alert.setContentText("Please fill all the information.");
            alert.showAndWait();
            return;
        }

        // Create a new abonnement object with the selected type
        abonnement abonnement = new abonnement(type);

        // Set the dateAchat and dateExpiration attributes
        LocalDate today = LocalDate.now();
        abonnement.setDateAchat(java.sql.Date.valueOf(today));
        abonnement.setDateExpiration(java.sql.Date.valueOf(dateExpirationLocal.plusYears(1)));

        // Insert the new abonnement object into the database
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
        abonnementCRUD.ajouterabonnement(abonnement);

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("abonnement insérée avec succés!");
        alert.show();
    }

// Update the price text field when the user selects a type
    @FXML
    private void updatePrix(ActionEvent event) {
        String type = cbType.getValue();
        abonnement abonnement = new abonnement(type);
        tfPrix.setText(String.valueOf(abonnement.getPrix()));
    }

    @FXML
    private void back_btn(MouseEvent event) {
    }

}
