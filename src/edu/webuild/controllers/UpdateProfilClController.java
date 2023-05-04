/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class UpdateProfilClController implements Initializable {

    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxtel;
    @FXML
    private TextField fxid;
    @FXML
    private TextField fxiduser;
    @FXML
    private TextField fxprenom;
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxcin;

    
    
    public void setClient(String email) throws SQLException{
    
      this.fxmail.setText(email);
        System.out.println(email);
        ClientCRUD cc = new ClientCRUD();
        Client client = cc.getClientUpdate(email);
        fxid.setText(String.valueOf(client.getId_client()));
        fxmail.setText(client.getEmail());
        fxtel.setText(String.valueOf(client.getTel()));
        fxcin.setText(client.getId_role().getId_user().getCin());
        fxnom.setText(client.getId_role().getId_user().getNom());
        fxprenom.setText(client.getId_role().getId_user().getPrenom());
        fxiduser.setText(String.valueOf(client.getId_role().getId_user().getId_user()));
    
    
    }
    
    
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
    private void modifier(ActionEvent event) throws SQLException {
        if (validateInputs()){
        int id = Integer.parseInt(fxid.getText());
        String email = fxmail.getText();
        int tel = Integer.parseInt(fxtel.getText());
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String cin = fxcin.getText();
        ClientCRUD cc = new ClientCRUD();

        //Client chauffeur = cc.getClientUpdate(email);
        // String chauffeurEmail = chauffeur.getEmail();
        cc.UpdateCli(tel , email, id);
        utilisateurCRUD uc = new utilisateurCRUD();
        int iduser=Integer.parseInt(fxiduser.getText());
        uc.UpdateUser(cin, nom, prenom,iduser);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update profile");
        alert.setHeaderText(null);
        alert.setContentText("Profile updated successfully.");
        alert.showAndWait();
      }
    }
    
     private boolean validateInputs() throws SQLException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (fxmail.getText().isEmpty() || fxtel.getText().isEmpty() || fxprenom.getText().isEmpty() || fxnom.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Error");
            alert1.setContentText("Please complete all fields");
            alert1.setHeaderText("Input control");
            alert1.show();
            return false;
        } else if (!fxmail.getText().matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
            return false;

        }
        return true;

    }
    
}
