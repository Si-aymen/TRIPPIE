/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Details_Front_covController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private Label typ;
    @FXML
    private Label comm;
    @FXML
    private Label eta;
    @FXML
    private ImageView imageView;
    @FXML
    private Button cov_btu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void Modify_btu(ActionEvent event) {
    }

    @FXML
    private void delete_btu(ActionEvent event) {
    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }
    
}
