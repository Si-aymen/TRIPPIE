/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.Affiche_chController.couleur_voiture;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Modifier_cliController implements Initializable {

    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private Button btnmod;

    public void setFxmail(String email) {
        this.fxmail.setText(email);
        System.out.println(email);
    }

    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        
//        fxmail.setText(String.valueOf(Affiche_clController.email));
//        fxpass.setText(String.valueOf(Affiche_clController.password));
    }    

    @FXML
    private void modifier_user(ActionEvent event) {
//          InterfaceClientCRUD inter = new ClientCRUD();
//        String email = fxmail.getText();
//        String password = fxpass.getText();
//         // Définir la regex pour valider l'adresse e-mail
//        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
//
//// Vérifier que la chaîne saisie correspond à la regex
//        if (!email.matches(regex)) {
//            // Afficher un message d'erreur si la saisie est invalide
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erreur de saisie");
//            alert.setHeaderText(null);
//            alert.setContentText("Veuillez saisir une adresse e-mail valide.");
//            alert.showAndWait();
//        } else {
//        Client cli=new Client(Affiche_clController.id_client, email, password);
//        inter.modifierClient(cli);
//         
//try {
//
//            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/affiche_cl.fxml"));
//            Scene scene = new Scene(page1);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//   }
    } 
}
