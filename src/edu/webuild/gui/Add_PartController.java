/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.Participation;
import edu.webuild.services.ParticipationCrud;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Add_PartController implements Initializable {

    @FXML
    private TextField nmbr_place_part;
    @FXML
    private Button part_btu;
    @FXML
    private Button Cov_btu;
    @FXML
    private Label nmbr_place_Lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nmbr_place_Lab.setText(String.valueOf(Afficher_CovController.nmbr_place));

    }

    @FXML
    private void valider(ActionEvent event) {
        int nmbr_place_prat = Integer.parseInt(nmbr_place_part.getText());
        System.out.println(Integer.parseInt(Afficher_CovController.id_co));
        InterfaceParticipation inter_part = new ParticipationCrud();
        Participation part = new Participation(nmbr_place_prat, Integer.parseInt(Afficher_CovController.id_co));

        if (Integer.parseInt(nmbr_place_part.getText()) > Integer.parseInt(Afficher_CovController.nmbr_place)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();
        } else if(Integer.parseInt(nmbr_place_part.getText()) < Integer.parseInt(Afficher_CovController.nmbr_place))  {
        }
        inter_part.ajouterParticipation(part);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Participation insérée avec succés!");
        alert.show();

    }

    @FXML
    private void part_btu(ActionEvent event) {
    }

    @FXML
    private void Cov_btu(ActionEvent event) {
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

}
