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
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Modifier_reservationfrontController implements Initializable {

    @FXML
    private DatePicker date_debut_pk;
    @FXML
    private DatePicker date_fin_pk;
    static Date date_debut;
    static Date date_fin;
    @FXML
    private Label fxdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
     
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void modifier_reservation(ActionEvent event) {
        InterfaceCRUD2 inter = new reservationCRUD();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("");
        alert.setContentText("you are sure to do this update ?");

        Date date_debut = java.sql.Date.valueOf(date_debut_pk.getValue());
        Date date_fin = java.sql.Date.valueOf(date_fin_pk.getValue());
        LocalDate currentDate = LocalDate.now(); // Gets the current date
        String dateStringlocal = currentDate.toString();
        String datebuts = date_debut.toString();
        String datefin = date_fin.toString();
        int comparaison2 = datebuts.compareTo(dateStringlocal);
        int comparaison3 = datefin.compareTo(dateStringlocal);
        if (comparaison2 < 0) {

            showAlert("reservation start date is greater than reservation end date");
        }
        if (comparaison3 < 0) {

            showAlert("date debut de reservation est egale a date fin  de reservation");
        }

        int comparison = date_debut.compareTo(date_fin);

        if (comparison > 0) {

            showAlert("start date is after car return date");
        } else if (comparison == 0) {

            showAlert("start date is equal to the end date of the reservation");

        } else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                reservation res = new reservation(date_debut, date_fin, MarketreservationfrontController.voiture);
                inter.modifierreservation(res);
                showAlert("successfully updated");
            }

        }
    }
}
