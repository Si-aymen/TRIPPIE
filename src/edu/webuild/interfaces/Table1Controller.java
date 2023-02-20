/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Table1Controller implements Initializable {

    @FXML
    private TableView<coupon> table;
    @FXML
    private TableColumn<coupon, Integer> txid;
    @FXML
    private TableColumn<coupon, Date> txnom;
    @FXML
    private TableColumn<coupon, Date> txdate;
    @FXML
    private TableColumn<coupon, Integer> txtaux;
    @FXML
    private TableColumn<coupon, String> txcode;
    @FXML
    private TableColumn<coupon, Integer> txnbr;
    @FXML
    private TableColumn<coupon, String> txtype;
    @FXML
    private Button txadd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txid.setCellValueFactory(new PropertyValueFactory<>("id_coupon"));
        txnom.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        txdate.setCellValueFactory(new PropertyValueFactory<>("date_experation"));
         txtaux.setCellValueFactory(new PropertyValueFactory<>("taux_reduction"));
          txcode.setCellValueFactory(new PropertyValueFactory<>("code_coupon"));
           txnbr.setCellValueFactory(new PropertyValueFactory<>("nbr_utilisation"));
               txtype.setCellValueFactory(new PropertyValueFactory<>("type"));
     
        couponCrud crud = new couponCrud();
        List<coupon>coupon = crud.displayCoupon();
        table.getItems().setAll(coupon);
    }    

    @FXML
    private void ajouter(MouseEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("ajoutercoupon.fxml"));
            Scene scene  = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Table1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void add(ActionEvent event) {
        
    }
    
}
