/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Modifier_reservationController implements Initializable {

    @FXML
    private DatePicker date_debut_pk;
    @FXML
    private DatePicker date_fin_pk;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modifier_reservation(ActionEvent event) {
        InterfaceCRUD2 inter = new reservationCRUD();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("");
            
        Date date_debut = java.sql.Date.valueOf(date_debut_pk.getValue());
        Date date_fin = java.sql.Date.valueOf(date_fin_pk.getValue());
          Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
        reservation res = new reservation(date_debut, date_fin, Affichage_reservationController.voiture);
        inter.modifierreservation(res);
                }
    }

}
