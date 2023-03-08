/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.interfaces.InterfaceAbonnement;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.gui.afficherAbonnement;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class AfficherAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private ListView<abonnement> listView;
    
    @FXML
    private ListView<abonnement> affichageabonnement;
    @FXML
    private Button supprimerabonnement;
    @FXML
    private Button modifierabonnement;
    static Date date_debut;
    static Date date_fin;
    static int id;
    static abonnement abonnement;
      ObservableList<abonnement> abonnements = FXCollections.observableArrayList();
              AbonnementCRUD abonnementCRUD = new AbonnementCRUD();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      // Call the afficherabonnement() method to retrieve the list of abonnements from the database
        List<abonnement> list = abonnementCRUD.afficherabonnement();
        // Convert the list to an ObservableList and store it in the abonnements instance variable
        abonnements = FXCollections.observableArrayList(list);
  // Set the items property of the ListView to the abonnements list
        listView.setItems(abonnements);
        
        
        
        
         //System.out.println( abonnementCRUD.afficherabonnement());


        
    }    
    
    
    
    
}
