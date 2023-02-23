/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.inter.interfacecoupon;
import static edu.webuild.interfaces.Table1Controller.code;
import static edu.webuild.interfaces.Table1Controller.taux;
import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierController implements Initializable {

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
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

        fxtauxm.setText(String.valueOf(Table1Controller.taux));
        fxcodem.setText(String.valueOf(Table1Controller.code));
        fxnbrm.setText(String.valueOf(Table1Controller.nbr));
           fxtypem.setText(String.valueOf(Table1Controller.type));
    }    


    @FXML
    private void cleanm(MouseEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
        
   
            int id;
            id = Integer.parseInt(String.valueOf(Table1Controller.id_coupon));
            
              LocalDate localDate = fxdatem.getValue();
    Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    Date date_debut = Date.from(instant);
    
    LocalDate localDate2 = fxdatem2.getValue();
    Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
    Date date_expe = Date.from(instant2);
    
    
            int  tauxm = Integer.parseInt(fxtauxm.getText());
            String code =fxcodem.getText();
            int nbr =Integer.parseInt(fxnbrm.getText());
            String type =fxtypem.getText();
            
            coupon r = new coupon(date_debut, date_expe,tauxm,code,nbr,type);
            
            couponCrud rc = new couponCrud();
            
            rc.modifier(r);
            
            
        
}
    }
  