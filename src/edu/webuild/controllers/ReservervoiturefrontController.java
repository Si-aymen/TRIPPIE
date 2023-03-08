/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.services.Emailsender;
import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
import edu.webuild.services.reservationCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class ReservervoiturefrontController implements Initializable {

    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 

    @FXML
    private void ajouter_reservation(ActionEvent event) {
        Date date_debutt = java.sql.Date.valueOf(date_debut.getValue());
        Date date_finn = java.sql.Date.valueOf(date_fin.getValue());
        int comparison = date_debutt.compareTo(date_finn);
        if (comparison > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("date debut est apres date de retour de voiture");
            alert.show();
        } else if (comparison == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("date debut est egale au date fin de reservation");
            alert.show();
        } else {
            reservation res = new reservation(date_debutt, date_finn, new voiture(230, "215tunis215", "clio", "5ch", 250));
            InterfaceCRUD2 inter = new reservationCRUD();
            inter.ajouterreservation(res);

            String message = "Dear [Client's Name],\n"
                    + "\n"
                    + "I am writing this email to confirm your location reservation for the following details:\n"
                    + "\n"
                    + "date debut reservation : " + date_debut + "\n"
                    + "date fin reservation : " + date_fin + "\n"
                    + "We are pleased to inform you that your reservation has been successfully processed, and we have reserved the required number of seats for you. Your confirmation number is [Enter confirmation number].\n"
                    + "\n";

            Emailsender.sendEmail_add("khmiriiheb3@gmail.com", message);

        }
    }

}
