/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceRoleCRUD;
import edu.webuild.interfaces.InterfaceUserCRUD;
import edu.webuild.model.Role;
import edu.webuild.model.Role;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;




/**
 * FXML Controller class
 *
 * @author aymen
 */


public class Affiche_roleController implements Initializable {
    static int id_role;
    static String libelle;
    static int id_user;
    @FXML
    private ListView<Role> listView;
    @FXML
    private Button btnsupp;
    @FXML
    private Button modifbtn;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 ListView list2 = listView;

        Role u = new Role();
        InterfaceRoleCRUD inter = new roleCRUD();
        List<Role> list = inter.afficherRole();
        for (int i = 0; i < list.size(); i++) {
            Role role = list.get(i);
            list2.getItems().add(role);
        }
        
        
         list2.setCellFactory(new Callback<ListView<Role>, ListCell<Role>>() {
            @Override
            public ListCell<Role> call(ListView<Role> listView) {
                return new ListCell<Role>() {
                    @Override
                    protected void updateItem(Role role, boolean empty) {
                        super.updateItem(role, empty);
                        if (role != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("%s",
                                    role.getLibelle())
                                    );
                                
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
        ListView<Role> list = listView;
        InterfaceRoleCRUD inter = new roleCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Role r = list.getSelectionModel().getSelectedItem();
            System.out.println(r.getId_role());
            inter.supprimerRole(r.getId_role());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un role à supprimer.");
        }
    }

    @FXML
    private void modifyuser(ActionEvent event) {
         ListView<Role> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceRoleCRUD inter = new roleCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        Role r = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_role=r.getId_role();
        libelle = r.getLibelle();
        

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_role.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
}
