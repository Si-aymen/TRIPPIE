/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.inter.interfacecadeau;
import edu.webuild.inter.interfacecoupon;
import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
import edu.webuild.services.cadeauCrud;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifiercadeauController implements Initializable {

    @FXML
    private Button update;
    @FXML
    private TextField nomcadM;
    @FXML
    private TextField reccuuM;
    @FXML
    private TextField dessm;
    @FXML
    private TextField valm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomcadM.setText(String.valueOf(Table2Controller.nom_cadeau));
        reccuuM.setText(String.valueOf(Table2Controller.reccurence));
        dessm.setText(String.valueOf(Table2Controller.dess));
        valm.setText(String.valueOf(Table2Controller.vall));
    }
 

    @FXML
    private void updateC(ActionEvent event) {
       interfacecadeau inter = new cadeauCrud();

        String nom = nomcadM.getText();
        int recc = Integer.parseInt(reccuuM.getText());
        String dess = dessm.getText();
        int valeur = Integer.parseInt(valm.getText());


        cadeau v = new cadeau(Table2Controller.id_cadeau,nom, recc, dess,valeur);
        inter.modifier(v);
           
         
    }

    @FXML
    private void cleanm(MouseEvent event) {
    }

    @FXML
    private void cleanC(ActionEvent event) {
    }
    
}
