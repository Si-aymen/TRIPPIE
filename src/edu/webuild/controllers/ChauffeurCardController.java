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
 * @author aymen
 */
public class ChauffeurCardController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setDataClient(String nom, String prenom,String libelle,String num_permis,String url) {
        fx_nom.setText(nom);
        fx_prenom.setText(prenom);
        fx_etat.setText(libelle);
        fx_nomage.setText(num_permis);
        String fullurl = "C:\\xampp\\htdocs\\" + url ;
        System.out.println(fullurl);
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
      
        
        
    }
    
}
