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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Details_CovController implements Initializable {

    @FXML
    private TextField id_co_TF;
    @FXML
    private TextField depart_TF;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private Button cov_btu;
    @FXML
    private DatePicker Date_pk;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Afficher_CovController.url_img);
        id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        depart_TF.setText(String.valueOf(Afficher_CovController.depart));
        destination_TF.setText(String.valueOf(Afficher_CovController.destination));
        Date_pk.setPromptText(Afficher_CovController.date_dep.toString());
        nmbr_place_TF.setText(String.valueOf(Afficher_CovController.nmbr_place));
      //imageView.setImage(new Image(Afficher_CovController.url_img));
      
        Image i = new Image(Afficher_CovController.url_img);
        imageView.setImage(i);
    }

    @FXML
    private void add_image(ActionEvent event) {
    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

}
