/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

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
 * @author aymen
 */
public class Menu_CovController implements Initializable {

    @FXML
    private Button afficher_coc;
    @FXML
    private Button ajouter_cov;
    @FXML
    private Button afficher_Part;
    @FXML
    private Button cov_btu;
    @FXML
    private Button cov_btu1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher_cov(ActionEvent event) {
           try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Cards.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CovController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void ajouter_cov(ActionEvent event) {
       try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/CardsCh.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CovController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void afficher_Part(ActionEvent event) {
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/CardsLoc.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CovController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void cov_btu(ActionEvent event) {
        
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void Front_btu(ActionEvent event) {
    }

    @FXML
    private void Map_btu(ActionEvent event) {
    }

    
    
}
