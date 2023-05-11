/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.Participation;
import edu.webuild.services.ParticipationCrud;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Add_part_FrontController implements Initializable {

    @FXML
    private Button cov_btu;
    private final Integer[] nmbr_place_list = {1, 2, 3, 4, 5, 6};
    @FXML
    private Label nmbr_place_Lab;
    @FXML
    private ChoiceBox<Integer> nmbr_place_part;

    public static int client_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("add part page id client = "+ProfilClientController.var_client_id);
        nmbr_place_part.getItems().addAll(nmbr_place_list);
        nmbr_place_Lab.setText(String.valueOf(Item_covController.covt.getNmbr_place()));

    }

    @FXML
    private void Add_part(ActionEvent event) {
        int nmbr_place_prat = nmbr_place_part.getValue();
        System.out.println(Item_covController.covt.getId_co());
        InterfaceParticipation inter_part = new ParticipationCrud();
        Participation part = new Participation(nmbr_place_prat, Item_covController.covt.getId_co(),ProfilClientController.var_client_id);
        int nmbr_place_cov = Item_covController.covt.getNmbr_place();

        if (nmbr_place_prat > nmbr_place_cov) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();
        } else if ((nmbr_place_prat < nmbr_place_cov) || (nmbr_place_prat > 0)) {

            inter_part.ajouterParticipation(part);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Participation insérée avec succés!");
            alert.show();

        }

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Front/Market_cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void cov_btu(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void Add_btu(ActionEvent event) {
    }

}
