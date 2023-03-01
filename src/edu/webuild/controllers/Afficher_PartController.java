/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.Participation;
import edu.webuild.services.ParticipationCrud;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Afficher_PartController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private ListView<Participation> listView;
    @FXML
    private Button delete_cov;
    @FXML
    private TextField Attribut_TF;
    @FXML
    private TextField Data_TF;
    @FXML
    private Button cov_btu1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView list2 = listView;
        Participation p = new Participation();
        InterfaceParticipation inter_part = new ParticipationCrud();
        List<Participation> list = inter_part.afficherParticipation();
        for (int i = 0; i < list.size(); i++) {
            Participation participation = list.get(i);
            list2.getItems().add(participation);
        }

    }

    @FXML
    private void cov_btu(ActionEvent event) {

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Menu_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void delete_Part(ActionEvent event) {
        ListView<Participation> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceParticipation inter_part = new ParticipationCrud();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        Participation p = list.getSelectionModel().getSelectedItem();// use getSelectedItem() to get the selected item, not getSelectedItems()
        System.out.println(p.getId_part());
        inter_part.supprimerParticipation(p.getId_part()); // assuming CoVoiturage has a method getId() to retrieve the unique ID of the object
        list.getItems().remove(selectedID);
    }

    @FXML
    private void recherche(ActionEvent event) {
        String Attribut = Attribut_TF.getText();
        String Data = Data_TF.getText();
        ListView list2 = listView;
        InterfaceParticipation inter_part = new ParticipationCrud();
        Participation p = new Participation();
        list2.getItems().clear();
        List<Participation> list = inter_part.Filter_Participation(Attribut, Data);
        for (int i = 0; i < list.size(); i++) {
            Participation participation = list.get(i);
            list2.getItems().add(participation);
        }

    }

    @FXML
    private void Print_pdf(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Piechart.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
