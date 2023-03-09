/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Details_cov_back_mController implements Initializable {

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
    @FXML
    private Button cov_btu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Weather_cov Weath = new Weather_cov();
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_cov\\" + Item_covController.covt.getCov_img();
        System.out.println(imagePath);
        //id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        depart_co_lab.setText(String.valueOf(Item_covController.covt.getDepart()));
        destination_co_lab.setText(String.valueOf(Item_covController.covt.getDestination()));
        Date dateDep = Item_covController.covt.getDate_dep();
        date_dep_co_lab.setText(String.valueOf(Item_covController.covt.getDate_dep()));
        nmbr_place_co_lab.setText(String.valueOf(Item_covController.covt.getNmbr_place()));
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        depart_co_lab1.setText(String.valueOf(Item_covController.covt.getDestination()));
        depart_co_lab11.setText(String.valueOf(Item_covController.covt.getDestination()));
        String place = String.valueOf(Item_covController.covt.getDestination());
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
    }

}
