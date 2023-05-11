/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class Modifer_backController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private ChoiceBox<String> type_box;
    @FXML
    private TextField comm;
    @FXML
    private ChoiceBox<String> etat_box;
    @FXML
    private Label date_cr;
    @FXML
    private ImageView imageView;

    private final String[] etats = {"non traité", "en cours de traitement", "traité"};
    
    private static int id_utilisateur = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // ouvre le fichier "choix.txt" en mode lecture
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\manou\\Desktop\\webuild\\src\\edu\\webuild\\controllers\\choix.txt"));

            // lit chaque ligne du fichier et ajoute les choix au choixTypeR
            String line;
            while ((line = reader.readLine()) != null) {
                type_box.getItems().add(line);
            }
            // Ajouter le nouveau type de réclamation à la liste des options du choix
            type_box.getItems().add("Autre");

            // ferme le fichier
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        String imagePath = "C:\\xampp\\htdocs\\image_trippie_reclamation\\" + Item_backController.r.getUrl_image();
        try {
            imageView.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }

        etat_box.getItems().addAll(etats);

        comm.setText(Item_backController.r.getCommentaire());
        type_box.setValue(Item_backController.r.getType_rec());
        etat_box.setValue(Item_backController.r.getEtat());
        date_cr.setText(Item_backController.r.getDate_creation().toString());

    }

    @FXML
    private void Modify_btu(ActionEvent event) {
        try {
            int id;
            id = Item_backController.r.getId_rec();
            String type = type_box.getValue();
            String commentaire = comm.getText();
            String etat = etat_box.getValue();

            reclamation r = new reclamation(type, commentaire, etat, Item_backController.r.getDate_creation(), id_utilisateur, Item_backController.r.getUrl_image());

            reclamationCRUD rc = new reclamationCRUD();

            rc.modifierReclamation(r, id);

            Notifications n = Notifications.create()
                    .title("WeBuild")
                    .text("Réclamation modifiée avec succé !")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showInformation();
        
            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void delete_btu(ActionEvent event) {
        }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }


}
