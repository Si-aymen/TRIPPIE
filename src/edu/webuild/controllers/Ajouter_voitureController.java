/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Ajouter_voitureController implements Initializable {

    @FXML
    private TextField fxmatricule;
    @FXML
    private ChoiceBox<String> fx_marque;
    @FXML
    private ChoiceBox<String> fx_puissance;
    @FXML
    private TextField fx_prix_jours;
    @FXML
    private Button ajouter;
    private final String[] fx_marquee = {"BMW", "Mercedes", "Audi", "clio", "porshe", "peugeot", "hamer"};
    private final String[] fx_puissancee = {"5ch", "6ch", "7ch", "8ch", "9ch", "10ch", "11ch", "12ch", "13ch"};
    @FXML
    private ImageView lab_image;
    static String url_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx_marque.getItems().addAll(fx_marquee);
        fx_puissance.getItems().addAll(fx_puissancee);
        String image_voiture = url_image;
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) {
        String matricule = fxmatricule.getText();
        String marque = fx_marque.getValue();
        String puissance = fx_puissance.getValue();
        int prix_jours = Integer.parseInt(fx_prix_jours.getText());
        String cov_img = url_image;
        if (prix_jours < 100) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur le prix est negatif");
            alert.show();
        } else if (matricule.indexOf("tunis") == -1) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur il faut contenir tunis");
            alert.show();
        } else if (marque.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la marque est vide !");
            alert.show();
        } else if (puissance.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la puissance est vide !");
            alert.show();
        } else if (matricule.indexOf("tunis") == -1) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur il faut contenir tunis");
            alert.show();
        } else {
            voiture v = new voiture(matricule, marque, puissance, prix_jours, cov_img);
            voitureCRUD voit = new voitureCRUD();
            voit.ajoutervoiture(v);
            Alert alert = new Alert(AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("voiture insérée avec succés!");
            alert.show();
        }

    }

    @FXML
    private void add_picture(ActionEvent event) {
        ImageView imageView = lab_image;

        // Create a FileChooser
        FileChooser fileChooser = new FileChooser();

        // Add a filter to only show image files
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
        );

        // Get the primary stage from the image view
        Stage primaryStage = (Stage) imageView.getScene().getWindow();

        // Show the file chooser dialog
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            // Load the selected image into the image view
            Image image = new Image(file.toURI().toString());

            //url_image = file.toURI().toString();
            System.out.println(file.toURI().toString());
            imageView.setImage(image);

            // Create a new file in the destination directory
            File destinationFile = new File("C:\\xampp\\htdocs\\image_trippie_cov\\" + file.getName());
            // url_image = "C:\\xampp\\htdocs\\image_trippie_cov\\" + file.getName();
            url_image = file.getName();

            try {
                // Copy the selected file to the destination file
                Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
