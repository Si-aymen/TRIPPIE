/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import edu.webuild.services.reclamationCRUD;
import edu.webuild.services.reponseCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class AfficheReponseController implements Initializable {

    @FXML
    private ListView<reponse> liste;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView list = liste;
        reponse r = new reponse();
        reponseCRUD rec = new reponseCRUD();
        List<reponse> list1 = rec.filtrer_rep(AdminReclamationController.id);
        for (int i = 0; i < list1.size(); i++) {
            reponse reponse = list1.get(i);
            list.getItems().add(reponse);
        }
    }    

    @FXML
    private void modifier(MouseEvent event) {
        
    }

    @FXML
    private void ajouter(MouseEvent event) {
        
    }

    @FXML
    private void supprimer(MouseEvent event) {
        
    }

    @FXML
    private void retour(MouseEvent event) {
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AdminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            

        }
    }
    
}
