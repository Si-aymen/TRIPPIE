/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class List_covController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private final ObservableList<CoVoiturage> covDataList = FXCollections.observableArrayList();
    private final InterfaceCoVoiturage coVoiturageCRUDService = new CoVoiturageCRUD();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        covDataList.addAll(coVoiturageCRUDService.afficherCoVoiturage());
        loadCoVoiturageItems();
    }

    private void loadCoVoiturageItems() {
        int column = 0;
        int row = 3;
        for (int i = 0; i < covDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu.webuild.gui/Carte_cov.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CarteController itemController = fxmlLoader.getController();
                itemController.setData(Integer.toString(covDataList.get(i).getId_co()), covDataList.get(i).getDepart(), covDataList.get(i).getDestination());

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
