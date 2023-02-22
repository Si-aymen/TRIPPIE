/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import edu.webuild.utils.MyConnection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class AjoutController implements Initializable {

   
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
    private Button btnajout;
    
   
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }


    
    
    
    @FXML
    private void adduser(ActionEvent event) throws IOException { 
        btnajout.setOnAction(e -> {
           
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String cin = fxcin.getText();
        String sexe = fxsexe.getText();
        int age = Integer.parseInt(fxage.getText());
        if(age<=18){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur +18 ");
        alert.show();
        }
        else if(Character.isLowerCase(nom.charAt(0))){
        
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur le nom doit commence par majuscule");
        alert.show();
        
        }
        else if(Character.isLowerCase(prenom.charAt(0))){
        
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur le prenom doit commence par majuscule");
        alert.show();
        
        }
        else if(cin.length() != 8){
        
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur le cin doit etre 8 chiffres");
        alert.show();
        
        }
        else{
        Utilisateur u = new Utilisateur( cin, nom, prenom, sexe, age);
        utilisateurCRUD uc = new utilisateurCRUD();
        uc.ajouterUtilisateur(u);
        
          try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_role.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
       }
        
       
    }
        );
    
    
    
    
    }
}
       

        
    


