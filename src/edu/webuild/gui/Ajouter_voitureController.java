/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Ajouter_voitureController implements Initializable {

    @FXML
    private TextField fxmatricule;
    @FXML
    private TextField fx_marque;
    @FXML
    private TextField fx_puissance;
    @FXML
    private TextField fx_prix_jours;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) {
        String matricule = fxmatricule.getText();
        String marque = fx_marque.getText();
        String puissance = fx_puissance.getText();
        int prix_jours = Integer.parseInt(fx_prix_jours.getText());
         if(prix_jours<0){
             Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur le prix est negatif");
        alert.show();
        }else if(marque.length()==0){
            Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur donner une marque");
        alert.show();
        }else if (matricule.indexOf("tunis")==-1){
             Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur il faut contenir tunis");
        alert.show();
        }else if (puissance.indexOf("ch")==-1){
             Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("erreur il faut contenir ch");
        alert.show();
        }else if (marque.length()<0){
             Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("la marque est vide !");
        alert.show();
        }else if (puissance.length()<0){
             Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("la puissance est vide !");
        alert.show();
        }
         else {
        voiture v = new voiture(matricule, marque, puissance, prix_jours);
        voitureCRUD voit = new voitureCRUD();
        voit.ajoutervoiture(v);
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("voiture insérée avec succés!");
        alert.show();
    }
    }

}
