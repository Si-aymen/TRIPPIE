/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.ProfilChauffeurController.email;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class DetailsChauffeurController implements Initializable {

    @FXML
    private Label num;
    @FXML
    private Label marque;
    @FXML
    private Label couleur;
    @FXML
    private Label mat;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    ChauffeurCRUD ch = new ChauffeurCRUD();

    public void setEmail(String email) throws SQLException {
        
        this.email.setText(email);
        ChauffeurCRUD u = new ChauffeurCRUD();
        Chauffeur p = u.getChauffeur(email);
        nom.setText(p.getId_role().getId_user().getNom());
        prenom.setText(p.getId_role().getId_user().getPrenom());
        marque.setText(p.getMarque_voiture());
        couleur.setText(p.getCouleur_voiture());
        mat.setText(p.getImmatriculation());
       

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

  

}
