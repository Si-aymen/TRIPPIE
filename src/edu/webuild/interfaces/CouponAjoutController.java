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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CouponAjoutController implements Initializable {

    @FXML
    private TextField txtaux;
    @FXML
    private TextField txcode;
    @FXML
    private TextField txnbr;
    @FXML
    private TextField txtype;
    @FXML
    private TextField txid;
    @FXML
    private DatePicker txdate1;
    @FXML
    private DatePicker txdate2;
    @FXML
    private Button txenvoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
       
         LocalDate date_debut = txdate1.getValue();
         LocalDate date_expiration = txdate2.getValue();
         
        int taux_reducton = Integer.parseInt(txtaux.getText());
        String code_coupon = txcode.getText();
         int nbr_utilisation = Integer.parseInt(txnbr.getText());
         String type = txtype.getText();
         
         coupon c = new coupon( java.sql.Date.valueOf(date_debut),java.sql.Date.valueOf(date_expiration),taux_reducton,code_coupon,nbr_utilisation,type);
          couponCrud coupon = new couponCrud();
          coupon.ajouterpersonne2(c);
          
    }
    
}
