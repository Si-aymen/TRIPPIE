/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Mod_CovController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private Button valider;
    @FXML
    private TextField depart_TF;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private TextField date_dep_TF;
    @FXML
    private TextField id_co_TF;

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

        id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        depart_TF.setText(String.valueOf(Afficher_CovController.depart));
        destination_TF.setText(String.valueOf(Afficher_CovController.destination));
        date_dep_TF.setText(String.valueOf(Afficher_CovController.date_dep));
        nmbr_place_TF.setText(String.valueOf(Afficher_CovController.nmbr_place));
      
    }

    @FXML
    private void cov_btu(ActionEvent event) {
                try {

            Parent page1 = FXMLLoader.load(getClass().getResource("Menu_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void mod(ActionEvent event) {
        int id_co = Integer.parseInt(id_co_TF.getText());
        String depart = depart_TF.getText();
        String destination = destination_TF.getText();
        String date_dep = date_dep_TF.getText();
        int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        System.out.println(Integer.parseInt(Afficher_CovController.id_co));
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        CoVoiturage co = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        inter_co.modifierCoVoiturage(co, Integer.parseInt(Afficher_CovController.id_co));

    }

}
