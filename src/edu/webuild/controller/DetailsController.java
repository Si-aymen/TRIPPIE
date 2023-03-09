/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reponse;
import edu.webuild.services.reponseCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
 * @author guerf
 */
public class DetailsController implements Initializable {

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
    @FXML
    private Label date_cr;
    @FXML
    private ListView<reponse> liste_rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_reclamation\\" + Item_recController.r.getUrl_image();
        System.out.println(imagePath);
        //id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        typ.setText(String.valueOf(Item_recController.r.getType_rec()));
        comm.setText(String.valueOf(Item_recController.r.getCommentaire()));
        date_cr.setText(Item_recController.r.getDate_creation().toString());
        eta.setText(String.valueOf(Item_recController.r.getEtat()));
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        
        ListView list = liste_rep;
        reponse r = new reponse();
        reponseCRUD rec = new reponseCRUD();
        List<reponse> list1 = rec.getById_rep(Item_recController.r.getId_rec());
        for (int i = 0; i < list1.size(); i++) {
            reponse reponse = list1.get(i);
            list.getItems().add(reponse);
        }
    }    


    @FXML
    private void Modify_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);

        }
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

    @FXML
    private void repondre(ActionEvent event) {
    }
    
}
