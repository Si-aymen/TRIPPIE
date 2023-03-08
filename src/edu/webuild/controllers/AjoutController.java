/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import edu.webuild.utils.MyConnection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField fxcin;
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxprenom;
   

    @FXML
    private Button btnajout;
    public static int id_user;
    private ImageView fximg;
   
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
    private void adduser(ActionEvent event) throws IOException {

        //ajout de L'utilisateur    
        String nom = fxnom.getText();
        String prenom = fxprenom.getText();
        String cin = fxcin.getText();
       
      

        if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty()) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Please complete all fields.");
            alert.show();

        } else if (cin.length() != 8) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error cin must be 8 numbers");
            alert.show();
        } else if (Character.isLowerCase(nom.charAt(0))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error firstname must start with uppercase");
            alert.show();

        } else if (Character.isLowerCase(prenom.charAt(0))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error lastname must start with uppercase");
            alert.show();

        } //        else if (sexe !="Homme" || sexe !="Femme" || sexe !="H" || sexe !="F"){
        //            
        //            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //           alert.setTitle("Information Dialog");
        //        alert.setHeaderText(null);
        //        alert.setContentText("il faut que saisir H=Homme ou bien F=Femme ");
        //        alert.show();
        //        }
        else {

            Utilisateur u = new Utilisateur(cin, nom, prenom);
            utilisateurCRUD uc = new utilisateurCRUD();
            uc.ajouterUtilisateur(u);
            //role

            String id = uc.getByCin(cin).getId_user() + "";

//                rc.setFxid(id_user+"");
            System.out.println(id);
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ajouter_role.fxml"));
                Parent rooot = loader.load();
                Ajouter_roleController dc = loader.getController();
                fxcin.getScene().setRoot(rooot);
                dc.setFxidu(id);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


}
