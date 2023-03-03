/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.AjoutController.url_image;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilChauffeurController implements Initializable {

    @FXML
    private Label nom_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Button exitBtn;
    @FXML
    private Button btn;

    @FXML
    private ImageView fximg;
    static String url_image;
    static String E;

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
    private Label emaill;
    @FXML
    private Label gsm;
    static String ssmail;

    public void setEmail_lbl(String email) throws SQLException {
        this.email_lbl.setText(email);
        ChauffeurCRUD u = new ChauffeurCRUD();
        Chauffeur p = u.getChauffeur(email);
        email_lbl.setText(email);
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

//    @FXML
//    private void details(ActionEvent event) {
//       email.setText(E);
//        System.out.println(E);
//    }
    
}
