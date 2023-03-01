/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Locateur;
import edu.webuild.services.LocateurCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilLocateurController implements Initializable {

    @FXML
    private Label nom_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Button exitBtn;

    /**
     * Initializes the controller class.
     */
    
    
    public void setEmail_lbl(String email) throws SQLException {
        this.email_lbl.setText(email);
        // TODO
            LocateurCRUD u = new LocateurCRUD();
            Locateur p = u.getLocateur(email);
         email_lbl.setText(email);
      
        System.out.println(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());  // Récupérer l'utilisateur connecté
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) {
         exitBtn.setOnAction(e -> Platform.exit());
    }
    
}
