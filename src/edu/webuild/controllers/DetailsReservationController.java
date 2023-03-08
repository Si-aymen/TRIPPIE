/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class DetailsReservationController implements Initializable {

    @FXML
    private Label fx_marque;
    @FXML
    private Label fx_puissance;
    @FXML
    private Label fx_date_debut;
    @FXML
    private Label fx_date_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fx_date_debut.setText(String.valueOf(Affichage_reservationController.date_debut));
       // fxx_modele.setText(String.valueOf(Afficher_voitureController.marque));
    }    
    
}
