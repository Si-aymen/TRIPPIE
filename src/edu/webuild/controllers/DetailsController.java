/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class DetailsController implements Initializable {

    @FXML
    private TextField fx_matricule;
    @FXML
    private TextField fx_modele;
    @FXML
    private TextField fx_puissance;
    @FXML
    private TextField fx_prix_jours;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Afficher_voitureController.url_img;
        System.out.println("url " +"C:\\xampp\\htdocs\\image_trippie_cov\\" + Afficher_voitureController.url_img);
        fx_matricule.setText(Afficher_voitureController.matricule);
        fx_modele.setText(Afficher_voitureController.marque);
        fx_puissance.setText(Afficher_voitureController.Puissence);
        fx_prix_jours.setText(Afficher_voitureController.Prix_jour);
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

}
