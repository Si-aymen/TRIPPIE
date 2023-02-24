/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

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
public class ModifiercadeauController implements Initializable {

    @FXML
    private Button update;
    @FXML
    private TextField nomcadM;
    @FXML
    private TextField reccuuM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            nomcadM.setText(String.valueOf(Table2Controller.nom_cadeau));
        reccuuM.setText(String.valueOf(Table2Controller.reccurence));
        
    }    

    @FXML
    private void updateC(ActionEvent event) {
        
           int id;
            id = Integer.parseInt(String.valueOf(Table2Controller.id_cadeau));
            
    
    
    
            String nom_cadeau =nomcadM.getText();
            int nbr =Integer.parseInt(reccuuM.getText());
            
            
            cadeau c = new cadeau(Table2Controller.id_cadeau,nom_cadeau, reccuuM);
            
            cadeauCrud rc = new cadeauCrud();
            
            rc.modifier(c);
    }

   

    @FXML
    private void cleanC(ActionEvent event) {
        
    }
    
}
