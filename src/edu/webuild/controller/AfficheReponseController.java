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

    public static int id_rep;
    public static int id_rec;
    public static String rep;
    public static String type;
    public static String commentaire;
    public static String etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView list = liste;
        reponse r = new reponse();
        reponseCRUD rec = new reponseCRUD();
        List<reponse> list1 = rec.getById_rep(AdminReclamationController.id);
        for (int i = 0; i < list1.size(); i++) {
            reponse reponse = list1.get(i);
            list.getItems().add(reponse);
        }
    }

    @FXML
    private void modifier(MouseEvent event) {
        ListView<reponse> list = liste;

        reponseCRUD rec = new reponseCRUD();
        reclamationCRUD rc = new reclamationCRUD();

        int selectedID = list.getSelectionModel().getSelectedIndex();

        reponse r = list.getSelectionModel().getSelectedItem();

        id_rep = r.getId_rep();
        id_rec = r.getId_rec();
        rep = r.getReponse();

        reclamation reclam = rc.getById_rec(id_rec);

        type = reclam.getType_rec();
        commentaire = reclam.getCommentaire();
        etat = reclam.getEtat();

        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_reponse.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {

        }
    }

    @FXML
    private void ajouter(MouseEvent event) {

        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_reponse.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {

        }

    }

    @FXML
    private void supprimer(MouseEvent event) {
        ListView<reponse> list_supp = liste;
        reponseCRUD rec = new reponseCRUD();
        int selectedID = list_supp.getSelectionModel().getSelectedIndex();
        reponse r = list_supp.getSelectionModel().getSelectedItem();

        rec.supprimerReponse(r.getId_rec());
        list_supp.getItems().remove(selectedID);
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
