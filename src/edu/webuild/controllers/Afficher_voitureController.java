/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Afficher_voitureController implements Initializable {

    @FXML
    private ListView<voiture> affichervoiture;
    @FXML
    private Button supprimer;
    @FXML
    private Button mod;
    @FXML
    private Button reservervoiture;

    static int id;
    static String matricule;
    static String marque;
    static String Puissence;
    static String Prix_jour;
    static voiture voiture;
    static public String url_img;
    
    @FXML
    private Button details;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView<voiture> list1 = (ListView<voiture>) affichervoiture;
        InterfaceCRUD inter = new voitureCRUD();
        List<voiture> list2 = inter.affichervoitures();
        for (int i = 0; i < list2.size(); i++) {
            voiture v = list2.get(i);
            list1.getItems().add(v);

        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void supprimer_voiture(ActionEvent event) {
        ListView<voiture> list = affichervoiture;
        InterfaceCRUD inter = new voitureCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            voiture v = list.getSelectionModel().getSelectedItem();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet voiture ?");
            Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){
            inter.supprimervoiture(v.getId());
            list.getItems().remove(selectedIndex);
             showAlert("voiture supprimé");}
        } else {
            System.out.println("Veuillez sélectionner une voiture à supprimer.");
        }
    }

    @FXML
    private void mod(ActionEvent event) {
        ListView<voiture> list = affichervoiture;
        InterfaceCRUD inter = new voitureCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        voiture v = list.getSelectionModel().getSelectedItem();
        id = v.getId();
        matricule = v.getMatricule();
        marque = v.getMarque();
        Puissence = v.getPuissance();
        Prix_jour = Integer.toString(v.getPrix_jours());
      
        

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifiervoiture.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void reservervoiture(ActionEvent event) {
        ListView<voiture> list = affichervoiture;
        InterfaceCRUD inter = new voitureCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        voiture v = list.getSelectionModel().getSelectedItem();
        voiture = v;

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouterreservation.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void details(ActionEvent event) {
         ListView<voiture> list = affichervoiture;
        InterfaceCRUD inter = new voitureCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        voiture v = list.getSelectionModel().getSelectedItem();
        id = v.getId();
        matricule = v.getMatricule();
        marque = v.getMarque();
        Puissence = v.getPuissance();
        Prix_jour = Integer.toString(v.getPrix_jours());
        url_img= v.getImage_voiture();
       
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/details.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
         
}

    @FXML
    private void back(ActionEvent event) {
         try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/crud_voiture.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
