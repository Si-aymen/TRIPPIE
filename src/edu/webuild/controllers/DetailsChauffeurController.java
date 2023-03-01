/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
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

    public void setEmail(String email2) {
        this.email.setText(email2);
        System.out.println(email2);
    }

    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
