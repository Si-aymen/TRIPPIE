/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.services.roleCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Ajouter_locateurController implements Initializable {

    @FXML
    private TextField fxagence;
    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private TextField fxid;
    @FXML
    private Button btn;
    @FXML
    private PasswordField fxpass1;
    @FXML
    private ToggleButton showbtnnewnew;
    @FXML
    private ToggleButton showbtnnewnew1;
    @FXML
    private TextField fxtel;

    /**
     * Initializes the controller class.
     */
    
    
     /**
     *
     * @param id
     */
    public void SetId_role(String id) {
         this.fxid.setText(id);
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showbtnnewnew.setOnAction(event -> {
            if (showbtnnewnew.isSelected()) {
            fxpass.setPromptText(fxpass.getText());
            fxpass.setText("");
        } else {
            fxpass.setText(fxpass.getPromptText());
            fxpass.setPromptText("");
        }
        });
        showbtnnewnew1.setOnAction(event -> {
            if (showbtnnewnew1.isSelected()) {
            fxpass1.setPromptText(fxpass1.getText());
            fxpass1.setText("");
        } else {
            fxpass1.setText(fxpass1.getPromptText());
            fxpass1.setPromptText("");
        }
        });
    }    

    @FXML
    private void addloc(ActionEvent event) {
         Role r = new Role();
        roleCRUD rc = new roleCRUD();
        r.setId_role(Integer.parseInt(fxid.getText()));
        String nom_agence=fxagence.getText();
        int tel = Integer.parseInt(fxtel.getText());
        String email = fxmail.getText();
        String password = fxpass.getText();
        
          String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (nom_agence.isEmpty()|| email.isEmpty()|| password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.show();

        }
        else if (!email.matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse e-mail valide.");
            alert.showAndWait();
        } 
         else if(!(fxpass.getText().equals(fxpass1.getText()))){
        
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse e-mail valide.");
            alert.showAndWait();
        
        }
        else{
        Locateur loc = new Locateur(r, tel, nom_agence, email, password);
        rc.affecterRole3(loc, r);
       
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_locateurController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    }
}
