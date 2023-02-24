/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import edu.webuild.model.reponse;
import edu.webuild.services.reponseCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Suivre_recController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField etat;
    @FXML
    private TextField tf_type;
    @FXML
    private TextArea tf_commentaire;
    @FXML
    private ListView<reponse> liste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        etat.setText("Votre réclamation est : " + ReclamationController.etat_rec);
        tf_type.setText(ReclamationController.type_rec);
        tf_commentaire.setText(ReclamationController.commentaire_rec);

        ListView list = liste;
        reponse r = new reponse();
        reponseCRUD rec = new reponseCRUD();
        List<reponse> list1 = rec.getById_rep(ReclamationController.id);
        for (int i = 0; i < list1.size(); i++) {
            reponse reponse = list1.get(i);
            list.getItems().add(reponse);
        }
    }

    @FXML
    private void repondre(ActionEvent event) throws IOException {
        String e = ReclamationController.etat_rec;
        if ("traité".equals(e)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Cette réclamation est déjà traité ! Vous ne pouvez pas répondre à cette réclamation !");
            alert.showAndWait();
        } else {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/repondre.fxml"));
            rootPane.getChildren().setAll(pane);
        }
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
