/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.gui.LoginController;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilClientController implements Initializable {

    @FXML
    private Button exitBtn;
    @FXML
    private Label nom_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Label domain_lbl;
    @FXML
    private Label type_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Label bday_lbl;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    public void setEmail_lbl(String email) throws SQLException {
        this.email_lbl.setText(email);
        // TODO
                ClientCRUD u = new ClientCRUD();
        Client p = u.getClient(email);
         email_lbl.setText(email);
      
        System.out.println(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());  // Récupérer l'utilisateur connecté
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
        
        
        
    }   
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
    public void setUserInformation(String email) throws SQLException {

        System.out.println(email);


    }
}
