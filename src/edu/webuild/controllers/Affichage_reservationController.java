/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
import edu.webuild.services.reservationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Affichage_reservationController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView<reservation> list1 = affichage_reservation;
        InterfaceCRUD2 inter = new reservationCRUD();
        List<reservation> list2 = inter.afficherreservations();
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
            System.out.println(r.getId());
            inter.supprimerreservation(r.getId());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner une voiture à supprimer.");
        }
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
                    = FXMLLoader.load(getClass().getResource("modifier_reservation.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
        
    }
    

