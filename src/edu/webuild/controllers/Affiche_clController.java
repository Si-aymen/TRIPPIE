/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
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
public class Affiche_clController implements Initializable {

    static int id_client;
    static String email;
    static String password;
    @FXML
    private ListView<Client> listView;
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

        Client u = new Client();
        
        InterfaceClientCRUD inter = new ClientCRUD();
        List<Client> list = inter.afficherClient2();
        for (int i = 0; i < list.size(); i++) {
            Client user = list.get(i);
            list2.getItems().add(user);
        }
         list2.setCellFactory(new Callback<ListView<Client>, ListCell<Client>>() {
            @Override
            public ListCell<Client> call(ListView<Client> listView) {
                return new ListCell<Client>() {
                    protected void updateItem(Client user, boolean empty) {
                        super.updateItem(user, empty);
                        if (user != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("cin:%s - nom:%s - prenom:%s - email:%s",
                                   user.getId_role().getId_user().getCin(),
                                   user.getId_role().getId_user().getNom(),
                                   user.getId_role().getId_user().getPrenom(),
                                    user.getEmail()
                                
                                    
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
          ListView<Client> list = listView;
        InterfaceClientCRUD inter = new ClientCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Client u = list.getSelectionModel().getSelectedItem();
            System.out.println(u.getId_client());
            inter.supprimerClient(u.getId_client());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un client à supprimer.");
        }
    }

    @FXML
    private void modifyuser(ActionEvent event) {
         ListView<Client> list = listView;
        InterfaceClientCRUD inter = new ClientCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        Client u = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_client=u.getId_client();
        email = u.getEmail();
        password=u.getPassword();

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_cli.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
}
