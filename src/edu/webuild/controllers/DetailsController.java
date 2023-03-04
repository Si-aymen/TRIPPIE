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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class DetailsController implements Initializable {

    private TextField fx_matricule;
    private TextField fx_modele;
    private TextField fx_puissance;
    @FXML
    private Label fx_prix_jours;
    @FXML
    private ImageView imageView;
    @FXML
    private Label fxx_matricule;
    @FXML
    private Label fxx_modele;
    @FXML
    private Label fxx_puissance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Afficher_voitureController.url_img;
        fxx_matricule.setText(String.valueOf(Afficher_voitureController.matricule));
        fxx_modele.setText(String.valueOf(Afficher_voitureController.marque));
        fxx_puissance.setText(String.valueOf(Afficher_voitureController.Puissence));

        fx_prix_jours.setText(Afficher_voitureController.Prix_jour);
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

}
