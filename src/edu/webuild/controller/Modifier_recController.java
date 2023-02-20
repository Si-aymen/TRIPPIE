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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Modifier_recController implements Initializable {

    @FXML
    private TextField modif_id;
    @FXML
    private TextField modif_type;
    @FXML
    private TextArea modif_comm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier_rec(ActionEvent event) {
        
        int id = Integer.parseInt(modif_id.getText());
        String type = modif_type.getText();
        String commentaire = modif_comm.getText();
        
        reclamation r = new reclamation(type, commentaire, "non traité");
        
        reclamationCRUD rc = new reclamationCRUD();
        
        rc.modifierReclamation(r, id);
    }
    
}
