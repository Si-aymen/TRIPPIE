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
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.LocateurCRUD;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ResetPassCodeController implements Initializable {

    private TextField fxcode;
    @FXML
    private PasswordField fxpass1;
    @FXML
    private PasswordField fxpass2;
    @FXML
    private TextField fxnum;
    @FXML
    private ChoiceBox<String> fxchoixe;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fxchoixe.getItems().addAll("Client", "Chauffeur", "Locateur");
        fxchoixe.setValue("Client"); // sélectionne "Option 1" comme valeur par défaut
    }

    @FXML
    private void Confirmer(ActionEvent event) throws SQLException {
        String userType = fxchoixe.getValue();
        int gsm = Integer.parseInt(fxnum.getText());
        String pass = fxpass1.getText();
        if (validateInputs()) {
            switch (userType) {
                case "Client":
                    ClientCRUD cc = new ClientCRUD();
                    // Récupérez le code envoyé par SMS en utilisant l'API Twilio
                    cc.changePassword2(pass, gsm);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Updated");
                    alert.setContentText("Password successfully changed");
                    alert.showAndWait();
                    try {
                        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
                        Scene scene = new Scene(page1);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ResetPassCodeController.class.getName()).log(Level.SEVERE, null, ex);

                    }
                    break;
                case "Chauffeur":
                    ChauffeurCRUD ch = new ChauffeurCRUD();
                    // Récupérez le code envoyé par SMS en utilisant l'API Twilio
                    ch.changePassword2(pass, gsm);
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("Success");
                    alert2.setHeaderText("Updated");
                    alert2.setContentText("Password successfully changed");
                    alert2.showAndWait();
                    try {

                        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));

                        Scene scene = new Scene(page1);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ResetPassCodeController.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    break;
                case "Locateur":
                    LocateurCRUD loc = new LocateurCRUD();
                    // Récupérez le code envoyé par SMS en utilisant l'API Twilio
                    loc.changePassword2(pass, gsm);
                    Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert3.setTitle("Success");
                    alert3.setHeaderText("Updated");
                    alert3.setContentText("Password successfully changed");
                    alert3.showAndWait();
                    try {

                        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));

                        Scene scene = new Scene(page1);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ResetPassCodeController.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    break;

            }
        }

    }

   

    private boolean validateInputs() throws SQLException {

        if (fxpass1.getText().isEmpty() || fxpass2.getText().isEmpty() || fxnum.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Error");
            alert1.setContentText("Please complete all fields");
            alert1.setHeaderText("Input control");
            alert1.show();
            return false;

        }
        else if (!fxpass1.getText().equals(fxpass2.getText())){
             Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Error");
            alert1.setContentText("Please verify your password");
            alert1.setHeaderText("Input control");
            alert1.show();
            return false;

        }
        return true;

    }
}
