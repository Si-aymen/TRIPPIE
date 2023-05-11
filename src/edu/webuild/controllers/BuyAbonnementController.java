/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.frog.FroggerApp;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class BuyAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField tfPrix;
      @FXML
    private DatePicker tfdateAchat;
       @FXML
    private DatePicker tfdateExpiration;
     private TextField id_client;
    @FXML
    private TextField fx_id_client;
      //VARIABLES
        Date dateAchat,dateExpiration;
    
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

public void buyabonnement(ActionEvent event) {

    // Get the input values from the combo box and date picker
    String type = cbType.getValue();
    LocalDate dateExpirationLocal = tfdateExpiration.getValue();

    // Validate the input values
    if (type == null || dateExpirationLocal == null) {
        // If any input value is empty, show an error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
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

    // Check if the price is greater than or equal to the highscore
FroggerApp app = new FroggerApp();
int highScore = app.getHighScore();
    if (abonnement.getPrix() == app.getHighScore()) {
        // Insert the new abonnement object into the database
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
        abonnementCRUD.ajouterabonnement(abonnement);

        // Show a success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You bought a new membership!");
        alert.show();
    }
    
    
    if (abonnement.getPrix() < highScore) {
    // If the price is less than  the highscore, deduct the price from the highscore
        highScore -= abonnement.getPrix();
        app.setHighScore(highScore);
        app.updateHighScore(highScore);

    // Insert the new abonnement object into the database
    AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
    abonnementCRUD.ajouterabonnement(abonnement);

    // Show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("You bought a new membership!"+"and your new token balance is :"+ highScore);
    alert.show();
} 
    
    
    else {
        // If the price is less than the highscore, show an error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Cannot Buy");
        alert.setContentText("You cannot buy this abonnement because your highscore is too low.");
        alert.showAndWait();
    }
System.out.println("cbType is null: " + (cbType == null));

    
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

    @FXML
    private void ajouterabonnement(ActionEvent event) {
    }


}