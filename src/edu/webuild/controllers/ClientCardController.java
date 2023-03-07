/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.model.Etat;
import edu.webuild.services.ClientCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ClientCardController implements Initializable {

    private Client client;
    private SupprimerCard supprimero;
    @FXML
    private Label fx_nom;
    @FXML
    private Label fx_prenom;
    @FXML
    private Label fx_etat;
    @FXML
    private ImageView img;
    private Label fx_prix_par_jour;
    @FXML
    private Button disablebtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDataClient(String nom, String prenom,String libelle,String url) {
        fx_nom.setText(nom);
        fx_prenom.setText(prenom);
        fx_etat.setText(libelle);
        String fullurl = "C:\\xampp\\htdocs\\" + url ;
        System.out.println(fullurl);
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
//        disablebtn.setOnAction(e -> {
//            try {
//                ClientCRUD cc = new ClientCRUD();
//                Client c = cc.getClientCard(0);
//                cc.disableClient(c.getNum_permis());
//                System.out.println(c.getId_ch());
//            } catch (SQLException ex) {
//                Logger.getLogger(ClientCardController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
      
        
        
    }

    @FXML
    private void disable(ActionEvent event) {
    }

}
