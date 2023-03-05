/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import edu.webuild.utils.MyConnection;
import java.io.FileOutputStream;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilChauffeurController implements Initializable {

    @FXML
    private Label nom_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Button exitBtn;
    MyConnection conn;
    @FXML
    private ImageView fximg;
    static String url_image;

    static String ssmail;
    @FXML
    private Button deco;
    String url;

    public void setEmail_lbl(String email) throws SQLException, FileNotFoundException {

        this.email_lbl.setText(email);
        ChauffeurCRUD u = new ChauffeurCRUD();
        Chauffeur p = u.getChauffeur(email);
        String fullurl = "C:\\xampp\\htdocs\\" + url;
        try {
            email_lbl.setText(email);
            nom_lbl.setText(p.getId_role().getId_user().getNom());
            genre_lbl.setText(p.getId_role().getId_user().getPrenom());
            fximg.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String imagePath = "C:\\xampp\\htdocs\\" + url_img;
    }

    @FXML
    private void exit(ActionEvent event) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

    @FXML
    private void deco(ActionEvent event) {
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilChauffeurController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
