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
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Modifer_Front_covController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private ImageView imageView;
    @FXML
    private Label depart_co_lab1;
    @FXML
    private Label depart_co_lab11;
    @FXML
    private Label temp_lab;
    @FXML
    private Label weather_lab;
    @FXML
    private Button cov_btu;
    @FXML
    private ChoiceBox<String> Depart_box;
    @FXML
    private ChoiceBox<String> dest_box;
    @FXML
    private ChoiceBox<Integer> nmbr_place_box;
    @FXML
    private DatePicker Date_PK;

    private final String[] places_dest = {"Ben Arouse", "Ariena", "Tunis", "Manouba", "Jandouba", "Beja", "Bizerte", "Gabes"};
    private final String[] places_dep = {"Ben Arouse", "Ariena", "Tunis", "Manouba", "Jandouba", "Beja", "Bizerte", "Gabes"};
    private final Integer[] nmbr_place_list = {1, 2, 3, 4, 5, 6};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Depart_box.getItems().addAll(places_dep);
        dest_box.getItems().addAll(places_dest);
        nmbr_place_box.getItems().addAll(nmbr_place_list);

    }

    @FXML
    private void Modify_btu(ActionEvent event) {
        SmS_Cov send = new SmS_Cov();
        //String depart = depart_TF.getText();
        String depart = Depart_box.getValue();
        //String destination = destination_TF.getText();
        String destination = dest_box.getValue();
        Date date_dep = java.sql.Date.valueOf(Date_PK.getValue());
        //int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        int nmbr_place = nmbr_place_box.getValue();
        String cov_img = url_image;
        //CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        //CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place, cov_img);
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
            //inter_co.ajouterCoV(v);
            CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place);
            inter_co.modifierCoVoiturage(v, Item_covController.covt.getId_co());
            System.out.println(Item_covController.covt.getId_co());
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

        // String emailto = email.getText();
        //EmailSender.sendEmail_add(emailto, message);
        //send.send_message("+21692554097", message);
        Call_Cov test_call = new Call_Cov();
        //test_call.cal("+21692554097");

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Front/Market_cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void delete_btu(ActionEvent event) {
    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

}
