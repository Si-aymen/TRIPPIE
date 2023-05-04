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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Compare_CovController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private Label depart_covt1_lab;
    @FXML
    private Label destination_covt1_lab;
    @FXML
    private Label date_dep_covt1_lab;
    @FXML
    private Label nmbr_place_covt1_lab;
    @FXML
    private Label driber_rating_covt1_lab;
    @FXML
    private Label depart_covt2_lab;
    @FXML
    private Label destination_covt2_lab;
    @FXML
    private Label date_dep_covt2_lab;
    @FXML
    private Label driver_rating_covt2_lab;

    private CoVoiturage covt1, covt2;
    @FXML
    private Label nmbr_place_covt2_lab;
    @FXML
    private Label x;
    @FXML
    private ImageView ImageView_covt1;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Weather_cov Weath = new Weather_cov();
        covt1 = Afficher_CovController.covt1;
        covt2 = Afficher_CovController.covt2;
        depart_covt1_lab.setText(covt1.getDepart());
        destination_covt1_lab.setText(covt1.getDestination());
        date_dep_covt1_lab.setText(covt1.getDate_dep().toString());
        nmbr_place_covt1_lab.setText(Integer.toString(covt1.getNmbr_place()));
        depart_covt2_lab.setText(covt2.getDepart());
        destination_covt2_lab.setText(covt2.getDestination());
        date_dep_covt2_lab.setText(covt2.getDate_dep().toString());
        nmbr_place_covt2_lab.setText(Integer.toString(covt2.getNmbr_place()));
        String imagePath_covt1 = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Afficher_CovController.covt1.getCov_img();
        String imagePath_covt2 = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Afficher_CovController.covt2.getCov_img();
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
            Logger.getLogger(Compare_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dest1 = covt1.getDestination();

        try {
            temp11.setText(Weath.setTemp(place_dest1));
        } catch (IOException ex) {
            Logger.getLogger(Compare_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dep2 = covt2.getDepart();
        try {
            dest_temp.setText(Weath.setTemp(place_dep1));
        } catch (IOException ex) {
            Logger.getLogger(Compare_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String place_dest2 = covt2.getDestination();

        try {
            dest_temp1.setText(Weath.setTemp(place_dest1));
        } catch (IOException ex) {
            Logger.getLogger(Compare_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cov_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Menu_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void stats(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Piechart.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
