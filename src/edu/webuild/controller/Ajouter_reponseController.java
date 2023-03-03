/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import edu.webuild.services.reclamationCRUD;
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
public class Ajouter_reponseController implements Initializable {

    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private TextField tf_etat;
    @FXML
    private TextArea tf_reponse;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_type.setText(String.valueOf(AdminReclamationController.type_rec));
        tf_commentaire.setText(String.valueOf(AdminReclamationController.commentaire_rec));
        tf_etat.setText(String.valueOf(AdminReclamationController.etat_rec));
    }    

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/afficheReponse.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
        String rep = tf_reponse.getText();
        String etat = tf_etat.getText();
        
        if (rep.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Reponse manquante");
            alert.showAndWait();
        } else if (etat.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Etat manquant");
            alert.showAndWait();
        } else {
            
            rep = "(Admin): "+tf_reponse.getText();
            reponse r = new reponse(rep, AdminReclamationController.id, etat);

            reponseCRUD rc = new reponseCRUD();

            rc.ajouterReponse(r);

            Notifications n = Notifications.create()
                .title("WeBuild")
                .text("Réponse ajoutée !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/afficheReponse.fxml"));
            rootPane.getChildren().setAll(pane);
        }
    }
    
}
