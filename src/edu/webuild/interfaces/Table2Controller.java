/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
import edu.webuild.services.cadeauCrud;
import edu.webuild.services.couponCrud;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Table2Controller implements Initializable {

    @FXML
    private TableView<cadeau> tablecadeau;
    @FXML
    private TableColumn<cadeau, Integer> idcadeau;
    @FXML
    private TableColumn<cadeau, String> nomcade;
    @FXML
    private TableColumn<cadeau, Integer> reccu;
    @FXML
    private TableColumn<cadeau, Integer> idc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idcadeau.setCellValueFactory(new PropertyValueFactory<>("id_cadeau"));
        nomcade.setCellValueFactory(new PropertyValueFactory<>("nom_cadeau"));
        reccu.setCellValueFactory(new PropertyValueFactory<>("recurrence"));
         idc.setCellValueFactory(new PropertyValueFactory<>("id_coupon"));
         
     
       cadeauCrud crud = new cadeauCrud();
        List<cadeau>cadeau = crud.displayCadeau();
        tablecadeau.getItems().setAll(cadeau);
    }    
    
}
