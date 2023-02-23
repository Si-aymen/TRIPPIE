/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.ChauffeurCRUD;
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
public class Affiche_chController implements Initializable {

    @FXML
    private ListView<Chauffeur> listView;
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

        Chauffeur u = new Chauffeur();
        
        InterfaceChauffeurCRUD inter = new ChauffeurCRUD();
        List<Chauffeur> list = inter.afficherChauffeur();
        for (int i = 0; i < list.size(); i++) {
            Chauffeur user = list.get(i);
            list2.getItems().add(user);
            
        }
         list2.setCellFactory(new Callback<ListView<Chauffeur>, ListCell<Chauffeur>>() {
            @Override
            public ListCell<Chauffeur> call(ListView<Chauffeur> listView) {
                return new ListCell<Chauffeur>() {
                    protected void updateItem(Chauffeur user, boolean empty) {
                        super.updateItem(user, empty);
                        if (user != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("Num_permis:%s - Marque_voi:%s - Couleur_voi:%s - Matricule%s - email:%s - password:%s",
                                    user.getNum_permis(),
                                    user.getMarque_voiture(),
                                    user.getCouleur_voiture(),
                                    user.getImmatriculation(),
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
        ListView<Chauffeur> list = listView;
        InterfaceChauffeurCRUD inter = new ChauffeurCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Chauffeur u = list.getSelectionModel().getSelectedItem();
            System.out.println(u.getId_ch());
            inter.supprimerChauffeur(u.getId_ch());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un utilisateur à supprimer.");
        }
    }

    @FXML
    private void modifyuser(ActionEvent event) {
    }
    
}
