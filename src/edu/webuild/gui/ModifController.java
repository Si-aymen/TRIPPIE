/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
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
 * @author manou
 */
public class ModifController implements Initializable {
    
    @FXML
    private Button mod;
    @FXML
    private TextField id_co_TF;
    @FXML
    private TextField depart_TF;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private TextField date_dep_TF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Show_CoVoiturageController sh = new Show_CoVoiturageController();
//        id_co_TF.setPromptText(Show_CoVoiturageController.id_co);
//        depart_TF.setPromptText(Show_CoVoiturageController.depart);
//        destination_TF.setPromptText(Show_CoVoiturageController.destination);
//        date_dep_TF.setPromptText(Show_CoVoiturageController.date_dep);
//        nmbr_place_TF.setPromptText(Show_CoVoiturageController.nmbr_place);
//        System.out.println(Show_CoVoiturageController.depart);

        id_co_TF.setText(String.valueOf(Show_CoVoiturageController.id_co));
        depart_TF.setText(String.valueOf(Show_CoVoiturageController.depart));
        destination_TF.setText(String.valueOf(Show_CoVoiturageController.destination));
        date_dep_TF.setText(String.valueOf(Show_CoVoiturageController.date_dep));
        nmbr_place_TF.setText(String.valueOf(Show_CoVoiturageController.nmbr_place));
    }
    
    @FXML
    private void mod(ActionEvent event) {
        
        int id_co = Integer.parseInt(id_co_TF.getText());
        String depart = depart_TF.getText();
        String destination = destination_TF.getText();
        String date_dep = date_dep_TF.getText();
        int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        System.out.println(Integer.parseInt(Show_CoVoiturageController.id_co));
        
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        CoVoiturage co = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        
        inter_co.modifierCoVoiturage(co, Integer.parseInt(Show_CoVoiturageController.id_co));
        
    }
    
}
