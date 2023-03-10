/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author manou
 */
public class DiscountController implements Initializable {

    @FXML
    private TextField press_1;
    @FXML
    private TextField discount;
    @FXML
    private Button pres;
    @FXML
    private Label discountshow;
    @FXML
    private Label test;
  Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       conn = MyConnection.getInstance().getConn();
    }    

    @FXML
    private void press(ActionEvent event) {
        String priceText = press_1.getText();
        String couponText = discount.getText();

        double price = Double.parseDouble(priceText);
        int discountPercentage = getDiscountPercentageFromDB(couponText);
        double discountedPrice = price * (100 - discountPercentage) / 100;

        if (discountPercentage > 0) {
    discountshow.setText(String.format("Discounted Price: %.2f", discountedPrice));
    test.setText("Your coupon code is valid");
} else  if (discountPercentage == 0) {
            
    test.setText("Invalid coupon code");
}
        
    }
      public int getDiscountPercentageFromDB(String couponCode) {
        try {
            // Fetch the discount percentage and number of times the coupon has been used for the given coupon code from the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT taux_reduction, nbr_utilisation   FROM coupon WHERE code_coupon='" + couponCode+ "'"  );
            if (rs.next()) {
                int discountPercentage = rs.getInt("taux_reduction");
                int nbrUtilisation = rs.getInt("nbr_utilisation");
            
         
               
           
PreparedStatement pst = conn.prepareStatement("INSERT INTO historique (taux_redu, code_coupon) VALUES ( ?, ?)");
            pst.setInt(1, discountPercentage);
            pst.setString(2, couponCode);
           
            pst.executeUpdate();
            
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
    

