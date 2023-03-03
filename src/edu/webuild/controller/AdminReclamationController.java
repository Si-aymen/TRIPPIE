/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import edu.webuild.utils.Email;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;

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
    static public Date date;
    static public String url_image;

    static public String toEmail = "guerfala71@gmail.com";
    static public String subject = "test";
    static public String body = "test";

    static public String num = "54833493";
    static public String phone = "+216" + num;

    static reclamation selectionedReclamation;
    static Stage stageAffichageUnique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        stageAffichageUnique = new Stage();

        ListView list2 = liste_reclamation;
        reclamation r = new reclamation();
        reclamationCRUD rec = new reclamationCRUD();
        List<reclamation> list = rec.afficherReclamation();
        for (int i = 0; i < list.size(); i++) {
            reclamation reclamation = list.get(i);
            list2.getItems().add(reclamation);
        }

        list2.setOnMouseClicked((MouseEvent event2)
                -> {
            if (event2.getClickCount() >= 2) {
                if (list2.getSelectionModel().getSelectedItem() != null) {
                    reclamation reclam = (reclamation) list2.getSelectionModel().getSelectedItem();

                    id_rec = Integer.toString(reclam.getId_rec());
                    type_rec = reclam.getType_rec();
                    commentaire_rec = reclam.getCommentaire();
                    etat_rec = reclam.getEtat();
                    date = reclam.getDate_creation();
                    url_image = reclam.getUrl_image();

                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/affiche_recUnique.fxml"));
                        Scene scene = new Scene(root);
                        stageAffichageUnique.setScene(scene);
                        stageAffichageUnique.show();

                    } catch (IOException ex) {
                        System.err.println(ex);
                    }

                }
            }
        });

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
        date = r.getDate_creation();
        url_image = r.getUrl_image();

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
        date = r.getDate_creation();
        url_image = r.getUrl_image();

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

        Notifications n = Notifications.create()
                .title("Bienvenue")
                .text("Réclamation traité !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();

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

    @FXML
    private void mail(ActionEvent event) throws MessagingException {

        Email e = new Email("freeelanci@gmail.com", "jjrnaazzdfwhwfar", "guerfala71@gmail.com", "Etat réclamation", " bonjour, Votre réclamation a été traitée");
        e.sendEmail();
    }

    @FXML
    private void sendSMS(ActionEvent event) {
        try {
            TwilioRestClient client = new TwilioRestClient.Builder("ACac8596dd282c3072d3da4dbb09625ab1", "953d46930a342a889d193acfade908ad").build();

            Message message = Message.creator(
                    new PhoneNumber(phone), // To phone number
                    new PhoneNumber("+12766226225"), // From Twilio phone number
                    "Votre réclamation est reçu") // SMS message body
                    .create(client);

            System.out.println("message envoyé");
        } catch (Error ex) {
            System.err.println(ex);
        }
    }

}
