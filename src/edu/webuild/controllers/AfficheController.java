/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceUserCRUD;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class AfficheController implements Initializable {

    @FXML
    private ListView<Utilisateur> afficheruser;
    static int id_user;
    static String cin;
    static String nom;
    static String prenom;
    static String sexe;
    static int age;
    @FXML
    private Button btnsupp;

  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ListView<Utilisateur> listu = afficheruser;
        InterfaceUserCRUD inter = new utilisateurCRUD();
        List<Utilisateur> list2 = inter.afficherUtilisateur();
        for (int i = 0; i < list2.size(); i++) {
            Utilisateur u = list2.get(i);
            listu.getItems().add(u);

        }
    }   
    
     @FXML
    private void supprimer_user(ActionEvent event) {
        ListView<Utilisateur> list = afficheruser;
        InterfaceUserCRUD inter = new utilisateurCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Utilisateur u = list.getSelectionModel().getSelectedItem();
            System.out.println(u.getId_user());
            inter.supprimerUtilisateurById(u.getId_user());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner une voiture à supprimer.");
        }
    }
    
       
}
