/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private TextField fxid_coup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(MouseEvent event) {
    }

    @FXML
    private void cleanm(MouseEvent event) {
    }
    
}
