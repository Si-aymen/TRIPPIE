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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class CardvoitureController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label fx_matricule;
    @FXML
    private Label fx_marque;
    @FXML
    private Label fx_puissance;
    @FXML
    private Label fx_prix_par_jour;
    @FXML
    private Label fx_energie;
    @FXML
    private Label fx_etat;

    /**
     * Initializes the controller class.
     */
     public void setData(int id,String matricule,String marque, String puissance, String url, String prix_jour,String energie,String etat) {
        fx_matricule.setText(matricule);
        fx_marque.setText(marque);
        fx_puissance.setText(puissance);
        String fullurl = "C:\\xampp\\htdocs\\image_trippie_cov\\" + url;
        fx_prix_par_jour.setText(prix_jour);
        fx_energie.setText(energie);
        fx_etat.setText(etat);
        
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
