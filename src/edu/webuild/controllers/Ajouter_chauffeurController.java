/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.roleCRUD;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Ajouter_chauffeurController implements Initializable {
    
    @FXML
    private TextField fxperm;
    @FXML
    private TextField fxmarque;
    @FXML
    private TextField fxcoul;
    @FXML
    private TextField fxmat;
    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private Button btn;
    @FXML
    private TextField fxid;
    @FXML
    private ToggleButton showbtnnewnew;

    /**
     *
     * @param id
     */
    public void SetId_role(String id) {
         this.fxid.setText(id);
    }
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showbtnnewnew.setOnAction(event -> {
            if (showbtnnewnew.isSelected()) {
            fxpass.setPromptText(fxpass.getText());
            fxpass.setText("");
        } else {
            fxpass.setText(fxpass.getPromptText());
            fxpass.setPromptText("");
        }
        });
    }    
    
    @FXML
    private void addch(ActionEvent event) {        
        Role r = new Role();
        roleCRUD rc = new roleCRUD();
        r.setId_role(Integer.parseInt(fxid.getText()));
        String num_permis = fxperm.getText();
        String marque_voiture = fxmarque.getText();
        String couleur_voiture = fxcoul.getText();
        String email = fxmail.getText();
        String password = fxpass.getText();
        String immatriculation = fxmat.getText();
       
        // Définir la regex pour valider l'adresse e-mail
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (num_permis.isEmpty() || marque_voiture.isEmpty() || couleur_voiture.isEmpty() || immatriculation.isEmpty()|| email.isEmpty()|| password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.show();

        }
        else if (!email.matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse e-mail valide.");
            alert.showAndWait();
        } 
        else{
        Chauffeur ch = new Chauffeur(r, num_permis, marque_voiture, couleur_voiture, immatriculation, email, password);
        rc.affecterRole(ch, r);
        
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Affiche_ch.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    }
}
