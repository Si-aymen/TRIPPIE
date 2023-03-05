/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import static edu.webuild.controllers.PhoneController.ACCOUNT_SID;
import static edu.webuild.controllers.PhoneController.AUTH_TOKEN;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ResetPassCodeController implements Initializable {

    @FXML
    private TextField fxcode;
    @FXML
    private PasswordField fxpass1;
    @FXML
    private PasswordField fxpass2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Confirmer(ActionEvent event) {
        String codeEntered = fxcode.getText();
        String codeSent = getMessageBody(); // Récupérez le code envoyé par SMS en utilisant l'API Twilio
       

        if (!(codeEntered.equals(codeSent))) {
            // Autoriser l'utilisateur à accéder à la fonctionnalité protégée de l'application
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Code incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Le code que vous avez entré est incorrect. Veuillez réessayer.");
            alert.showAndWait();

        } else {
            // Afficher un message d'erreur indiquant que le code est incorrect
          
            try {

                Parent page1
                        = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/SendPassword.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ResetPassCodeController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    private String getMessageBody() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.fetcher("votre SID du message").fetch(); // Remplacez "votre SID du message" par l'identifiant du message Twilio envoyé
        return message.getBody();
    }

    private boolean validateInputs() throws SQLException {

        if (fxcode.getText().isEmpty() || fxpass1.getText().isEmpty() || fxpass2.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur");
            alert1.setContentText("Veuillez remplir tous les champs");
            alert1.setHeaderText("Controle de saisie");
            alert1.show();
            return false;
        } else if (!(fxpass1.getText().equals(fxpass2.getText()))) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Erreur");
            alert2.setContentText("Veuillez vérifier votre nouveau mot de passe");
            alert2.setHeaderText(null);
            alert2.show();
            return false;
        }

        return true;

    }

}
