/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.services.reservationCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import java.net.URI;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class AjouterreservationController implements Initializable {
    

    @FXML
    private Button ajouter_reservation;
    @FXML
    private DatePicker date_debut_pk;
    @FXML
    private DatePicker date_fin_pk1;
        public static final String ACCOUNT_SID ="ACb4efd56d6c3d29ef384aca75f3d2237d";
    public static final String AUTH_TOKEN = "f82e10f9854258e174ee5029059a4d74" ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_reservation(ActionEvent event) {
         Date date_debut = java.sql.Date.valueOf(date_debut_pk.getValue());
        Date date_fin = java.sql.Date.valueOf(date_fin_pk1.getValue());
        reservation res = new reservation(date_debut, date_fin, Afficher_voitureController.voiture);
        InterfaceCRUD2 inter = new reservationCRUD();
        inter.ajouterreservation(res);
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("voiture insérée avec succés!");
        alert.show();
         System.out.println(ACCOUNT_SID);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Call call = Call.creator(
         new com.twilio.type.PhoneNumber("+21625104011"), new com.twilio.type.PhoneNumber("+12766183954"), URI.create("http://demo.twilio.com/docs/voice.xml")).create();
        System.out.println(call.getSid());

    }
    }



 

  


    

