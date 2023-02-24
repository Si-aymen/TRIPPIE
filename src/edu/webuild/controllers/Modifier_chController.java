/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Modifier_chController implements Initializable {

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
    private Button btnmod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        fxperm.setText(String.valueOf(Affiche_chController.num_permis));
        fxmarque.setText(String.valueOf(Affiche_chController.marque_voiture));
        fxcoul.setText(String.valueOf(Affiche_chController.couleur_voiture));
        fxmat.setText(String.valueOf(Affiche_chController.immatriculation));
        fxmail.setText(String.valueOf(Affiche_chController.email));
        fxpass.setText(String.valueOf(Affiche_chController.password));
    }

    @FXML
    private void modifier_user(ActionEvent event) {
        InterfaceChauffeurCRUD inter = new ChauffeurCRUD();
        String num_permis = fxperm.getText();
        String marque_voiture = fxmarque.getText();
        String couleur_voiture = fxcoul.getText();
        String email = fxmail.getText();
        String password = fxpass.getText();
        String immatriculation = fxmat.getText();
        
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
        else {
        Chauffeur u = new Chauffeur(Affiche_chController.id_ch, num_permis, marque_voiture, couleur_voiture, immatriculation, email, password);
        inter.modifierChauffeur(u);

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
