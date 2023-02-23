/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.controllers.Menu_CoVoiturageController;
import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import edu.webuild.services.ParticipationCrud;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Afficher_CovController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private Button modify_cov;
    @FXML
    private Button delete_cov;
    @FXML
    private ListView<CoVoiturage> listView;

    static public String id_co;
    static public String depart;
    static public String destination;
    static public Date date_dep;
    static public String nmbr_place;

    static String id_part;

    @FXML
    private Button part_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView list2 = listView;
        CoVoiturage V = new CoVoiturage();
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        List<CoVoiturage> list = inter_co.afficherCoVoiturage();
        for (int i = 0; i < list.size(); i++) {
            CoVoiturage covoiturage = list.get(i);
            list2.getItems().add(covoiturage);
        }

        list2.setCellFactory(new Callback<ListView<CoVoiturage>, ListCell<CoVoiturage>>() {
            @Override
            public ListCell<CoVoiturage> call(ListView<CoVoiturage> listView) {
                return new ListCell<CoVoiturage>() {
                    @Override
                    protected void updateItem(CoVoiturage covoiturage, boolean empty) {
                        super.updateItem(covoiturage, empty);
                        if (covoiturage != null && !empty) {
                            // Affiche les informations du covoiturage dans la cellule
                            setText(String.format("%s -> %s (%s) - %d places disponibles",
                                    covoiturage.getDepart(),
                                    covoiturage.getDestination(),
                                    covoiturage.getDate_dep(),
                                    covoiturage.getNmbr_place()));
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
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
    private void modify_cov(ActionEvent event) {
        ListView<CoVoiturage> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_co = Integer.toString(V.getId_co());
        depart = V.getDepart();
        destination = V.getDestination();
        date_dep = V.getDate_dep();
        nmbr_place = Integer.toString(V.getNmbr_place());

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Mod_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void delete_cov(ActionEvent event) {

        ListView<CoVoiturage> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()
        System.out.println(V.getId_co());
        inter_co.supprimerCoVoiturage(V.getId_co()); // assuming CoVoiturage has a method getId() to retrieve the unique ID of the object
        list.getItems().remove(selectedID);
    }

    @FXML
    private void part(ActionEvent event) {

        ListView<CoVoiturage> list = listView; // assuming listView is a ListView<CoVoiturage>
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        InterfaceParticipation inter_part = new ParticipationCrud();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem(); // use getSelectedItem() to get the selected item, not getSelectedItems()*
        id_co = Integer.toString(V.getId_co());
        nmbr_place = Integer.toString(V.getNmbr_place());

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Add_Part.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }

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
