/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
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
public class Ajouter_clientController implements Initializable {

    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private Button fxbtn;
    @FXML
    private TextField fxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addcli(ActionEvent event) {
        Role r = new Role();
        roleCRUD rc = new roleCRUD();
        int id_role = Integer.parseInt(fxid.getText());
        String email = fxmail.getText();
        String password = fxpass.getText();
         r.setId_role(id_role);
        Client cli = new Client(r, email, password);
        rc.affecterRole2(cli, r);
        
    }
    
}
