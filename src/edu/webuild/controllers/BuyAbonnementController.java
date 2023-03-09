/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.frog.FroggerApp;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class BuyAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private ListView<abonnement> listView;
    
    @FXML
    private ListView<abonnement> affichageabonnement;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ListView<abonnement> list =(ListView<abonnement>)listView;
        
        
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
        List<abonnement>list2=abonnementCRUD.afficherabonnement();
        for(int i=0; i<list2.size();i++)
        {abonnement a =list2.get(i);
        list.getItems().add(a);
        }
 
    }    
    @FXML
private void buyabonnement(ActionEvent event) {
     
}

}
