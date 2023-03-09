/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.interfaces.InterfaceCarte;
import edu.webuild.model.abonnement;
import edu.webuild.model.cartefidelite;
import edu.webuild.services.AbonnementCRUD;

import edu.webuild.services.CartefideliteCRUD;
import edu.webuild.utils.MyConnection;
import java.util.Date;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author mtirn
 */
public class AfficherCarteController implements Initializable {
    
    
    
     /**
     * Initializes the controller class.
     */
   @FXML
    private ListView<cartefidelite> listView;
    
    @FXML
    private ListView<cartefidelite> affichercarte;
      @FXML
    private Button btnEdit;
 
    
    @FXML
            private Button btndelete;
    
    
    int id_cf;
    String pointMerci;
    
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ListView<cartefidelite> list =(ListView<cartefidelite>)listView;
        
        CartefideliteCRUD abonnementCRUD = new CartefideliteCRUD();
        List<cartefidelite>list2=abonnementCRUD.affichercarte();
        for(int i=0; i<list2.size();i++)
        {cartefidelite a =list2.get(i);
        list.getItems().add(a);
        }
 
    }    
    
      private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
}
