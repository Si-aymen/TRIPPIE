/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.jfoenix.controls.JFXButton;
import edu.webuild.gui.LoginController;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import java.lang.Integer;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Ajouter_frontController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private ChoiceBox<String> typ_box;
    @FXML
    private TextArea comment;
    @FXML
    private ImageView imageV;
    @FXML
    private Button cov_btu;
    
    File selectedFile;
    public String url_image;
    private String path;
    @FXML
    private JFXButton image;
    
    private String type, commentaire;
    private int id_util;

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
                typ_box.getItems().add(line);
            }
            // Ajouter le nouveau type de réclamation à la liste des options du choix
            typ_box.getItems().add("Autre");

            // ferme le fichier
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        imageV.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });

        // Dropping over surface
        imageV.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    path = null;
                    for (File file : db.getFiles()) {
                        path = file.getName();
                        selectedFile = new File(file.getAbsolutePath());
                        System.out.println("Drag and drop file done and path=" + file.getAbsolutePath());//file.getAbsolutePath()="C:\Users\X\Desktop\ScreenShot.6.png"
                        imageV.setImage(new Image("file:" + file.getAbsolutePath()));
//                        screenshotView.setFitHeight(150);
//                        screenshotView.setFitWidth(250);
                        image.setText(path);
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        imageV.setImage(new Image("file:C:\\Users\\guerf\\Desktop\\TRIPPIE-Reclamation\\src\\edu\\webuild\\images\\drag-drop.gif"));

        typ_box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Autre")) {
                // Demander à l'utilisateur de saisir un nouveau type de réclamation
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Nouveau type de réclamation");
                dialog.setHeaderText(null);
                dialog.setContentText("Entrez un nouveau type de réclamation:");

                Optional<String> result = dialog.showAndWait();
                result.ifPresent(type -> {
                    // Ajouter le nouveau type de réclamation à la liste des options du choix
                    typ_box.getItems().add(type);
                    // Sélectionner le nouveau type de réclamation
                    typ_box.getSelectionModel().select(type);
                });
            }
        });
    }    

    @FXML
    private void bu_add(ActionEvent event) throws IOException {
        
        reclamationCRUD rc = new reclamationCRUD();
        type = typ_box.getValue();
        commentaire = comment.getText();
        LocalDate localDate = LocalDate.now();
        Date date_creation = Date.valueOf(localDate);
        
        

        if (type.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Type manquant");
            alert.showAndWait();
        } else if (commentaire.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Commentaire manquant");
            alert.showAndWait();
        } else {
            
            
            
            if (LoginController.test == 1)
            {
                id_util = ProfilClientController.role.getId_role();
            }
            else if (LoginController.test == 2)
            {
                id_util = ProfilChauffeurController.role.getId_role();
            }
            else if (LoginController.test == 3)
            {
                id_util = ProfilLocateurController.role.getId_role();
            }
            
            reclamation r = new reclamation(type, commentaire, "non traité", date_creation, id_util, url_image);

            rc.ajouterReclamation(r);

            Notifications n = Notifications.create()
                    .title("WeBuild")
                    .text("Réclamation ajoutée !")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showInformation();

            int count = rc.countRec(type);
            System.out.println(count);

            if (count > 2) {
                try {
                    
                    typ_box.getItems().remove("Autre");
                    
                    // ouvre le fichier "choix.txt" en mode écriture
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\manou\\Desktop\\webuild\\src\\edu\\webuild\\controllers\\choix.txt"));

                    // récupère les choix actuels du choixTypeR
                    ObservableList<String> items = typ_box.getItems();

                    // écrit chaque choix sur une nouvelle ligne dans le fichier
                    for (String item : items) {
                        writer.write(item);
                        writer.newLine();
                    }

                    // ferme le fichier
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void image_add(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            // Load the selected image into the image view
            Image image1 = new Image(selectedFile.toURI().toString());

            //url_image = file.toURI().toString();
            System.out.println(selectedFile.toURI().toString());
            imageV.setImage(image1);

            // Create a new file in the destination directory
            File destinationFile = new File("C:\\xampp\\htdocs\\image_trippie_cov" + selectedFile.getName());
            // url_image = "C:\\xampp\\htdocs\\image_trippie_cov\\" + file.getName();
            url_image = selectedFile.getName();

            try {
                // Copy the selected file to the destination file
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }

        }
    }
    
}
