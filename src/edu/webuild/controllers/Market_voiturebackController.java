/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Market_voiturebackController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private List<voiture> voitDataList = FXCollections.observableArrayList();
    private InterfaceCRUD voitureCRUD = new voitureCRUD();
    @FXML
    private Button add_voiture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        voitDataList.addAll(voitureCRUD.affichervoitures());
        int column = 0;
        int row = 3;
        for (int i = 0; i < voitDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/cardvoiture.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                CardvoitureController item = fxmlLoader.getController();

                item.setData(voitDataList.get(i).getId(), voitDataList.get(i).getMatricule(), voitDataList.get(i).getMarque(), voitDataList.get(i).getPuissance(), voitDataList.get(i).getImage_voiture(), Integer.toString(voitDataList.get(i).getPrix_jours()), voitDataList.get(i).getEnergie(), voitDataList.get(i).getEtat());
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
                
                

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
            } catch (IOException e) {
                System.out.println("problem");
                e.printStackTrace();
            }
        }
        // TODO
    }
   

    @FXML
    private void add_voiture(ActionEvent event) {
        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Ajoutervoitureback.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_voitureController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
