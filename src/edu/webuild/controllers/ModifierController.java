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
    private TextField fxcin;
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
    private ListView<Utilisateur> afficheruser;
    
    @FXML
    private TextField fxid;
    @FXML
    private Button btnaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        
    }    
    
    @FXML
     private void modifier_user(ActionEvent event) {
         ListView<Utilisateur> listu = afficheruser;
        int id_user = Integer.parseInt(fxid.getText());
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String cin = fxcin.getText();
        String sexe = fxsexe.getText();
        int age = Integer.parseInt(fxage.getText());
        
        Utilisateur u = new Utilisateur(id_user,cin,nom,prenom,sexe,age);
        utilisateurCRUD uc = new utilisateurCRUD();
        uc.modifierUtilisateur(u,id_user);
         }
        
     @FXML
     private void refresh() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/afficher_user.fxml"));
        rootPane.getChildren().setAll(pane);
        }
     
     
     }
           
           
            
       
        
    

