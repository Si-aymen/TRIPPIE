/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Discount1Controller implements Initializable {

    @FXML
    private TextField press_1;
    @FXML
    private TextField discount;
    @FXML
    private Button pres;
 private Connection conn;
    @FXML
    private Label discountshow;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/promotion", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void press(ActionEvent event) {
            String priceText = press_1.getText();
        String couponText = discount.getText();

        double price = Double.parseDouble(priceText);
        int discountPercentage = getDiscountPercentageFromDB(couponText);
        double discountedPrice = price * (100 - discountPercentage) / 100;

        discountshow.setText(String.format("Discounted Price: %.2f", discountedPrice));
    }
     public int getDiscountPercentageFromDB(String couponCode) {
        try {
            // Fetch the discount percentage and number of times the coupon has been used for the given coupon code from the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT taux_reduction, nbr_utilisation FROM coupon WHERE code_coupon='" + couponCode + "'");
            if (rs.next()) {
                int discountPercentage = rs.getInt("taux_reduction");
                int nbrUtilisation = rs.getInt("nbr_utilisation");

                // Update the number of times the coupon has been used in the database
                if (nbrUtilisation == 1) {
                    // Delete the coupon from the database when its usage count becomes zero
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM coupon WHERE code_coupon=?");
                    pstmt.setString(1, couponCode);
                    pstmt.executeUpdate();
                } else {
                    // Update the usage count of the coupon in the database
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE coupon SET nbr_utilisation=? WHERE code_coupon=?");
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
