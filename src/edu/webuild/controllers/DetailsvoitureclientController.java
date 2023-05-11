/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.utils.MyConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DetailsvoitureclientController implements Initializable {

    @FXML
    private TextField search_bar;
    private Label depart_co_lab;
    private Label destination_co_lab;
    @FXML
    private ImageView imageView;
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
    @FXML
    private TextField code_coupon;
    @FXML
    private Label test;

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


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

   




    @FXML
    private void update_car(ActionEvent event) {
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

    @FXML
    private void reduction(ActionEvent event) {
        String priceText = price_lab.getText();
        String couponText = code_coupon.getText();

        double price = Double.parseDouble(priceText);
        int discountPercentage = getDiscountPercentageFromDB(couponText);
        double discountedPrice = price * (100 - discountPercentage) / 100;

        if (discountPercentage > 0) {
            price_lab.setText(String.valueOf(discountedPrice));
            test.setText("Your coupon code is valid");
        } else if (discountPercentage == 0) {

            test.setText("Invalid coupon code");
        } else {
            test.setText("Coupon code has expired");
        }
    }
    
    public int getDiscountPercentageFromDB(String couponCode) {
        try {
            // Fetch the discount percentage and number of times the coupon has been used for the given coupon code from the 
            Connection cnx2 = MyConnection.getInstance().getConn();
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT taux, nbr_utilisation   FROM coupon WHERE code_coupon='" + couponCode + "'");
            if (rs.next()) {
                int discountPercentage = rs.getInt("taux");
                int nbrUtilisation = rs.getInt("nbr_utilisation");

                PreparedStatement pst = cnx2.prepareStatement("INSERT INTO historique (taux_redu, code_coupon) VALUES ( ?, ?)");
                pst.setInt(1, discountPercentage);
                pst.setString(2, couponCode);

                pst.executeUpdate();
                // Update the number of times the coupon has been used in the database
                if (nbrUtilisation == 1) {
                    // Delete the coupon from the database when its usage count becomes zero
                    PreparedStatement pstmt = cnx2.prepareStatement("DELETE FROM coupon WHERE code_coupon=?");
                    pstmt.setString(1, couponCode);
                    pstmt.executeUpdate();
                } else {
                    // Update the usage count of the coupon in the database
                    PreparedStatement pstmt = cnx2.prepareStatement("UPDATE coupon SET nbr_utilisation=? WHERE code_coupon=?");
                    pstmt.setInt(1, nbrUtilisation - 1);
                    pstmt.setString(2, couponCode);
                    pstmt.executeUpdate();

                }

                return discountPercentage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
