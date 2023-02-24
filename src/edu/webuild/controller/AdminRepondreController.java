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
public class AdminRepondreController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextArea commentaire;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea tf_reponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        type.setText(String.valueOf(AdminReclamationController.type_rec));
        commentaire.setText(String.valueOf(AdminReclamationController.commentaire_rec));
    }    

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void repondre(ActionEvent event) {
        
        int id_rec = AdminReclamationController.id; 
        
        try {
            String reponse = "(Admin): "+tf_reponse.getText();

            reponse r1 = new reponse(reponse, id_rec, "en cours de traitement");

            reponseCRUD rc = new reponseCRUD();

            rc.ajouterReponse(r1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Cette reponse est ajoutée avec succés");
            alert.showAndWait();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AdminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AdminRepondreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
