/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.CoVoiturage;
import edu.webuild.services.Weather_cov;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Comp_covController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private Label depart_covt1_lab;
    @FXML
    private Label destination_covt1_lab;
    @FXML
    private Label date_dep_covt1_lab;
    @FXML
    private Label nmbr_place_covt1_lab;
    @FXML
    private Label depart_covt2_lab;
    @FXML
    private Label nmbr_place_covt2_lab;
    @FXML
    private ImageView ImageView_covt2;
    @FXML
    private Label temp1;
    @FXML
    private Label temp11;
    @FXML
    private Label dest_temp;
    @FXML
    private Label dest_temp1;
    @FXML
    private ImageView ImageView_covt1;
    static public CoVoiturage covt1, covt2;
    @FXML
    private Label destination_covt2_lab;
    @FXML
    private Label date_dep_covt2_lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Weather_cov Weath = new Weather_cov();
        covt1 = Show_cov_backController.covt1;
        covt2 = Show_cov_backController.covt2;
        depart_covt1_lab.setText(covt1.getDepart());
        destination_covt1_lab.setText(covt1.getDestination());
        date_dep_covt1_lab.setText(covt1.getDate_dep().toString());
        nmbr_place_covt1_lab.setText(Integer.toString(covt1.getNmbr_place()));
        depart_covt2_lab.setText(covt2.getDepart());
        destination_covt2_lab.setText(covt2.getDestination());
        date_dep_covt2_lab.setText(covt2.getDate_dep().toString());
        nmbr_place_covt2_lab.setText(Integer.toString(covt2.getNmbr_place()));
        String imagePath_covt1 = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Show_cov_backController.covt1.getCov_img();
        String imagePath_covt2 = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Show_cov_backController.covt2.getCov_img();
        try {
            ImageView_covt1.setImage(new Image(new FileInputStream(imagePath_covt1)));
            ImageView_covt2.setImage(new Image(new FileInputStream(imagePath_covt2)));

        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        String place_dep1 = covt1.getDepart();
        try {
            temp1.setText(Weath.setTemp(place_dep1));
        } catch (IOException ex) {
            Logger.getLogger(Comp_covController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dest1 = covt1.getDestination();

        try {
            temp11.setText(Weath.setTemp(place_dest1));
        } catch (IOException ex) {
            Logger.getLogger(Comp_covController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dep2 = covt2.getDepart();
        try {
            dest_temp.setText(Weath.setTemp(place_dep1));
        } catch (IOException ex) {
            Logger.getLogger(Comp_covController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dest2 = covt2.getDestination();

        try {
            dest_temp1.setText(Weath.setTemp(place_dest1));
        } catch (IOException ex) {
            Logger.getLogger(Comp_covController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }

}
