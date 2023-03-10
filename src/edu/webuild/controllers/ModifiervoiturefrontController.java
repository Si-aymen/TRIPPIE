/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.Ajouter_voitureController.url_image;
import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class ModifiervoiturefrontController implements Initializable {

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
    @FXML
    private Button ajouter;
    private final String[] fx_marquee = {"BMW", "Mercedes", "Audi", "clio", "porshe", "peugeot", "hamer"};
    private final String[] fx_puissancee = {"5ch", "6ch", "7ch", "8ch", "9ch", "10ch", "11ch", "12ch", "13ch"};
    private final String[] fx_energiee = {"essence", "gazoil", "gpl"};
    @FXML
    private Button picture_add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx_marque.getItems().addAll(fx_marquee);
        fx_puissance.getItems().addAll(fx_puissancee);
        fx_energie.getItems().addAll(fx_energiee);

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
    private void update(ActionEvent event) {
        String matricule = CardvoitureController.vo.getMatricule();
        String marque = fx_marque.getValue();
        String puissance = fx_puissance.getValue();
        String energie = fx_energie.getValue();
        int prix_jours1 = Integer.parseInt(fx_prix_jours.getText());
        int prix_jours = CardvoitureController.vo.getPrix_jours();
        if (prix_jours1 < 50) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("error insert price higher than 50 ");
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
//        } else if (convert1>9999) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("pb matricule");
//            alert.show();
//        }
//            else if (convert2>999) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("pb matricule");
//            alert.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("are you sure to update this car ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

            InterfaceCRUD inter = new voitureCRUD();
            voiture v = new voiture(CardvoitureController.vo.getId(), matricule, marque, puissance, prix_jours1, energie);
            inter.modifiervoiture(v);
             showAlert("car has been successfully updated");

            }
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketvoiturefront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

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

    @FXML
    private void back_btn(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/detailsvoiturefront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
