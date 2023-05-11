/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.inter.interfacecadeau;
import edu.webuild.model.cadeau;
import edu.webuild.services.cadeauCrud;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierCadeau_backController implements Initializable {

    @FXML
    private Button clean;
    @FXML
    private TextField nomcadM;
    @FXML
    private TextField reccuuM;
    @FXML
    private TextField dessm;
    @FXML
    private TextField valm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomcadM.setText(String.valueOf(Marketcadeau_backController.nom_cadeau));
        reccuuM.setText(String.valueOf(Marketcadeau_backController.reccurence));
        dessm.setText(String.valueOf(Marketcadeau_backController.dess));
        valm.setText(String.valueOf(Marketcadeau_backController.vall));}


    @FXML
    private void clean(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
         interfacecadeau inter = new cadeauCrud();

        String nom = nomcadM.getText();
        int recc = Integer.parseInt(reccuuM.getText());
        String dess = dessm.getText();
        int valeur = Integer.parseInt(valm.getText());


        cadeau v = new cadeau(Marketcadeau_backController.id_cadeau,nom, recc, dess,valeur);
        inter.modifier(v);
    }
    
}
