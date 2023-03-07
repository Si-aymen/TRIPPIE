/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class CardcouponController implements Initializable {

   
    @FXML
    private Label fx_dated;
    @FXML
    private Label fx_datef;
    @FXML
    private Label fx_taux;
    @FXML
    private Label fxcode;
    @FXML
    private Label fxnbr;
    @FXML
    private Label fxtype;

    /**
     * Initializes the controller class.
     */
      public void setData(int id_coupon,Date date_debut,Date date_experation, int taux_reduction, String code_coupon, int nbr_utilisation,String type) {
          fx_dated.setText(date_debut.toString());
          fx_datef.setText(date_experation.toString());
          fx_taux.setText(Integer.toString(taux_reduction));
   
    fxcode.setText(code_coupon);
    fxnbr.setText(Integer.toString(nbr_utilisation));
    fxtype.setText(type);
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
