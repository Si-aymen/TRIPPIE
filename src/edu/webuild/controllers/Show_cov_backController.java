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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Show_cov_backController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private ListView<CoVoiturage> listView;
    @FXML
    private Button cov_btu;

    static public String id_co;
    static public String depart;
    static public String destination;
    static public Date date_dep;
    static public String nmbr_place;
    static public String id_part;
    static public String url_img;
    static public CoVoiturage covt1, covt2;

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
    private void modify_cov(ActionEvent event) {
        ListView<CoVoiturage> list = listView;
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem();
        id_co = Integer.toString(V.getId_co());
        depart = V.getDepart();
        destination = V.getDestination();
        date_dep = V.getDate_dep();
        nmbr_place = Integer.toString(V.getNmbr_place());
        url_img = V.getCov_img();
        //System.out.println(V.getCov_img());

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/back/Modifier_back_cov.fxml"));
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
        ListView<CoVoiturage> list = listView;
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem();
        inter_co.supprimerCoVoiturage(V.getId_co());

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Show_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void Details(ActionEvent event) {
        ListView<CoVoiturage> list = listView;
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem();
        id_co = Integer.toString(V.getId_co());
        depart = V.getDepart();
        destination = V.getDestination();
        date_dep = V.getDate_dep();
        nmbr_place = Integer.toString(V.getNmbr_place());
        url_img = V.getCov_img();
        //System.out.println(V.getCov_img());

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Details_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void part(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Add_cov_back.fxml"));
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
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Add_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void add_cov(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Add_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
