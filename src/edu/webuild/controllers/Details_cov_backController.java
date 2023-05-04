/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import edu.webuild.services.Weather_cov;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Details_cov_backController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private Label depart_co_lab;
    @FXML
    private Label destination_co_lab;
    @FXML
    private Label nmbr_place_co_lab;
    @FXML
    private Label date_dep_co_lab;
    @FXML
    private ImageView imageView;
    @FXML
    private Label depart_co_lab1;
    @FXML
    private Label depart_co_lab11;
    @FXML
    private Label temp_lab;
    @FXML
    private Label weather_lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Weather_cov Weath = new Weather_cov();
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Show_cov_backController.url_img;
        System.out.println(imagePath);
        // id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        depart_co_lab.setText(String.valueOf(Show_cov_backController.depart));
        destination_co_lab.setText(String.valueOf(Show_cov_backController.destination));
        Date dateDep = Show_cov_backController.date_dep;
        date_dep_co_lab.setText(String.valueOf(Show_cov_backController.date_dep));
        nmbr_place_co_lab.setText(String.valueOf(Show_cov_backController.nmbr_place));
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        depart_co_lab1.setText(String.valueOf(Show_cov_backController.destination));
        depart_co_lab11.setText(String.valueOf(Show_cov_backController.destination));
        String place = String.valueOf(Show_cov_backController.destination);
        try {
            temp_lab.setText(Weath.setTemp(place));
        } catch (IOException ex) {
            Logger.getLogger(Details_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            weather_lab.setText(Weath.setWeather(place));
        } catch (IOException ex) {
            Logger.getLogger(Details_CovController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        depart_co_lab12.setText(String.valueOf(Afficher_CovController.depart));
//        depart_co_lab111.setText(String.valueOf(Afficher_CovController.depart));
//        String place2 = String.valueOf(Afficher_CovController.depart);
//        try {
//            temp_lab1.setText(Weath.setTemp(place2));
//        } catch (IOException ex) {
//            Logger.getLogger(Details_CovController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            weather_lab1.setText(Weath.setWeather(place2));
//        } catch (IOException ex) {
//            Logger.getLogger(Details_CovController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // TODO
    }

    @FXML
    private void add_part(ActionEvent event) {
    }

    @FXML
    private void Modify_btu(ActionEvent event) {
    }

    @FXML
    private void delete_btu(ActionEvent event) {
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        inter_co.supprimerCoVoiturage(Item_covController.covt.getId_co());
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Front/Market_cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
