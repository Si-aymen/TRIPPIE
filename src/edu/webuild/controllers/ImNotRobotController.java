/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ImNotRobotController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image9;
    @FXML
    private CheckBox notRobot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void valide(ActionEvent event) throws IOException {
//        UtilisateurFXMLController u = new UtilisateurFXMLController();
        if (u.login.equals("admin") && u.password.equals("admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage2 = new Stage();
            primaryStage2.setTitle("Offre");
            primaryStage2.setScene(scene);
            primaryStage2.show();
            Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
            primaryStage3.close();
        } else {
//            UtilisateurController us = new UtilisateurController();
//            Utilisateur ut = us.getUserLogin(u.login, u.password);
            if (ut == null) {
                /*u.cdsLogin.setText("Incorrect");
                u.cdsPass.setText("Incorrect");

                u.setTimerIncorrect();*/
                Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
                primaryStage3.close();
                return;
            } else {
                System.out.println("User ( id :" + ut.getId() + " ) Connected succefully  ");
                Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
                primaryStage3.close();
            }
        }
    }

}
