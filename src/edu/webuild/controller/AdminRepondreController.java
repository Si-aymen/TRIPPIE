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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class AdminRepondreController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextArea commentaire;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea tf_reponse;
    @FXML
    private ImageView piece_jointe;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String im = "http://localhost/image_trippie_reclamation/" + AdminReclamationController.url_image;

        type.setText(String.valueOf(AdminReclamationController.type_rec));
        commentaire.setText(String.valueOf(AdminReclamationController.commentaire_rec));
        date.setPromptText(AdminReclamationController.date.toString());
        piece_jointe.setImage(new Image(im));
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void repondre(ActionEvent event) throws IOException {

        String rep = tf_reponse.getText();

        if (rep.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Reponse manquante");
            alert.showAndWait();
        } else {

            int id_rec = AdminReclamationController.id;

            String reponse = "(Admin): " + tf_reponse.getText();

            reponse r1 = new reponse(reponse, id_rec, "en cours de traitement");

            reponseCRUD rc = new reponseCRUD();

            rc.ajouterReponse(r1);

            Notifications n = Notifications.create()
                    .title("WeBuild")
                    .text("Réponse ajoutée !")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showInformation();

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/AdminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        }
    }

}
