/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView<reservation> list1 =  affichage_reservation;
        InterfaceCRUD2 inter = new reservationCRUD();
        List<reservation> list2 = inter.afficherreservations();
        for (int i = 0; i < list2.size(); i++) {
            reservation r = list2.get(i);
            list1.getItems().add(r);

        }

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
    
}
