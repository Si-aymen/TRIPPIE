/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.services.roleCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Ajouter_locateurController implements Initializable {

    @FXML
    private TextField fxagence;
    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private TextField fxid;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addloc(ActionEvent event) {
         Role r = new Role();
        roleCRUD rc = new roleCRUD();
        int id_role = Integer.parseInt(fxid.getText());
        String email = fxmail.getText();
        String password = fxpass.getText();
         r.setId_role(id_role);
        Locateur loc = new Locateur(r, email, email, password);
        rc.affecterRole3(loc, r);
    }
    
}
