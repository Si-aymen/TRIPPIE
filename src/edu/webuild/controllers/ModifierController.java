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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
         
       
        fxCin.setText(String.valueOf(AfficheController.cin));
        fxnom.setText(String.valueOf(AfficheController.nom));
        fxprenom.setText(String.valueOf(AfficheController.prenom));
        fxsexe.setText(String.valueOf(AfficheController.sexe));
        fxage.setText(String.valueOf(AfficheController.age));
    }    
    
    @FXML
     private void modifier_user(ActionEvent event) {
       InterfaceUserCRUD inter = new utilisateurCRUD();
        String cin = fxCin.getText();        
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String sexe = fxsexe.getText();
        int age = Integer.parseInt(fxage.getText());
        Utilisateur u = new Utilisateur(AfficheController.id_user,cin, nom, prenom, sexe,age);
        inter.modifierUtilisateur(u);
         
try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/afficher_user.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
         }
     
        
    
     
     }
           
           
            
       
        
    

