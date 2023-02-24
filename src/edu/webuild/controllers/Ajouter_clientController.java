/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.services.roleCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/affiche_cl.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
    
}
