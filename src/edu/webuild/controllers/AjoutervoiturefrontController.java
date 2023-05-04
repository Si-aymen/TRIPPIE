/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.AjoutervoiturefrontController.url_image;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import edu.webuild.model.Locateur;
import edu.webuild.services.LocateurCRUD;
import edu.webuild.controllers.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class AjoutervoiturefrontController implements Initializable {

    @FXML
    private TextField fxmatricule;
    @FXML
    private ChoiceBox<String> fx_marque;
    @FXML
    private ChoiceBox<String> fx_puissance;
    @FXML
    private ImageView lab_image;
    @FXML
    private ChoiceBox<String> fx_energie;
    @FXML
    private TextField fx_prix_jours;
    static String url_image;

    @FXML
    private Button ajouter;
    private final String[] fx_marquee = {"BMW", "Mercedes", "Audi", "clio", "porshe", "peugeot", "hamer"};
    private final String[] fx_puissancee = {"5ch", "6ch", "7ch", "8ch", "9ch", "10ch", "11ch", "12ch", "13ch"};
    private final String[] fx_energiee = {"essence", "gazoil", "gpl"};
    private TextField id_client;
    @FXML
    private TextField fx_id_client;

    private static Locateur locateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx_marque.getItems().addAll(fx_marquee);
        fx_puissance.getItems().addAll(fx_puissancee);
        fx_energie.getItems().addAll(fx_energiee);
        String image_voiture = url_image;
        // TODO
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
            // Load the  selected image into the image view
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

    @FXML
    private void ajouter(ActionEvent event) {
        String matricule = fxmatricule.getText();
        String marque = fx_marque.getValue();
        String puissance = fx_puissance.getValue();
        String energie = fx_energie.getValue();
        int prix_jours = Integer.parseInt(fx_prix_jours.getText());
        locateur = ProfilLocateurController.L ; 

        String etat = "non reservé";
        String cov_img = url_image;

        int position1 = matricule.indexOf("tunis");
        //    String partie1 = matricule.substring(0, position1);
//      String partie2 = matricule.substring(position1 + 5, matricule.length() - position1 + 4);
        //   int convert1 = Integer.parseInt(partie1);
        //  int convert2 = Integer.parseInt(partie2);

        if (prix_jours < 100) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur le prix est negatif");
            alert.show();
        } else if (matricule.indexOf("tunis") == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur il faut contenir tunis");
            alert.show();
        } else if (marque.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la marque est vide !");
            alert.show();
        } else if (puissance.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la puissance est vide !");
            alert.show();
        } else if (matricule.indexOf("tunis") == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur il faut contenir tunis");
            alert.show();
//       

        } else {
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("are you sure to add this car ?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    voiture v = new voiture(matricule, marque, puissance, prix_jours, cov_img, energie, locateur.getId_loc());
                    voitureCRUD voit = new voitureCRUD();
                    voit.ajoutervoiture(v);
                    showAlert("car added successfully");
                }
                try {

                    Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketvoiturefront.fxml"));
                    Scene scene = new Scene(page1);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
