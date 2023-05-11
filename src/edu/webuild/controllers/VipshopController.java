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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VipshopController implements Initializable {

    @FXML
    private CheckBox check2;
    @FXML
    private Label gift1;
    @FXML
    private CheckBox check1;
    @FXML
    private Label desc1;
    @FXML
    private Label desc11;
    @FXML
    private Label gift2;
    @FXML
    private Label gift3;
    @FXML
    private Label desc111;
    @FXML
    private CheckBox check3;
    @FXML
    private Label gift4;
    @FXML
    private Label desc12;
    @FXML
    private CheckBox check4;
    @FXML
    private Label gift5;
    @FXML
    private Label desc13;
    @FXML
    private CheckBox check5;
    @FXML
    private Label gift6;
    @FXML
    private Label desc131;
    @FXML
    private CheckBox check6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webuild3", "root", "");
            PreparedStatement stmt = conn.prepareStatement("SELECT nom_cadeay,description FROM cadeau");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                gift1.setText(rs.getString("nom_cadeay"));
                desc1.setText(rs.getString("description"));
            }
            if (rs.next()) {
                gift2.setText(rs.getString("nom_cadeay"));
                desc11.setText(rs.getString("description"));
            }
            if (rs.next()) {
                gift3.setText(rs.getString("nom_cadeay"));
                desc111.setText(rs.getString("description"));
            }
            if (rs.next()) {
                gift4.setText(rs.getString("nom_cadeay"));
                desc12.setText(rs.getString("description"));
            }
            if (rs.next()) {
                gift5.setText(rs.getString("nom_cadeay"));
                desc13.setText(rs.getString("description"));
            }
            if (rs.next()) {
                gift6.setText(rs.getString("nom_cadeay"));
                desc1.setText(rs.getString("description"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        check1.setOnAction(event -> {
            if (check1.isSelected()) {
                check2.setSelected(false);
                check3.setSelected(false);
                check4.setSelected(false);
                check5.setSelected(false);
                check6.setSelected(false);
            }
        });

        check2.setOnAction(event -> {
            if (check2.isSelected()) {
                check1.setSelected(false);
                check3.setSelected(false);
                check4.setSelected(false);
                check5.setSelected(false);
                check6.setSelected(false);
            }
        });
        
          check3.setOnAction(event -> {
            if (check3.isSelected()) {
                check1.setSelected(false);
                 check2.setSelected(false);
             
                check4.setSelected(false);
                check5.setSelected(false);
                check6.setSelected(false);
            }
        });
           check4.setOnAction(event -> {
            if (check4.isSelected()) {
                check1.setSelected(false);
                  check2.setSelected(false);
                check3.setSelected(false);
                check5.setSelected(false);
                check6.setSelected(false);
            }
        });
            check5.setOnAction(event -> {
            if (check5.isSelected()) {
                check1.setSelected(false);
                  check2.setSelected(false);
                check3.setSelected(false);
                check4.setSelected(false);
                check6.setSelected(false);
            }
        });
             check6.setOnAction(event -> {
            if (check6.isSelected()) {
                check1.setSelected(false);
                  check2.setSelected(false);
                check3.setSelected(false);
                check5.setSelected(false);
                check4.setSelected(false);
            }
        });
    }    

    @FXML
    private void get(ActionEvent event) {
//          String selectedGift = "";
//    if (check1.isSelected()) {
//        selectedGift = gift1.getText();
//    } else if (check2.isSelected()) {
//        selectedGift = gift2.getText();
//    } // Add more conditions for other check boxes as needed
//    else if (check3.isSelected()) {
//        selectedGift = gift3.getText();
//    }
//    else if (check4.isSelected()) {
//        selectedGift = gift4.getText();
//    }
//    else if (check5.isSelected()) {
//        selectedGift = gift5.getText();
//    }else if (check6.isSelected()) {
//        selectedGift = gift6.getText();
//    }
//
//    String clientName = "John Doe"; // Replace with actual client name
//
//    String message = "Dear " + clientName + ",\n\n"
//            + "I am writing this email to confirm your Co_voiturage reservation for the following details:\n\n"
//            + "Gift: " + selectedGift + "\n"
//            + "Please note that the departure time is " + selectedGift + ". We kindly ask you to arrive at the pickup location 15 minutes before departure time to avoid any delays.\n\n"
//            + "Best regards,";
//
//    EmailSender.sendEmail_add("rimmdimagh12@gmail.com", message);
    }
    
}
