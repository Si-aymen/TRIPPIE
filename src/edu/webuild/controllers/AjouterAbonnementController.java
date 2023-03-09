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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    private TextField tfType;
     @FXML
    private TextField tfPrix;
      @FXML
    private DatePicker tfdateAchat;
       @FXML
    private DatePicker tfdateExpiration;
        @FXML
    private Button btnAjouter;
    
      //VARIABLES
        Date dateAchat,dateExpiration;
    

    
   // Initialize the date pickers for dateAchat and dateExpiration
@Override
public void initialize(URL url, ResourceBundle rb) {
    // Set the date picker value to today's date
    LocalDate today = LocalDate.now();
    tfdateAchat.setValue(today);
    tfdateAchat.setDisable(true);
    tfdateExpiration.setValue(today.plusYears(1));
    tfdateExpiration.setDisable(true);
}
    
    
  @FXML
private void ajouterabonnement(ActionEvent event) {
    // Get the input values from the text fields and date pickers
    String type = tfType.getText().trim();
    String prixString = tfPrix.getText().trim();

    // Validate the input values
    if (type.isEmpty() || prixString.isEmpty()) {
        // If any input value is empty, show an error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Empty field(s)");
        alert.setContentText("Please fill all the information.");
        alert.showAndWait();
        return;
    }

    // Parse the input values
    int prix = Integer.parseInt(prixString);
    LocalDate today = LocalDate.now();
    Date dateAchat = java.sql.Date.valueOf(today);
    Date dateExpiration = java.sql.Date.valueOf(today.plusYears(1));

    // Create a new abonnement object and insert it into the database
    abonnement abonnement = new abonnement(type, prix, dateAchat, dateExpiration);
    AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
    abonnementCRUD.ajouterabonnement(abonnement);

    // Show a success message
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("abonnement insérée avec succés!");
    alert.show();
}


}
