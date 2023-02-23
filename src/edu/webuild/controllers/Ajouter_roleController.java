/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

//import static edu.webuild.controllers.AfficheController.id_user;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Ajouter_roleController implements Initializable {

    @FXML
    private RadioButton fxclient;
    @FXML
    private Button fxbtn;
    @FXML
    private RadioButton fxch;
    @FXML
    private RadioButton fxloc;

    private String cin;
    @FXML
    private TextField fxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void confirm(ActionEvent event) {
        Utilisateur u = new Utilisateur();
        utilisateurCRUD uc = new utilisateurCRUD();
        int id_user = Integer.parseInt(fxid.getText());

        if (fxclient.isSelected()) {
            String libelle = fxclient.getText();

            u.setId_user(id_user);
            Role r = new Role();
            r.setLibelle("Client");
            uc.affecterClient(r, u);
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_client.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else if (fxch.isSelected()) {
            String libelle = fxch.getText();

            u.setId_user(id_user);
            Role r = new Role();
            r.setLibelle("Chauffeur");
            uc.affecterChauffeur(r, u);
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_chauffeur.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else if(fxloc.isSelected()) {
            String libelle = fxloc.getText();

            u.setId_user(id_user);
            Role r = new Role();
            r.setLibelle("Locateur");
            uc.affecterLocateur(r, u);

            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_locateur.fxml"));
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
