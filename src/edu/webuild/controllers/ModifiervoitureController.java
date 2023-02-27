/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class ModifiervoitureController implements Initializable {

    @FXML
    private TextField fx_matricule;
    @FXML
    private TextField fx_modele;
    @FXML
    private TextField fx_puissance;
    @FXML
    private TextField fx_prix_jours;
    @FXML
    private Button modifier_voiture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx_matricule.setText(Afficher_voitureController.matricule);
        fx_modele.setText(Afficher_voitureController.marque);
        fx_puissance.setText(Afficher_voitureController.Puissence);
        fx_prix_jours.setText(Afficher_voitureController.Prix_jour);
        
    }    

    @FXML
    private void modifier_voiture(ActionEvent event) {
        InterfaceCRUD inter = new voitureCRUD();
        String matricule = fx_matricule.getText();        
        String marque = fx_modele.getText();
        String puissence = fx_puissance.getText();
        int prix_jour = Integer.parseInt(fx_prix_jours.getText());
        voiture v = new voiture(Afficher_voitureController.id,matricule, marque, puissence, prix_jour);
        inter.modifiervoiture(v);
    }
    
}
