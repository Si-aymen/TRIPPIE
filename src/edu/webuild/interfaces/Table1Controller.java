/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.inter.interfacecoupon;
import edu.webuild.model.coupon;
import edu.webuild.services.couponCrud;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
     
        couponCrud crud = new couponCrud();
        List<coupon>coupon = crud.displayCoupon();
       afficher.getItems().setAll(coupon);
      
       
     }   

   


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
    private void refresh(MouseEvent event) {
       
    couponCrud crud = new couponCrud();
    List<coupon>coupon = crud.displayCoupon();
    afficher.getItems().setAll(coupon);
    }

    @FXML
    private void delete(MouseEvent event) {
     coupon selectedCoupon = afficher.getSelectionModel().getSelectedItem();
     couponCrud couponService=new couponCrud();
    int id = selectedCoupon.getId_coupon();
    couponService.Supprimer(id);
    
  afficher.refresh();
    }


    @FXML
    private void MODIFIER(MouseEvent event) {
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


}
