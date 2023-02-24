/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Ajouter_recController implements Initializable {

    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private Button btn_ajouter;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter_rec(ActionEvent event) {
        try {
            String type = tf_type.getText();
            String commentaire = tf_commentaire.getText();

            reclamation r = new reclamation(type, commentaire, "non traité");

            reclamationCRUD rc = new reclamationCRUD();

            rc.ajouterReclamation(r);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Cette réclamation est ajoutée avec succés");
            alert.showAndWait();
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_recController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Retour_reclamation(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
