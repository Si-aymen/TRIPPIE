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
import java.time.LocalDate;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("date debut est inferieur");
            alert.show();
        }
        if (comparaison3 < 0) {

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("date debut est inferieur");
            alert.show();
        }

        int comparison = date_debut.compareTo(date_fin);

        if (comparison > 0) {

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("start date is after car return date");
            alert.show();
        } else if (comparison == 0) {

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("start date is equal to the end date of the reservation");
            alert.show();
        } else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                reservation res = new reservation(date_debut, date_fin, Affichage_reservationController.voiture);
                inter.modifierreservation(res);
                showAlert("successfully updated");
                  try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketreservationback.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

            }
            }

        }
    }

    @FXML
    private void back_btn(MouseEvent event) {
          try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketreservationback.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixResetController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
