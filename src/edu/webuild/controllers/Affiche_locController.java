/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Locateur;
import edu.webuild.services.LocateurCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Affiche_locController implements Initializable {

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
                            setText(String.format("email:%s - password:%s",
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
    }

    @FXML
    private void modifyuser(ActionEvent event) {
    }
    
}
