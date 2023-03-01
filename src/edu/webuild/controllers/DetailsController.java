/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private Button back;
    @FXML
    private Label fx_energie;

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
        fx_energie.setText(Afficher_voitureController.energie);
        
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @FXML
    private void back(ActionEvent event) {
         try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/afficher_voiture.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
