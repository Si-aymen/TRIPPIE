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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class ModifierAdminController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField modif_type;
    @FXML
    private TextField modif_etat;
    @FXML
    private TextArea modif_comm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modif_type.setText(String.valueOf(AdminReclamationController.type_rec));
        modif_comm.setText(String.valueOf(AdminReclamationController.commentaire_rec));
        modif_etat.setText(String.valueOf(AdminReclamationController.etat_rec));
    }    

    @FXML
    private void modifier_rec(ActionEvent event) {
        
        try {
            int id;
            id = Integer.parseInt(String.valueOf(AdminReclamationController.id_rec));
            String type = modif_type.getText();
            String commentaire = modif_comm.getText();
            String etat = modif_etat.getText();
            
            reclamation r = new reclamation(type, commentaire, etat);
            
            reclamationCRUD rc = new reclamationCRUD();
            
            rc.modifierReclamation(r, id);
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void retour_reclamation(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
