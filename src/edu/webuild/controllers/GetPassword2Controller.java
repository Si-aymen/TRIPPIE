/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class GetPassword2Controller implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private Button btnRechercher;
     static String Ssemail2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Rechercher(ActionEvent event) throws IOException {
         String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/IdentifierCompteCh.fxml"));
        Parent rat = loader.load();
        IdentifierCompteChController dc = loader.getController();
        String email = txtusername.getText();
        Ssemail2 = txtusername.getText();

        if (!email.matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
        } else {
            dc.setUserInformation(email);
            // Create a new scene with the loaded FXML file and show it
            Scene scene = new Scene(rat);
            Stage stage = (Stage) btnRechercher.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            //}
        }
    }

    }
    

