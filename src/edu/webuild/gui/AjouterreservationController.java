/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class AjouterreservationController implements Initializable {

    @FXML
    private Button ajouter_reservation;
    @FXML
    private TextField fx_debut;
    @FXML
    private TextField fx_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_reservation(ActionEvent event) {
        String date_debut = fx_debut.getText();
        String date_fin = fx_fin.getText();
     //   reservation r = new reservation(date_debut, date_fin,Afficher_voitureController.id);
        reservationCRUD res = new reservationCRUD();
   //     res.ajouterreservation(r);
       
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("voiture insérée avec succés!");
        alert.show();
    }
    
}
