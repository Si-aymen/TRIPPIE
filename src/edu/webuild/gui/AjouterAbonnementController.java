/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;
import edu.webuild.interfaces.InterfaceAbonnement;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.gui.ajouterAbonnement;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.net.URL;

import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class AjouterAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField tfType;
     @FXML
    private TextField tfPrix;
      @FXML
    private DatePicker tfdateAchat;
       @FXML
    private DatePicker tfdateExpiration;
        @FXML
    private Button btnAjouter;
    
    
    
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void ajouterabonnement(ActionEvent event){
    String type = tfType.getText();
   int prix=Integer.parseInt(tfPrix.getText());
     Date dateAchat = java.sql.Date.valueOf(tfdateAchat.getValue());
     Date dateExpiration = java.sql.Date.valueOf(tfdateExpiration.getValue());
        
        
        abonnement abonnement = new abonnement(type,prix,dateAchat, dateExpiration);
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
         abonnementCRUD.ajouterabonnement(abonnement);
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("abonnement insérée avec succés!");
        alert.show();
    
    
    
    
    
    }
    
}
