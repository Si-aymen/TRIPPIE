/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.twilio.Twilio;
import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import edu.webuild.services.voitureCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Ajouter_reservationfrontController implements Initializable {

    @FXML
    private DatePicker date_debut_pk;
    @FXML
    private DatePicker date_fin_pk1;
    @FXML
    private Button ajouter;
    public static final String ACCOUNT_SID = "AC0578c30cc6dca5aaa242984635afc216";
    public static final String AUTH_TOKEN = "95eaaf34d104da9bc14f86f54b8de054";
    private TextField fx_id_reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("ajouter reservation page client id = "+ ProfilClientController.var_client_id);
    }

    @FXML
    private void ajouter_reservation(ActionEvent event) {
        Date date_debut = java.sql.Date.valueOf(date_debut_pk.getValue());
        Date date_fin = java.sql.Date.valueOf(date_fin_pk1.getValue());

        LocalDate currentDate = LocalDate.now(); // Gets the current date
        String dateStringlocal = currentDate.toString();
        String datebuts = date_debut.toString();
        String datefin = date_fin.toString();
        int comparaison2 = datebuts.compareTo(dateStringlocal);
        int comparaison3 = datefin.compareTo(dateStringlocal);
        if (comparaison2 < 0) {
            showAlert("start date is greater than system date");
        }
        if (comparaison3 < 0) {
            showAlert("start date is less than system date");
        }

        String etat = CardvoitureController.vo.getEtat();

        int comparison = date_debut.compareTo(date_fin);

        if (comparison > 0) {
            showAlert("reservation start date is greater than reservation end date");
        } else if (comparison == 0) {
            showAlert("date debut de reservation est egale a date fin  de reservation");
        } else if ("reservé".equals(etat)) {
            showAlert("impossible to make reservation");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to add this reservation ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                reservation res = new reservation(date_debut, date_fin, CardvoitureController.vo, ProfilClientController.var_client_id);
                InterfaceCRUD2 inter = new reservationCRUD();
                inter.ajouterreservation(res);
                InterfaceCRUD inter2 = new voitureCRUD();
                inter2.modifieretat(CardvoitureController.vo);
                appeler();
                showAlert("your reservation has been successfully completed ");
                try {

                    Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/market_voitureclientfront.fxml"));
                    Scene scene = new Scene(page1);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(DetailsvoiturefrontController.class.getName()).log(Level.SEVERE, null, ex);

                }

                String message = "Dear [Client's Name],\n"
                        + "\n"
                        + "I am writing this email to confirm your location reservation for the following details:\n"
                        + "\n"
                        + "date debut reservation : " + date_debut + "\n"
                        + "date fin reservation : " + date_fin + "\n"
                        + "We are pleased to inform you that your reservation has been successfully processed, and we have reserved the required number of seats for you. Your confirmation number is [Enter confirmation number].\n"
                        + "\n";

               // Emailsender.sendEmail_add("khmiriiheb3@gmail.com", message);

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

    public void appeler() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        /* Call call = Call.creator(
                new com.twilio.type.PhoneNumber("+21650201529"),
                new com.twilio.type.PhoneNumber("+12708196867"),
                new com.twilio.twiml.VoiceResponse.Builder()
                        .say(new com.twilio.twiml.Say.Builder("bonjour webuild vous informez que votre reservation a ete effectué avec succes ").build())
                        .build())
                .setUrl("http://demo.twilio.com/docs/voice.xml")
                .create();
         */
    }

}
