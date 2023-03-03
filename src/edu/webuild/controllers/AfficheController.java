/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceUserCRUD;
import edu.webuild.model.Role;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class AfficheController implements Initializable {

    
    static int id_user;
    static String cin;
    static String nom;
    static String prenom;
    static String sexe;
    static String age;
    
    @FXML
    private Button btnsupp;
    @FXML
    private Button modifbtn;
    @FXML
    private ListView<Utilisateur> listView;

  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 ListView list2 = listView;

        Utilisateur u = new Utilisateur();
        Role r=new Role();
        InterfaceUserCRUD inter = new utilisateurCRUD();
        List<Utilisateur> list = inter.afficherUtilisateur();
        for (int i = 0; i < list.size(); i++) {
            Utilisateur user = list.get(i);
            list2.getItems().add(user);
        }
        
        
         list2.setCellFactory(new Callback<ListView<Utilisateur>, ListCell<Utilisateur>>() {
            @Override
            public ListCell<Utilisateur> call(ListView<Utilisateur> listView) {
                return new ListCell<Utilisateur>() {
                    protected void updateItem(Utilisateur user, boolean empty) {
                        super.updateItem(user, empty);
                        if (user != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("CIN:%s - Nom:%s - Prenom:%s - Genre:%s  ",
                                    user.getCin(),
                                    user.getNom(),
                                    user.getPrenom(),
                                    user.getSexe()
                                   
                                    
                            ));
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }
       
    
     @FXML
    private void supprimer_user(ActionEvent event) {
        ListView<Utilisateur> list = listView;
        InterfaceUserCRUD inter = new utilisateurCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Utilisateur u = list.getSelectionModel().getSelectedItem();
            System.out.println(u.getId_user());
            inter.supprimerUtilisateurById(u.getId_user());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un utilisateur à supprimer.");
        }
    }

    

    @FXML
    private void modifyuser(ActionEvent event) {
         ListView<Utilisateur> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceUserCRUD inter = new utilisateurCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        Utilisateur u = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_user=u.getId_user();
        cin = u.getCin();
        nom = u.getNom();
        prenom = u.getPrenom();
        sexe = u.getSexe();

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_user.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
       
}
