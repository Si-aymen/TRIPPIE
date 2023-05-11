/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.cadeau;
import edu.webuild.services.cadeauCrud;
import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Addcadeau_backController implements Initializable {

    @FXML
    private Button clean;
    @FXML
    private TextField nomc;
    @FXML
    private TextField reccu;
    @FXML
    private ChoiceBox<Integer> idcoupon;
    @FXML
    private TextField des;
    @FXML
    private TextField val;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx2 = MyConnection.getInstance().getConn();
        // Récupération des id_coupon depuis la base de données
        ObservableList<Integer> choixIdCoupons = FXCollections.observableArrayList();
        try {
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coupon c LEFT JOIN cadeau ca ON c.id = ca.coupon_id WHERE c.type = 'vip'; ");
            while (rs.next()) {
                choixIdCoupons.add(rs.getInt("id"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Ajout des id_coupon au ChoiceBox
        idcoupon.setItems(choixIdCoupons);
    }

    @FXML
    private void add(ActionEvent event) {
        if (nomc.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Champ vide");
            alert.setContentText("Veuillez saisir un nom pour le cadeau.");
            alert.showAndWait();
            return;
        }
        // Vérification de la validité de la saisie pour le champ reccu
        if (!reccu.getText().matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Valeur invalide");
            alert.setContentText("Le champ 'reçu' doit être un entier positif");
            alert.showAndWait();
            return;
        }
        int selectedCouponId = idcoupon.getValue();
        String giftName = nomc.getText();
        int received = Integer.parseInt(reccu.getText());
        String dess = des.getText();
        int vall = Integer.parseInt(val.getText());
        //ajouter cadeau 
        cadeau c1 = new cadeau(giftName, received, dess, vall, selectedCouponId);
        cadeauCrud c = new cadeauCrud();

        c.ajoutercadeau2(c1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Cadeau ajouté avec succès");
        alert.setContentText("Le cadeau '" + giftName + "' a été ajouté à la base de données.");
        alert.showAndWait();

    }

    @FXML
    private void clean(ActionEvent event) {
        nomc.setText("");
        reccu.setText("");
        des.setText("");
        val.setText("");

    }

}
