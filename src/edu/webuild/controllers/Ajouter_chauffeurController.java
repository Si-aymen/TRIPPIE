/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addch(ActionEvent event)  { 
        String num_permis = fxperm.getText();
        String marque_voiture = fxmarque.getText();
        String couleur_voiture = fxcoul.getText();
        String email = fxmail.getText();
        String password=fxpass.getText();
        String immatriculation=fxmat.getText();
        
        Chauffeur ch = new Chauffeur(num_permis,marque_voiture,couleur_voiture,email,password);
        ChauffeurCRUD ch1 = new ChauffeurCRUD();
        ch1.ajouterChauffeur(ch);
       }
   
    
}
