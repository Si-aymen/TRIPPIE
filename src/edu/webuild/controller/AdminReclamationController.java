/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class AdminReclamationController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ListView<reclamation> liste_reclamation;
    
    static public int id;
    static public String id_rec;
    static public String type_rec;
    static public String commentaire_rec;
    static public String etat_rec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView list2 = liste_reclamation;
        reclamation r = new reclamation();
        reclamationCRUD rec = new reclamationCRUD();
        List<reclamation> list = rec.afficherReclamation();
        for (int i = 0; i < list.size(); i++) {
            reclamation reclamation = list.get(i);
            list2.getItems().add(reclamation);
        }
    }    


    @FXML
    private void ajouter(MouseEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_recAdmin.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void modifier(MouseEvent event) {
        
        ListView<reclamation> list = liste_reclamation;
        
        reclamationCRUD rec = new reclamationCRUD();
        
        int selectedID = list.getSelectionModel().getSelectedIndex();
        
        reclamation r = list.getSelectionModel().getSelectedItem();
        
        id_rec = Integer.toString(r.getId_rec());
        type_rec = r.getType_rec();
        commentaire_rec = r.getCommentaire();
        etat_rec = r.getEtat();

        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifierAdmin.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            

        }
    }

    @FXML
    private void supprimer(MouseEvent event) {
        
        ListView<reclamation> list_supp = liste_reclamation; 
        reclamationCRUD rec = new reclamationCRUD();
        int selectedID = list_supp.getSelectionModel().getSelectedIndex();
        reclamation r = list_supp.getSelectionModel().getSelectedItem();
        
        rec.supprimerReclamation(r.getId_rec()); 
        list_supp.getItems().remove(selectedID);
    }

    @FXML
    private void repondre(MouseEvent event) throws IOException {
        
        ListView<reclamation> list = liste_reclamation;
        
        reclamationCRUD rec = new reclamationCRUD();
        
        int selectedID = list.getSelectionModel().getSelectedIndex();
        
        reclamation r = list.getSelectionModel().getSelectedItem();
        
        id = r.getId_rec();
        id_rec = Integer.toString(r.getId_rec());
        type_rec = r.getType_rec();
        commentaire_rec = r.getCommentaire();
        etat_rec = r.getEtat();

        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AdminRepondre.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            

        }
    }

    @FXML
    private void traite(MouseEvent event) {
        ListView<reclamation> list = liste_reclamation; 
        reclamationCRUD rec = new reclamationCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        reclamation r = list.getSelectionModel().getSelectedItem();
        
        rec.traite(r);
        list.getItems().clear();
        
        List<reclamation> list2 = rec.afficherReclamation();
        for (int i = 0; i < list2.size(); i++) {
            reclamation reclamation = list2.get(i);
            list.getItems().add(reclamation);
        }
        
    }
    
    @FXML
    private void lancer_afficher(ActionEvent event) throws IOException {
        ListView<reclamation> list = liste_reclamation;
        
        reclamationCRUD rec = new reclamationCRUD();
        
        int selectedID = list.getSelectionModel().getSelectedIndex();
        
        reclamation r = list.getSelectionModel().getSelectedItem();
        
        id = r.getId_rec();
        id_rec = Integer.toString(r.getId_rec());
        type_rec = r.getType_rec();
        commentaire_rec = r.getCommentaire();
        etat_rec = r.getEtat();

        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AfficheReponse.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            

        }
    }
    
}
