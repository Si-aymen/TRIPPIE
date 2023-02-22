/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceUserCRUD;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class ModifierController implements Initializable {
    private AnchorPane rootPane;
   
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxprenom;
    @FXML
    private TextField fxsexe;
    @FXML
    private TextField fxage;
    @FXML
    private Button btnmod;
   
    
    private TextField fxid;
    @FXML
    private TextField fxCin;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
          fxid.setText(String.valueOf(AfficheController.id_user));
        fxCin.setText(String.valueOf(AfficheController.cin));
        fxnom.setText(String.valueOf(AfficheController.nom));
        fxprenom.setText(String.valueOf(AfficheController.prenom));
        fxsexe.setText(String.valueOf(AfficheController.sexe));
        fxage.setText(String.valueOf(AfficheController.age));
    }    
    
    @FXML
     private void modifier_user(ActionEvent event) {
        int id_user = Integer.parseInt(fxid.getText());
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String cin = fxCin.getText();
        String sexe = fxsexe.getText();
        int age = Integer.parseInt(fxage.getText());
        System.out.println(Integer.parseInt(AfficheController.id_user));
        Utilisateur u = new Utilisateur(cin, nom, prenom, sexe, age);
        utilisateurCRUD uc = new utilisateurCRUD();
        uc.modifierUtilisateur(u,Integer.parseInt(AfficheController.id_user));
         

         }
        
    
     
     }
           
           
            
       
        
    

