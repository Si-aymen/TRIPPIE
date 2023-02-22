/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceRoleCRUD;
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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Modifier_roleController implements Initializable {

    @FXML
    private RadioButton fxclient;
    @FXML
    private RadioButton fxch;
    @FXML
    private RadioButton fxloc;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         fxch.setText(String.valueOf(Affiche_roleController.libelle));
         fxclient.setText(String.valueOf(Affiche_roleController.libelle));
        fxloc.setText(String.valueOf(Affiche_roleController.libelle));
    }    

    @FXML
    private void confirm(ActionEvent event) {
         InterfaceRoleCRUD inter = new roleCRUD();
          if(fxclient.isSelected()){
            String libelle=fxclient.getText();
            Role r=new Role(Affiche_roleController.id_role,libelle);
             r.setLibelle("Client");
             inter.modifierRole(r);
             try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_client.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
        }
        else if(fxch.isSelected()){
            String libelle=fxch.getText();
             Role r=new Role(Affiche_roleController.id_role,libelle);
             r.setLibelle("Chauffeur");
            inter.modifierRole(r);
             try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_chauffeur.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
        }
        else{
            fxloc.isSelected();
         String libelle=fxloc.getText();
            Role r=new Role(Affiche_roleController.id_role,libelle);
             r.setLibelle("Locateur");
            inter.modifierRole(r);
             try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_locateur.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
        }
          
    }
      

    }
    

