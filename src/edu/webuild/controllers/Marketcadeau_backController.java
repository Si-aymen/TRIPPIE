/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.cadeau;
import edu.webuild.services.cadeauCrud;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Marketcadeau_backController implements Initializable {

    @FXML
    private ListView<cadeau> tablecad;
    static int id_cadeau;
    static String nom_cadeau;
    static int reccurence;
    static String dess;
    static int vall;
       static int id_cou;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadeauCrud crud = new cadeauCrud();
        List<cadeau>cadeau = crud.displayCadeau();
        tablecad.getItems().setAll(cadeau);
    }    

    @FXML
    private void delete(MouseEvent event) {
          cadeau selectedcadeau = tablecad.getSelectionModel().getSelectedItem();
     cadeauCrud couponService=new cadeauCrud();
    String nom = selectedcadeau.getNom_cadeau();
    couponService.Supprimer(nom);
    tablecad.refresh();
  
    List<cadeau>cadeau = couponService.displayCadeau();
    tablecad.getItems().setAll(cadeau);
    }

    @FXML
    private void update(MouseEvent event) {
            try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifierCadeau_back.fxml"));
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
    private void add(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/addcadeau_back.fxml"));
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
    private void REFRESH(MouseEvent event) {
         cadeauCrud crud = new cadeauCrud();
        List<cadeau>cadeau = crud.displayCadeau();
        tablecad.getItems().setAll(cadeau);
    }
    
}
