/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;


import edu.webuild.gui.tablemain;
import edu.webuild.inter.interfacecoupon;

import edu.webuild.services.couponCrud;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.webuild.model.coupon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Market_couponBackController implements Initializable {


      static int id_coupon;
    static Date date_deb;
    static Date date_exper;
    static int taux;
    static String code;
    static int nbr;
    static String type;
    private interfacecoupon couponCrud = new couponCrud();
    @FXML
    private ListView<coupon> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             couponCrud crud = new couponCrud();
        // pour récupérer une liste de tous les coupons stockés
        List<coupon> coupons = crud.displayCoupon();
        //parcourir tous les coupons de la liste et ajouter chaque coupon à un composant
        for (coupon c : coupons) {
            //add() est utilisée pour ajouter chaque coupon à la liste des coupons affichés dans le composant ListView.
            table.getItems().add(c);
        }
    }    

  

    @FXML
    private void add(MouseEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ADD_couponBack.fxml"));
            Scene scene = new Scene(root,1370, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            

        } catch (IOException ex) {
            Logger.getLogger(Market_couponBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void update(MouseEvent event) {
        
              ListView<coupon> list = table;
        interfacecoupon inter = new couponCrud();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        coupon c = list.getSelectionModel().getSelectedItem();
        date_deb = c.getDate_debut();
        date_exper = c.getDate_experation();
        taux = c.getTaux_reduction();
        code = c.getCode_coupon();
        nbr = c.getNbr_utilisation();
        type = c.getType();
        id_coupon = c.getId_coupon();
        System.out.println(id_coupon);
        System.out.println(type);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifier_couponBack.fxml"));
            Scene scene = new Scene(root, 1370, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Market_couponBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
           //awel hja on recupere le coupon selectionner f listview
        coupon selectedCoupon = table.getSelectionModel().getSelectedItem();
        //mn baaed cree instance 
        couponCrud couponService = new couponCrud();

        String code = selectedCoupon.getCode_coupon();
        couponService.Supprimer(code);
        //reafficher 
        table.refresh();

        couponCrud crud = new couponCrud();
        // on récupère à nouveau la liste des coupons
        List<coupon> coupon = crud.displayCoupon();
        //  on met à jour le contenu de la ListView en utilisant la méthode setAll()
        table.getItems().setAll(coupon);
    }

    @FXML
    private void refresh(MouseEvent event) {
         couponCrud crud = new couponCrud();
        List<coupon> coupon = crud.displayCoupon();
        table.getItems().setAll(coupon);
    }

    
}
