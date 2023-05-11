/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class ADD_couponBackController implements Initializable {

    @FXML
    private DatePicker txdatec;
    @FXML
    private DatePicker datec2;
    @FXML
    private TextField fxtaux;
    @FXML
    private TextField fccode;
    @FXML
    private TextField fxnbr;
    @FXML
    private TextField fxtype;
    @FXML
    private Button clean;
    @FXML
    private Button generate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txdatec.setValue(LocalDate.now());
        txdatec.setDisable(true);
    }    



    @FXML
    private void add(ActionEvent event) {
        // localdate classe du package java.time qui permet de représenter une date
        LocalDate date_debut = txdatec.getValue();
    LocalDate date_expiration = datec2.getValue();

    if (date_debut == null || date_expiration == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Veuillez saisir une date de début et une date d'expiration valides");
        alert.showAndWait();
        return;
    }

    if (date_debut.isAfter(date_expiration)) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("La date de début doit être avant la date d'expiration");
        alert.showAndWait();
        return;
    }

    int taux;
    try {
        taux = Integer.parseInt(fxtaux.getText());
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Le taux de réduction doit être un nombre entier");
        alert.showAndWait();
        return;
    }

    if (taux <= 0 || taux > 100) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Le taux de réduction doit être compris entre 1 et 100");
        alert.showAndWait();
        return;
    }

    String code_coupon = fccode.getText().trim();
    if (code_coupon.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Veuillez saisir un code de coupon valide");
        alert.showAndWait();
        return;
    }

    int nbr_utilisation;
    try {
        nbr_utilisation = Integer.parseInt(fxnbr.getText());
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Le nombre d'utilisation doit être un nombre entier");
        alert.showAndWait();
        return;
    }

    if (nbr_utilisation < 0) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Le nombre d'utilisation doit être positif");
        alert.showAndWait();
        return;
    }

    String type = fxtype.getText().trim();
    if (type.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Veuillez saisir un type de coupon valide");
        alert.showAndWait();
        return;
    }
    //java.sql.Date.valueOf() est utilisée pou
//qui est utilisé pour stocker des dates dans une base de données relationnelle.


    coupon c = new coupon(java.sql.Date.valueOf(date_debut), java.sql.Date.valueOf(date_expiration), taux, code_coupon, nbr_utilisation, type);
    couponCrud coupon = new couponCrud();
    coupon.ajouterpersonne2(c);
    
  
        
// réinitialiser les champs
        txdatec.setValue(null);
        fxtaux.setText("");
        fccode.setText("");
        fxnbr.setText("");
        fxtype.setText("");
        datec2.setValue(null);
        
       

    // Afficher une alerte de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Coupon ajouté avec succès");
    alert.setContentText("Le coupon " + code_coupon + " a été ajouté à la base de données.");
    alert.showAndWait();
    }

    @FXML
    private void clean(ActionEvent event) {
                   // réinitialiser la valeur de Date
        txdatec.setValue(null); 
 // vider le champ de texte taux
fxtaux.setText(""); 
fccode.setText(""); 
fxnbr.setText(""); 
fxtype.setText(""); 
datec2.setValue(null); 
    }
 @FXML
private void generateCouponCode() {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int codeLength = 5;
    StringBuilder code = new StringBuilder();

    for (int i = 0; i < codeLength; i++) {
        int index = (int) (Math.random() * alphabet.length());
        code.append(alphabet.charAt(index));
    }

    fccode.setText(code.toString());
}
    @FXML
    private void genrate(ActionEvent event) {
         generateCouponCode() ; 
    }

    
}
