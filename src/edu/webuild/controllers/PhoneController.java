/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.twilio.Twilio;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import static com.twilio.example.Example.ACCOUNT_SID;
import static com.twilio.example.Example.AUTH_TOKEN;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class PhoneController implements Initializable {

    @FXML
    private TextField btnphone;
    public static final String ACCOUNT_SID = "ACb8ac250d94d237ea91634b8def26f57d";
    public static final String AUTH_TOKEN = "9cfa45bc2a1f868edf3c24319860ef1e";
    private String code;
    @FXML
    private TextField fxcode;
    @FXML
    private Button btnverif;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void sendCode(ActionEvent event) {
        Random rand = new Random();
        code = String.format("%04d", rand.nextInt(10000));
        System.out.println("Code: " + code); // for testing purposes
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+216" + btnphone.getText()), new PhoneNumber("+15673132411"), "Votre code de vérification est: " + code).create();

    }

    private String getMessageBody() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.fetcher("votre SID du message").fetch(); // Remplacez "votre SID du message" par l'identifiant du message Twilio envoyé
        return message.getBody();
    }

    @FXML
    private void verifier(ActionEvent event) {
        String codeEntered = fxcode.getText();

        if (!(codeEntered.equals(code))) {
            System.out.println(codeEntered);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong code");
            alert.setHeaderText(null);
            alert.setContentText("The code that you have entered is incorrect. Try Again.");
            alert.showAndWait();
        } else {
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ResetPassCode.fxml"));

                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

}
