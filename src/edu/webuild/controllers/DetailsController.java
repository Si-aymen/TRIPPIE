/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.reponse;
import edu.webuild.services.reclamationCRUD;
import edu.webuild.services.reponseCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class DetailsController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private Label typ;
    @FXML
    private Label comm;
    @FXML
    private Label eta;
    @FXML
    private ImageView imageView;
    @FXML
    private Label date_cr;
    @FXML
    private ListView<reponse> liste_rep;
    private ListView list = liste_rep;
    private reponseCRUD rec = new reponseCRUD();
    private List<reponse> list1 = rec.getById_rep(Item_recController.r.getId_rec());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_reclamation\\" + Item_recController.r.getUrl_image();
        System.out.println(imagePath);
        //id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        typ.setText(String.valueOf(Item_recController.r.getType_rec()));
        comm.setText(String.valueOf(Item_recController.r.getCommentaire()));
        date_cr.setText(Item_recController.r.getDate_creation().toString());
        eta.setText(String.valueOf(Item_recController.r.getEtat()));
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }

        list = liste_rep;

        for (int i = 0; i < list1.size(); i++) {
            reponse reponse = list1.get(i);
            list.getItems().add(reponse);
        }
    }


    @FXML
    private void delete_btu(ActionEvent event) {
        try {
            reclamationCRUD rec = new reclamationCRUD();

            rec.supprimerReclamation(Item_recController.r.getId_rec());

            Notifications n = Notifications.create()
                    .title("WeBuild")
                    .text("Réclamation supprimé avec succé !")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showInformation();

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    @FXML
    private void repondre(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nouveau type de réclamation");
        dialog.setHeaderText(null);
        dialog.setContentText("Entrez un nouveau type de réclamation:");

        Optional<String> result = dialog.showAndWait();

        String reponse = "(Utilisateur): " + result.get();

        reponse r1 = new reponse(reponse, Item_recController.r.getId_rec(), "en cours de traitement");

        reponseCRUD rc = new reponseCRUD();

        rc.ajouterReponse(r1);

        Notifications n = Notifications.create()
                .title("WeBuild")
                .text("Réponse ajoutée avec succé !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();

        list.getItems().add(r1);

        list.refresh();
        liste_rep.refresh();

    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

}
