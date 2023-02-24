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
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class RepondreController implements Initializable {

    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private TextArea tf_reponse;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_type.setText(String.valueOf(ReclamationController.type_rec));
        tf_commentaire.setText(String.valueOf(ReclamationController.commentaire_rec));
    }    

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/suivre_rec.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void repondre(ActionEvent event) {
        
        int id_rec = ReclamationController.id; 
        
        try {
            String reponse = "(Utilisateur): "+tf_reponse.getText();

            reponse r1 = new reponse(reponse, id_rec, "en cours de traitement");

            reponseCRUD rc = new reponseCRUD();

            rc.ajouterReponse(r1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Cette reponse est ajoutée avec succés");
            alert.showAndWait();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/suivre_rec.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AdminRepondreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
