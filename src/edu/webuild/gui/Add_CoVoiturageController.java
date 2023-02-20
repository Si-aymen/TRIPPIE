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
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Add_CoVoiturageController implements Initializable {

    @FXML
    private TextField depart_TF;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField date_dep_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private Button add_CoVoiturage_btn;
    @FXML
    private DatePicker ok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add_CoVoiturage(ActionEvent event) {
        String depart = depart_TF.getText();
        String destination = destination_TF.getText();
        String date_dep = date_dep_TF.getText();
        int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        CoVoiturage v = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        inter_co.ajouterCoVoiturage(v);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("voiture insérée avec succés!");
        alert.show();

    }

}
