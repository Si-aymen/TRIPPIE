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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Add_CovController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private Button bu_add;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private TextField date_dep_TF;
    @FXML
    private TextField depart_TF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void bu_add(ActionEvent event) {
        String depart = depart_TF.getText();
        String destination = destination_TF.getText();
        String date_dep = date_dep_TF.getText();
        int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        if (nmbr_place > 7 || nmbr_place == 0 || nmbr_place < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();

        } else if (depart.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de depart est vide ");
            alert.show();
        } else if (destination.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de destination est vide ");
            alert.show();
        } else if (date_dep.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label du date est vide ");
            alert.show();
        } else {
            inter_co.ajouterCoVoiturage(v);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("voiture insérée avec succés!");
            alert.show();
        }
    }

}
