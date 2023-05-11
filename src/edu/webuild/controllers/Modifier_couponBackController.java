/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.inter.interfacecoupon;
import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
public class Modifier_couponBackController implements Initializable {

    @FXML
    private Button clean;
    @FXML
    private Button generate;
    @FXML
    private DatePicker fxdatem;
    @FXML
    private DatePicker fxdatem2;
    @FXML
    private TextField fxtauxm;
    @FXML
    private TextField fxcodem;
    @FXML
    private TextField fxnbrm;
    @FXML
    private TextField fxtypem;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
  fxdatem.setValue(new java.sql.Date(Market_couponBackController.date_deb.getTime()).toLocalDate());
        fxdatem2.setValue(new java.sql.Date(Market_couponBackController.date_exper.getTime()).toLocalDate());
        fxtauxm.setText(String.valueOf(Market_couponBackController.taux));
        fxcodem.setText(String.valueOf(Market_couponBackController.code));
        fxnbrm.setText(String.valueOf(Market_couponBackController.nbr));
        fxtypem.setText(String.valueOf(Market_couponBackController.type));
        
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

    fxcodem.setText(code.toString());
}   

    @FXML
    private void clean(ActionEvent event) {
    }

    @FXML
    private void genrate(ActionEvent event) {
        generateCouponCode();
    }

    @FXML
    private void update(ActionEvent event) {
               interfacecoupon inter = new couponCrud();

        LocalDate localDate = fxdatem.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date_debut = Date.from(instant);

        LocalDate localDate2 = fxdatem2.getValue();
        Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
        Date date_expe = Date.from(instant2);

        int taux = Integer.parseInt(fxtauxm.getText());
        String code = fxcodem.getText();

        int nbr = Integer.parseInt(fxnbrm.getText());
        String type = fxtypem.getText();
        
        

        coupon v = new coupon(Market_couponBackController.id_coupon,date_debut, date_expe, taux, code, nbr, type);
        inter.modifier(v);
    }

   
    
}
