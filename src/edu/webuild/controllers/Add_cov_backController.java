/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.Add_CovController.url_image;
import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.Call_Cov;
import edu.webuild.services.CoVoiturageCRUD;
import edu.webuild.services.EmailSender;
import edu.webuild.services.SmS_Cov;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Add_cov_backController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private ChoiceBox<String> depart_box;
    @FXML
    private ChoiceBox<String> destination_box;
    @FXML
    private ChoiceBox<Integer> nmbr_place_box;
    @FXML
    private DatePicker date_pk;
    @FXML
    private ImageView lab_image;

    private final String[] places_dest = {"Ben Arouse", "Ariena", "Tunis", "Manouba", "Jandouba", "Beja", "Bizerte", "Gabes"};
    private final String[] places_dep = {"Ben Arouse", "Ariena", "Tunis", "Manouba", "Jandouba", "Beja", "Bizerte", "Gabes"};
    private final Integer[] nmbr_place_list = {1, 2, 3, 4, 5, 6};
    @FXML
    private TextField email;
    @FXML
    private Button cov_btu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        depart_box.getItems().addAll(places_dep);
        destination_box.getItems().addAll(places_dest);
        nmbr_place_box.getItems().addAll(nmbr_place_list);
    }

    @FXML
    private void bu_add(ActionEvent event) {

        SmS_Cov send = new SmS_Cov();
        //String depart = depart_TF.getText();
        String depart = depart_box.getValue();
        //String destination = destination_TF.getText();
        String destination = destination_box.getValue();
        Date date_dep = java.sql.Date.valueOf(date_pk.getValue());
        //int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        int nmbr_place = nmbr_place_box.getValue();
        String cov_img = url_image;
        //CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place, cov_img);
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        if (nmbr_place > 7 || nmbr_place == 0 || nmbr_place < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();

        } else if (depart.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de depart est vide ");
            alert.show();
        } else if (destination.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de destination est vide ");
            alert.show();
        } else {
            //inter_co.ajouterCoVoiturage(v);
            inter_co.ajouterCoV(v);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("voiture insérée avec succés!");
            alert.show();
            System.out.println(url_image);

        }
        String message = "Dear [Client's Name],\n"
                + "\n"
                + "I am writing this email to confirm your Co_voiturage reservation for the following details:\n"
                + "\n"
                + "Place of departure: " + depart + "\n"
                + "Destination: " + destination + "\n"
                + "Date of departure: " + date_dep + "\n"
                + "Number of available seats: " + nmbr_place + "\n"
                + "We are pleased to inform you that your reservation has been successfully processed, and we have reserved the required number of seats for you. Your confirmation number is [Enter confirmation number].\n"
                + "\n"
                + "Please note that the departure time is " + depart + ". We kindly ask you to arrive at the pickup location 15 minutes before departure time to avoid any delays.\n"
                + "\n"
                + "In case of any changes or cancellations, please let us know at least 24 hours before the departure time. You can contact us through the contact details provided at the end of this email.\n"
                + "\n"
                + "We hope you have a pleasant journey with our Co_voiturage service. Thank you for choosing us for your travel needs.\n"
                + "\n"
                + "Best regards,";

        String emailto = email.getText();
        EmailSender.sendEmail_add(emailto, message);
        EmailSender.sendEmail_add("manouch2001.ra@gmail.com", message);
        //send.send_message("+21692554097", message);

        Call_Cov test_call = new Call_Cov();
        //test_call.cal("+21692554097");

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Show_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void add_image(ActionEvent event) {

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

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

}
