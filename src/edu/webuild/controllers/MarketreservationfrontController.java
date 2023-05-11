/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
//import edu.webuild.services.Emailsender;
import edu.webuild.services.reservationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class MarketreservationfrontController implements Initializable {

    @FXML
    private ListView<reservation> affichage_reservation;
    @FXML
    private Button supprimer_reservation;
    @FXML
    private Button updatereservation;
    static Date date_debut;
    static Date date_fin;
    static int id;
    static voiture voiture;
    static reservation r ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView<reservation> list1 = affichage_reservation;
        InterfaceCRUD2 inter = new reservationCRUD();
        List<reservation> list2 = inter.afficherreservations2(ProfilClientController.client_id);
        for (int i = 0; i < list2.size(); i++) {
            reservation r = list2.get(i);
            list1.getItems().add(r);

        }

        // TODO
    }

    @FXML
    private void supprimer_reservation(ActionEvent event) {
        ListView<reservation> list = (ListView<reservation>) affichage_reservation;
        InterfaceCRUD2 inter = new reservationCRUD();

        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            reservation r = list.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("are you sure to delete this reservation?");
            // date local system

            LocalDate localDate = LocalDate.now();

            int day = localDate.getDayOfMonth(); // Extract the day from the LocalDate object
            int month = localDate.getMonthValue(); // Extraire le mois (1 - janvier, 2 - février, etc.)
            int year = localDate.getYear(); // Extraire le mois (1 - janvier, 2 - février, etc.)
            // date a partir de base de donnes 

            Date date = r.getDate_debut();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);

            String jour = dateString.substring(8, 10);
            String mois = dateString.substring(5, 7);
            String annee = dateString.substring(0, 4);
            int num1 = Integer.parseInt(jour);
            int num2 = Integer.parseInt(mois);
            int num3 = Integer.parseInt(annee);

            // if (day>num1-3)&&(month == num2)
            if (day - 3 > num1 && num2 == month) {
                showAlert(" impossible d 'annuler la reservation");
            } else if (month > num2) {
                showAlert(" impossible d 'annuler la reservation");
            } else if (month == num2 && day == num1) {
                showAlert(" impossible d 'annuler la reservation");
            } else {
                String message = "Dear [Client's Name],\n"
                        + "\n"
                        + "votre reservation a ete effectué avec succes :\n"
                        + "\n";

                //Emailsender.sendEmail_add("khmiriiheb3@gmail.com", message);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    inter.supprimerreservation(r.getId());
                    list.getItems().remove(selectedIndex);
                    showAlert("reservation was deleted");

                }
            }

        } else {
            System.out.println("Veuillez sélectionner une voiture à supprimer.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void updatereservation(ActionEvent event) {
        ListView<reservation> list = affichage_reservation;
        InterfaceCRUD2 inter = new reservationCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        

        reservation r = list.getSelectionModel().getSelectedItem();

        int id = r.getId();
        Date date_debut = r.getDate_debut();
        Date date_fin = r.getDate_debut();
        voiture = r.getV();
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_reservation.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MarketreservationbackController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
