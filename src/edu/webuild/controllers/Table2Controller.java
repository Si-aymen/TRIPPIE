/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.webuild.model.cadeau;
import edu.webuild.services.cadeauCrud;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Table2Controller implements Initializable {

    @FXML
    private FontAwesomeIconView mod;
    @FXML
    private ListView<cadeau> affichCadeau;
    static int id_cadeau;
    static String nom_cadeau;
    static int reccurence;
  static String dess;
    static int vall;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadeauCrud crud = new cadeauCrud();
        List<cadeau>cadeau = crud.displayCadeau();
        affichCadeau.getItems().setAll(cadeau);
    }    

    @FXML
    private void deleteC(MouseEvent event) { 
        cadeau selectedcadeau = affichCadeau.getSelectionModel().getSelectedItem();
     cadeauCrud couponService=new cadeauCrud();
    String nom = selectedcadeau.getNom_cadeau();
    couponService.Supprimer(nom);
    affichCadeau.refresh();
  
    List<cadeau>cadeau = couponService.displayCadeau();
    affichCadeau.getItems().setAll(cadeau);
    }

    @FXML
    private void ADDC(MouseEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouterCadeau.fxml"));
            Scene scene  = new Scene(root,700,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Table1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refreshC(MouseEvent event) {
        cadeauCrud crud = new cadeauCrud();
        List<cadeau>cadeau = crud.displayCadeau();
        affichCadeau.getItems().setAll(cadeau);
      
    }

    @FXML
    private void MODIFIERCad(MouseEvent event) {
         try {
            Parent root=FXMLLoader.load(getClass().getResource("/edu/webuild/gui/modifiercadeau.fxml"));
            Scene scene  = new Scene(root,700,700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Table1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeC(MouseEvent event) {
           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
