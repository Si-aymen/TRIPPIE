/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.services.voitureCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class DetailsvoiturefrontController implements Initializable {

    @FXML
    private TextField search_bar;
    private Label depart_co_lab;
    private Label destination_co_lab;
    @FXML
    private ImageView imageView;
    @FXML
    private Button cov_btu;
    @FXML
    private Label matricule_lab;
    @FXML
    private Label brand_lab;
    @FXML
    private Label power_lab;
    @FXML
    private Label price_lab;
    @FXML
    private Label energy_lab;
    @FXML
    private Label staus_lab;
    static String matricule;
    static String marque;
    static String puissance;
    static String prix_jours;
    static String energie;
    static String etat;
    static String imagePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String imagePath = "C:\\xampp\\htdocs\\image_trippie_cov\\" + CardvoitureController.vo.getImage_voiture();
        matricule_lab.setText(String.valueOf(CardvoitureController.vo.getMatricule()));
        brand_lab.setText(String.valueOf(CardvoitureController.vo.getMarque()));
        power_lab.setText(String.valueOf(CardvoitureController.vo.getPuissance()));
        price_lab.setText(String.valueOf(CardvoitureController.vo.getPrix_jours()));
        energy_lab.setText(String.valueOf(CardvoitureController.vo.getEnergie()));
        staus_lab.setText(String.valueOf(CardvoitureController.vo.getEtat()));
        String matricule = String.valueOf(CardvoitureController.vo.getMatricule());
        String marque = String.valueOf(CardvoitureController.vo.getMarque());
        String puissance = String.valueOf(CardvoitureController.vo.getPuissance());
        String prix_jours = String.valueOf(CardvoitureController.vo.getPrix_jours());
        String energie = String.valueOf(CardvoitureController.vo.getEnergie());
        String etat = String.valueOf(CardvoitureController.vo.getEtat());

        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }

    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void delete_car(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("are you sure to delete this car ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            InterfaceCRUD inter_co = new voitureCRUD();
            inter_co.supprimervoiture(CardvoitureController.vo.getId());
            showAlert("car has been successfully deleted");
        }

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketvoiturefront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void update_car(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifiervoiturefront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void reserve(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_reservationfront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
