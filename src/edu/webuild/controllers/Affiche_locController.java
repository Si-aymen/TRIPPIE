/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Locateur;
import edu.webuild.services.LocateurCRUD;
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
public class Affiche_locController implements Initializable {

    static int id_loc;
    static String nom_agence;
    static String email;
    static String password;
    @FXML
    private ListView<Locateur> listView;
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

        Locateur u = new Locateur();

        InterfaceLocateurCRUD inter = new LocateurCRUD();
        List<Locateur> list = inter.afficherLocateur();
        for (int i = 0; i < list.size(); i++) {
            Locateur user = list.get(i);
            list2.getItems().add(user);

        }
        list2.setCellFactory(new Callback<ListView<Locateur>, ListCell<Locateur>>() {
            @Override
            public ListCell<Locateur> call(ListView<Locateur> listView) {
                return new ListCell<Locateur>() {
                    protected void updateItem(Locateur user, boolean empty) {
                        super.updateItem(user, empty);
                        if (user != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("-nom_agence:%s - email:%s - password:%s",
                                    user.getNom_agence(),
                                    user.getEmail(),
                                    user.getPassword()
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
        ListView<Locateur> list = listView;
        InterfaceLocateurCRUD inter = new LocateurCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Locateur u = list.getSelectionModel().getSelectedItem();
            System.out.println(u.getId_loc());
            inter.supprimerLocateur(u.getId_loc());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un Locateur à supprimer.");
        }
    }

    @FXML
    private void modifyuser(ActionEvent event) {
        ListView<Locateur> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceLocateurCRUD inter = new LocateurCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        Locateur u = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_loc = u.getId_loc();
        nom_agence = u.getNom_agence();
        email = u.getEmail();
        password = u.getPassword();

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_loc.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
