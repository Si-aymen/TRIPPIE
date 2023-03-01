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
    static public String id_part;
    static public String url_img;
    static public CoVoiturage covt1, covt2;

    @FXML
    private Button part_btn;
    @FXML
    private Button details_btn;
    @FXML
    private TextField attribue;
    @FXML
    private TextField valuee;

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

        ListView<CoVoiturage> list = listView;
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        int selectedID = list.getSelectionModel().getSelectedIndex();
        CoVoiturage V = list.getSelectionModel().getSelectedItem();
        id_co = Integer.toString(V.getId_co());
        depart = V.getDepart();
        destination = V.getDestination();
        date_dep = V.getDate_dep();
        nmbr_place = Integer.toString(V.getNmbr_place());
        System.out.println(id_co);

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

//    private void modify_cov(ActionEvent event) {
//        ListView<CoVoiturage> list = listView;
//        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
//        int selectedID = list.getSelectionModel().getSelectedIndex();
//        CoVoiturage V = list.getSelectionModel().getSelectedItem();
//        id_co = Integer.toString(V.getId_co());
//        depart = V.getDepart();
//        destination = V.getDestination();
//        Date date_dep = V.getDate_dep();
//        nmbr_place = Integer.toString(V.getNmbr_place());
//        System.out.println(id_co);
//
//        // Date actuelle
//        LocalDateTime date2 = LocalDateTime.now();
//        LocalDateTime date_dep_local = date_dep.toInstant().atZone(ZoneId.of("Tunis")).toLocalDateTime();
//
//        // Calcul de la durée en secondes
//        ZonedDateTime zdt = date_dep_local.atZone(ZoneId.systemDefault());
//        Duration duration = Duration.between(zdt, date2.atZone(ZoneId.systemDefault()));
//        long seconds = duration.getSeconds();
//        System.out.println("La durée entre la date donnée en argument et le temps actuel est de " + seconds + " secondes.");
//
//        // Calcul de la durée en heures, minutes et secondes
//        long hours = duration.toHours();
//        long minutes = duration.toMinutes() % 60;
//        long seconds2 = duration.getSeconds() % 60;
//        System.out.printf("La durée entre la date donnée en argument et le temps actuel est de %d heures, %d minutes et %d secondes.%n", hours, minutes, seconds2);
//
//        try {
//            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Mod_Cov.fxml"));
//            Scene scene = new Scene(page1);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
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

    @FXML
    private void details(ActionEvent event) {

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

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/details_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void filtre(ActionEvent event) {
        String attribut = attribue.getText();
        String value = valuee.getText();
        ListView list2 = listView;
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        CoVoiturage v = new CoVoiturage();
        list2.getItems().clear();
        List<CoVoiturage> list = inter_co.Filter_CoVoiturage(attribut, value);
        for (int i = 0; i < list.size(); i++) {
            CoVoiturage covoiturage = list.get(i);
            list2.getItems().add(covoiturage);
        }

    }

    @FXML
    private void Compare(ActionEvent event) {

        ListView<CoVoiturage> list = listView;
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();

        // Get the selected items
        ObservableList<CoVoiturage> selectedItems = list.getSelectionModel().getSelectedItems();

        // Make sure exactly 2 items are selected
        if (selectedItems.size() != 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selection Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select exactly 2 items to compare");
            alert.showAndWait();
            return;
        }

        // Get the selected items as CoVoiturage objects
        covt1 = selectedItems.get(0);
        covt2 = selectedItems.get(1);

        System.out.println(covt1);
        System.out.println(covt2);

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/compare_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
