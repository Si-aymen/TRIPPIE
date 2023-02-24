/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
import edu.webuild.services.cadeauCrud;
import edu.webuild.services.couponCrud;
import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterCadeauController implements Initializable {

    @FXML
    private TextField nomc;
    @FXML
    private TextField reccu;
    @FXML
    private ChoiceBox<Integer> idcoupon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx2;
        cnx2= MyConnection.getinstance().getcnx();
        // Récupération des id_coupon depuis la base de données
        ObservableList<Integer> choixIdCoupons = FXCollections.observableArrayList();
        try {
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coupon c LEFT JOIN cadeau ca ON c.id_coupon = ca.id_coupon WHERE c.type = 'vip'; ");
            while (rs.next()) {
                choixIdCoupons.add(rs.getInt("id_coupon"));
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
    private void savecadeau(ActionEvent event) {
         
     /*
        int selectedCouponId = idcoupon.getValue();
    String giftName = nomc.getText();
    int received = Integer.parseInt(reccu.getText());
    //ajouter cadeau 
    cadeau c1 = new cadeau(giftName,received,selectedCouponId);
    cadeauCrud c5 = new cadeauCrud();
   
  c5.ajoutercadeau2(c1);
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Coupon ajouté avec succès");
    alert.setContentText("Le coupon " + selectedCouponId + " a été ajouté à la base de données.");
    alert.showAndWait();*/
      // Vérification de la validité de la saisie pour le champ nomc
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
    //ajouter cadeau 
    cadeau c1 = new cadeau(giftName,received,selectedCouponId);
    cadeauCrud c = new cadeauCrud();
   
    c.ajoutercadeau2(c1);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("Cadeau ajouté avec succès");
    alert.setContentText("Le cadeau '" + giftName + "' a été ajouté à la base de données.");
    alert.showAndWait();
}



    @FXML
    private void cleancadeau(MouseEvent event) {
         
        

nomc.setText(""); 
reccu.setText(""); 

    }

    private int c1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
