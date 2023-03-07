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
public class ClientCardFrontController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label fx_nom;
    @FXML
    private Label fx_prenom;

    
    
    
     public void setDataClient(String nom, String prenom,String url) {
        fx_nom.setText(nom);
        fx_prenom.setText(prenom);
        String fullurl = "C:\\xampp\\htdocs\\" + url ;
        System.out.println(fullurl);
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
