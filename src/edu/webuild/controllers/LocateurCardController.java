/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Locateur;
import edu.webuild.services.LocateurCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class LocateurCardController implements Initializable {

    @FXML
    private Label fx_nom;
    @FXML
    private Label fx_prenom;
    @FXML
    private Label fx_etat;
    @FXML
    private ImageView img;
    @FXML
    private Label fx_nomage;
    @FXML
    private Button disablebtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     public void setDataLocateur(String nom, String prenom,String nom_agence,String libelle,String url) {
        fx_nom.setText(nom);
        fx_prenom.setText(prenom);
        fx_etat.setText(libelle);
        fx_nomage.setText(nom_agence);
        String fullurl = "C:\\xampp\\htdocs\\" + url ;
        System.out.println(fullurl);
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
         disablebtn.setOnAction(e -> {
            try {
                LocateurCRUD cc = new LocateurCRUD();
                Locateur c = cc.getLocateurCard(nom_agence);
                cc.disableLocateur(c.getNom_agence());
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Disable user");
                    alert.setHeaderText("You are about to disable user ");
                    alert.setContentText("Are you sure you want to continue ?");
            } catch (SQLException ex) {
                Logger.getLogger(ChauffeurCardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
        
        
    }

    @FXML
    private void disable(ActionEvent event) {
    }
}
