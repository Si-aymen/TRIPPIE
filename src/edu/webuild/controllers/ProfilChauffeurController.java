/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.reclamationCRUD;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

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
    String url_image;

    static String ssmail;
    @FXML
    private Button deco;
    String url;
    @FXML
    private Button modif;
    @FXML
    private Button ajouter_cov;

    public static Chauffeur ch;
    
    public static int id_util;
    
    public static Role role = new Role();

    public void setEmail_lbl(String email) throws SQLException, FileNotFoundException {

        this.email_lbl.setText(email);
        ChauffeurCRUD u = new ChauffeurCRUD();
        Chauffeur p = u.getChauffeur(email);
        ch = p;
        email_lbl.setText(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
        String fullurl = "C:\\xampp\\htdocs\\" + p.getImg();
        File file = new File(fullurl);
        FileInputStream fileInputStream = new FileInputStream(file);
        Image image = new Image(fileInputStream);
        fximg.setImage(image);
        // Créer un objet Circle avec le rayon et la position souhaités
        Circle circle = new Circle();
        circle.setRadius(fximg.getFitWidth() / 2);
        circle.setCenterX(fximg.getFitWidth() / 2);
        circle.setCenterY(fximg.getFitHeight() / 2);
        // Utiliser le Circle comme clip
        fximg.setClip(circle);

// Définir la taille de l'ImageView pour qu'elle soit égale au diamètre du cercle
        fximg.setFitWidth(circle.getRadius() * 2);
        fximg.setFitHeight(circle.getRadius() * 2);

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

    private void update(ActionEvent event) throws SQLException {
        try {
            String email = email_lbl.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/UpdateProfilCh.fxml"));
            Parent root = loader.load();
            UpdateProfilChController controller = loader.getController();
            // set any necessary information in the controller
            email_lbl.getScene().setRoot(root);
            controller.setChauffeur(email);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilChauffeurController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Update(ActionEvent event) {
    }

    @FXML
    private void cov_btu(ActionEvent event) {
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

    @FXML
    private void reclamation(ActionEvent event) throws IOException {

        id_util = ch.getId_ch();

        Chauffeur cha = new Chauffeur();
        
        reclamationCRUD rc = new reclamationCRUD();

        cha = rc.getByIdChauffeur(id_util);

        role = cha.getId_role();

        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
