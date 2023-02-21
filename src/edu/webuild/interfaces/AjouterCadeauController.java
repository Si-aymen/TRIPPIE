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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
         
      couponCrud serviceCoupon = new couponCrud();
        List<coupon> coupons = serviceCoupon.displayCoupon();
        ObservableList<Integer> choixIdCoupons = FXCollections.observableArrayList();
        for (coupon c : coupons) {
            choixIdCoupons.add(c.getId_coupon());
        }
        idcoupon.setItems(choixIdCoupons);
    
    }

    @FXML
    private void savecadeau(ActionEvent event) {
         
     
       
  String nom_cadeau = nomc.getText();
     int recurrence = Integer.parseInt(reccu.getText());
     
     // Récupérer l'ID du coupon sélectionné
     int selectedCouponId = idcoupon.getValue();
     
     // Créer un objet coupon à partir de l'ID récupéré
     coupon c1 = new coupon();
     c1.setId_coupn(selectedCouponId);
     
     // Créer un objet cadeau avec les données saisies
     cadeau c2 = new cadeau(nom_cadeau, recurrence);
     c2.setId_coupon(c1);
     
     // Ajouter le cadeau à la base de données
     cadeauCrud cad = new cadeauCrud();
     cad.ajoutercadeau2(c2);
}


    @FXML
    private void cleancadeau(MouseEvent event) {
    }

    private int c1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
