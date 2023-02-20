/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutercouponController implements Initializable {

    @FXML
    private AnchorPane txdatec1;
    @FXML
    private DatePicker txdatec;
    @FXML
    private TextField fxtaux;
    @FXML
    private TextField fccode;
    @FXML
    private TextField fxnbr;
    @FXML
    private TextField fxtype;
    @FXML
    private DatePicker datec2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void add(MouseEvent event) {
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

    int taux_reduction;
    try {
        taux_reduction = Integer.parseInt(fxtaux.getText());
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de saisie");
        alert.setContentText("Le taux de réduction doit être un nombre entier");
        alert.showAndWait();
        return;
    }

    if (taux_reduction <= 0 || taux_reduction > 100) {
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

    coupon c = new coupon(java.sql.Date.valueOf(date_debut), java.sql.Date.valueOf(date_expiration), taux_reduction, code_coupon, nbr_utilisation, type);
    couponCrud coupon = new couponCrud();
    coupon.ajouterpersonne2(c);

    // Afficher une alerte de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Coupon ajouté avec succès");
    alert.setContentText("Le coupon " + code_coupon + " a été ajouté à la base de données.");
    alert.showAndWait();
          
    }    

    @FXML
    private void clean(MouseEvent event) {
    }
}
