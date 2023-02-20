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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Supprimer_recController implements Initializable {

    @FXML
    private TextField supp_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimer_rec(ActionEvent event) {
        
        int id = Integer.parseInt(supp_id.getText());
        
        reclamationCRUD rc = new reclamationCRUD();
        
        rc.supprimerReclamation(id);
    }
    
}
