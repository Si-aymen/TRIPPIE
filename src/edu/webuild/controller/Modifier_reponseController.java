/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reponse;
import edu.webuild.services.reponseCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Modifier_reponseController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private TextField tf_etat;
    @FXML
    private TextArea tf_reponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tf_type.setText(String.valueOf(AfficheReponseController.type));
        tf_commentaire.setText(String.valueOf(AfficheReponseController.commentaire));
        tf_etat.setText(String.valueOf(AfficheReponseController.etat));
        tf_reponse.setText(String.valueOf(AfficheReponseController.rep));
    }    

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AfficheReponse.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        try {
            int id = AfficheReponseController.id_rep;
            String repo = tf_reponse.getText();
            String etat = tf_etat.getText();
            
            reponse r = new reponse(repo, id, etat);
            
            reponseCRUD rc = new reponseCRUD();
            
            rc.modifierReponse(r, id);

            Notifications n = Notifications.create()
                .title("WeBuild")
                .text("Réponse modifiée avec succé !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();
            
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AfficheReponse.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Modifier_recController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
