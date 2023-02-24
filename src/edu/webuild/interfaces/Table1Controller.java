/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.webuild.inter.interfacecoupon;
import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Table1Controller implements Initializable {


    @FXML
    private ListView<coupon> afficher;
    @FXML
    private FontAwesomeIconView delete;
    static int id_coupon;
    static Date date_deb;
    static Date date_exper;
    static int taux;
    static String code;
    static int nbr;
    static String type;
    @FXML
    private Button cadeau;

    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
     
     couponCrud crud = new couponCrud();
     List<coupon> coupons = crud.displayCoupon();
     for (coupon c : coupons) {
    afficher.getItems().add(c);
}}
    
    

    @FXML
    private void ADD(MouseEvent event) {
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
    private void close(MouseEvent event) {
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML
    private void delete(MouseEvent event) {
   coupon selectedCoupon = afficher.getSelectionModel().getSelectedItem();
     couponCrud couponService=new couponCrud();
    String code = selectedCoupon.getCode_coupon();
    couponService.Supprimer(code);
    afficher.refresh();
    couponCrud crud = new couponCrud();
    List<coupon>coupon = crud.displayCoupon();
    afficher.getItems().setAll(coupon);
}
    @FXML
    private void refrech(MouseEvent event) {
    couponCrud crud = new couponCrud();
    List<coupon>coupon = crud.displayCoupon();
    afficher.getItems().setAll(coupon);
    }

    @FXML
    private void update(MouseEvent event) {
        ListView<coupon> list = afficher;
        interfacecoupon inter = new couponCrud();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        coupon c = list.getSelectionModel().getSelectedItem();
        id_coupon = c.getId_coupon();
        date_deb = c.getDate_debut();
        date_exper = c.getDate_experation();
        taux = c.getTaux_reduction();
        code = c.getCode_coupon();
        nbr =c.getNbr_utilisation();
        type=c.getType();

        try {
            Parent root=FXMLLoader.load(getClass().getResource("modifier.fxml"));
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
    private void cadeau(ActionEvent event) {
        
        
         try {
            Parent root=FXMLLoader.load(getClass().getResource("ajouterCadeau.fxml"));
            Scene scene  = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Table1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}




    
 



