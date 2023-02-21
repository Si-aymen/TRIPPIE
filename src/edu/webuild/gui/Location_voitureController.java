/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Location_voitureController implements Initializable {

    @FXML
    private Button location_voiture;
    @FXML
    private Button reservation_voiture;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void location_voiture(ActionEvent event) {
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("crud_voiture.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void reservation_voiture(ActionEvent event) {
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("affichage_reservation.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
