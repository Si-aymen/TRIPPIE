/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Affiche_recUniqueController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextArea commentaire;
    @FXML
    private TextField etat;
    @FXML
    private DatePicker date;
    @FXML
    private ImageView piece_jointe;
    
    public static LocalDate localdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.setText(String.valueOf(AdminReclamationController.type_rec));
        commentaire.setText(String.valueOf(AdminReclamationController.commentaire_rec));
        etat.setText(String.valueOf(AdminReclamationController.etat_rec));
        date.setPromptText(AdminReclamationController.date.toString());
    }    
    
}
