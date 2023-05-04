/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import edu.webuild.utils.MyConnection;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class UpdateProfilChController implements Initializable {

    @FXML
    private TextField fxperm;
    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxtel;
    @FXML
    private TextField fxcin;
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxprenom;
    //private Chauffeur chauffeur;

    @FXML
    private TextField fxid;
    @FXML
    private TextField fxiduser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setChauffeur(String email) throws SQLException {

        this.fxmail.setText(email);
        System.out.println(email);
        ChauffeurCRUD cc = new ChauffeurCRUD();
        Chauffeur chauffeur = cc.getChauffeurUpdate(email);
        fxid.setText(String.valueOf(chauffeur.getId_ch()));
        fxperm.setText(chauffeur.getNum_permis());
        fxmail.setText(chauffeur.getEmail());
        fxtel.setText(String.valueOf(chauffeur.getTel()));
        fxcin.setText(chauffeur.getId_role().getId_user().getCin());
        fxnom.setText(chauffeur.getId_role().getId_user().getNom());
        fxprenom.setText(chauffeur.getId_role().getId_user().getPrenom());
        fxiduser.setText(String.valueOf(chauffeur.getId_role().getId_user().getId_user()));
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        if (validateInputs()) {
            int id = Integer.parseInt(fxid.getText());
            String num_permis = fxperm.getText();
            String email = fxmail.getText();
            int tel = Integer.parseInt(fxtel.getText());
            String nom = fxnom.getText();
            String prenom = fxprenom.getText();
            String cin = fxcin.getText();
            ChauffeurCRUD cc = new ChauffeurCRUD();

            //Chauffeur chauffeur = cc.getChauffeurUpdate(email);
            // String chauffeurEmail = chauffeur.getEmail();
            cc.UpdateCh(tel, num_permis, email, id);
            utilisateurCRUD uc = new utilisateurCRUD();
            int iduser = Integer.parseInt(fxiduser.getText());
            uc.UpdateUser(cin, nom, prenom, iduser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update profile");
            alert.setHeaderText(null);
            alert.setContentText("Profile updated successfully.");
            alert.showAndWait();

        }

    }

    private boolean validateInputs() throws SQLException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (fxperm.getText().isEmpty() || fxmail.getText().isEmpty() || fxtel.getText().isEmpty() || fxprenom.getText().isEmpty() || fxnom.getText().isEmpty()) {
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
