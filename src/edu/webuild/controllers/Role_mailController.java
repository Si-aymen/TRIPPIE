/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Role_mailController implements Initializable {

    @FXML
    private ChoiceBox<String> fxchoice;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         fxchoice.getItems().addAll("Client", "Chauffeur", "Locateur");
        fxchoice.setValue("Client"); // sélectionne "Option 1" comme valeur par défaut
    }    

    @FXML
    private void choice(ActionEvent event) throws IOException {
        String userType = fxchoice.getValue();
        switch (userType) {
                case "Client":
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/GetPassword.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) btn.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                    break;
                case "Chauffeur":

                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/edu/webuild/gui/GetPassword2.fxml"));
                    Parent root2 = loader2.load();                   
                    Scene scene2 = new Scene(root2);
                    Stage stage2 = (Stage) btn.getScene().getWindow();
                    stage2.setScene(scene2);
                    stage2.show();

                    break;
                case "Locateur":

                    // ouvrir la fenêtre d'accueil pour les locateurs
                    FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/edu/webuild/gui/GetPassword3.fxml"));
                    Parent root3 = loader3.load();
                    Scene scene3 = new Scene(root3);
                    Stage stage3 = (Stage) btn.getScene().getWindow();
                    stage3.setScene(scene3);
                    stage3.show();

                    break;
    }
    
}
    
}
