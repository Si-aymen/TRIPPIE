/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.gui.LoginController;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
    private Label genre_lbl;
    @FXML
    private Button deco;

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
        exitBtn.setOnAction(e -> Platform.exit());
    }

    @FXML
    private void deco(ActionEvent event) {
          try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilChauffeurController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
   
}
