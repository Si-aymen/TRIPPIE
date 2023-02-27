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

    private int id_role;
    private Utilisateur user;
    @FXML
    private TextField fxidu;
    @FXML
    private TextField test;

    /**
     *
     * @param id
     */
    public void setFxidu(String id) {
        this.fxidu.setText(id);
    }

    /**
     *
     * @param u
     */
    /*public void setUser(Utilisateur u) {
        user = u;
        System.out.println(user);
        System.out.println(user.getId_user() + "");
        test.setText(user.getId_user() + "");
        System.out.println(user.getId_user() + "");
        fxidu.setText(user.getId_user() + "");
        System.out.println(user.getId_user() + "");

    }*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void confirm(ActionEvent event) {
        Utilisateur u = new Utilisateur();
        utilisateurCRUD uc = new utilisateurCRUD();
//        int ID = Integer.parseInt(fxid.getText());
        roleCRUD rc = new roleCRUD();
        if (fxclient.isSelected()) {
            String libelle = fxclient.getText();
            u.setId_user(Integer.parseInt(fxidu.getText()));
            Role r = new Role();

            r.setLibelle("Client");
            uc.affecterClient(r, u);
            String id = rc.getById_user(Integer.parseInt(fxidu.getText())).getId_role() + "";
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ajouter_client.fxml"));
                Parent rooot = loader.load();
                Ajouter_clientController dc = loader.getController();
                fxclient.getScene().setRoot(rooot);
                dc.SetId_role(id);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (fxch.isSelected()) {
            String libelle = fxch.getText();

            u.setId_user(Integer.parseInt(fxidu.getText()));
            Role r = new Role();
            r.setLibelle("Chauffeur");
            uc.affecterChauffeur(r, u);
            String id = rc.getById_user(Integer.parseInt(fxidu.getText())).getId_role() + "";
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ajouter_chauffeur.fxml"));
                Parent rooot = loader.load();
                Ajouter_chauffeurController dc = loader.getController();
                fxclient.getScene().setRoot(rooot);
                dc.SetId_role(id);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (fxloc.isSelected()) {
            String libelle = fxloc.getText();

            u.setId_user(Integer.parseInt(fxidu.getText()));
            Role r = new Role();
            r.setLibelle("Locateur");
            uc.affecterLocateur(r, u);

             String id = rc.getById_user(Integer.parseInt(fxidu.getText())).getId_role() + "";
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ajouter_locateur.fxml"));
                Parent rooot = loader.load();
                Ajouter_locateurController dc = loader.getController();
                fxclient.getScene().setRoot(rooot);
                dc.SetId_role(id);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
