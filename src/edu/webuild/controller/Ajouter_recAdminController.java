/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Ajouter_recAdminController implements Initializable {

    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private AnchorPane rootPane;
    
    public static int id_utilisateur = 1;
    
    int etatrecaptcha = 0;
    Stage window = new Stage();
    WebView webView2 = new WebView();
    WebEngine webEngine = new WebEngine();
    
    @FXML
    private ImageView recaptcha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recaptcha.setImage(new Image("/edu/webuild/images/google-captcha.jpg"));
    }    

    @FXML
    private void retour(MouseEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
        
            String type = tf_type.getText();
            String commentaire = tf_commentaire.getText();   
            LocalDate localDate = LocalDate.now();
            Date date_creation = Date.valueOf(localDate);
            
            if (type.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Type manquant");
            alert.showAndWait();
            }
            else if(commentaire.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Commentaire manquant");
            alert.showAndWait();
            }
            else{
            reclamation r = new reclamation(type, commentaire, "non traité", date_creation, id_utilisateur);

            reclamationCRUD rc = new reclamationCRUD();

            rc.ajouterReclamation(r);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Cette réclamation est ajoutée avec succés");
            alert.showAndWait();
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
            
            }
        
        
    }
        
    @FXML
    private void recaptcha(MouseEvent event) {
        //Block events to other windows
//            window.setTitle("Veuillez choisir un compte");
        webView2.setPrefSize(400, 500);
        webEngine.setUserAgent("use required / intended UA string");
        webEngine.load("https://www.google.com");

        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(webView2);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}
