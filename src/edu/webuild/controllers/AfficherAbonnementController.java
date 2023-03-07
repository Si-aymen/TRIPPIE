/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.interfaces.InterfaceAbonnement;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
    private ListView<abonnement> affichageabonnement;
    @FXML
    private Button supprimerabonnement;
    @FXML
    private Button modifierabonnement;
    static Date date_debut;
    static Date date_fin;
    static int id;
    static abonnement abonnement;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // ListView<abonnement> list1 = affichageabonnement;
              AbonnementCRUD abonnementCRUD = new AbonnementCRUD();

      //  List<abonnement> list2 = abonnementCRUD.afficherabonnement();
         System.out.println( abonnementCRUD.afficherabonnement());
//        for (int i = 0; i < list2.size(); i++) {
//            abonnement a = list2.get(i);
//            list1.getItems().add(a);
//
//        }

        
    }    
    
    
    
    
}
