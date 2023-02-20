/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Afficher_recController implements Initializable {

    @FXML
    private TextField aff_type;
    @FXML
    private TextArea aff_commentaire;
    @FXML
    private TextField id_rec;
    @FXML
    private Button btn_afficher;
    @FXML
    private TextField aff_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher_rec(ActionEvent event) {
        
        int id = Integer.parseInt(id_rec.getText());
        
        reclamationCRUD rc = new reclamationCRUD();
        
        reclamation r = rc.detailsReclamation(id);
        
        aff_type.setText(r.getType_rec());
        aff_commentaire.setText(r.getCommentaire());
        
    }
    
}
