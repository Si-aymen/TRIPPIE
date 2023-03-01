/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.controllers.IdentifierCompteController;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.services.roleCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Ajouter_clientController implements Initializable {

    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private Button fxbtn;
    @FXML
    private TextField fxid;
    @FXML
    private ToggleButton showbtnnewnew;
    @FXML
    private PasswordField fxpass1;
    @FXML
    private ToggleButton showbtnnewnew1;

    
    /**
     *
     * @param id
     */
    public void SetId_role(String id) {
         this.fxid.setText(id);
    }

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showbtnnewnew.setOnAction(event -> {
            if (showbtnnewnew.isSelected()) {
            fxpass.setPromptText(fxpass.getText());
            fxpass.setText("");
        } else {
            fxpass.setText(fxpass.getPromptText());
            fxpass.setPromptText("");
        }
        });
         showbtnnewnew1.setOnAction(event -> {
            if (showbtnnewnew1.isSelected()) {
            fxpass1.setPromptText(fxpass1.getText());
            fxpass1.setText("");
        } else {
            fxpass1.setText(fxpass1.getPromptText());
            fxpass1.setPromptText("");
        }
        });
        
    }

    @FXML
    private void addcli(ActionEvent event) {
        Role r = new Role();
        roleCRUD rc = new roleCRUD();
        r.setId_role(Integer.parseInt(fxid.getText()));
        String email = fxmail.getText();
        String password = fxpass.getText();
       

        // Définir la regex pour valider l'adresse e-mail
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

// Vérifier que la chaîne saisie correspond à la regex
        if (!email.matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir une adresse e-mail valide.");
            alert.showAndWait();
        } else {
            Client cli = new Client(r, email, password);
            rc.affecterRole2(cli, r);
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/affiche_cl.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
}
