/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

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
    @FXML
    private Button back;

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

    @FXML
    private void back(ActionEvent event) {
         try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/affichage_reservation.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
