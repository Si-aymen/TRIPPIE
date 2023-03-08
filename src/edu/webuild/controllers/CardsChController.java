/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import edu.webuild.utils.MyConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class CardsChController implements Initializable {

    private InterfaceChauffeurCRUD ChauffeurCRUD = new ChauffeurCRUD();
    private List<Chauffeur> chauffeurDataList = FXCollections.observableArrayList();
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    MyConnection conn;
    @FXML
    private Button cov_btu1;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chauffeurDataList.addAll(ChauffeurCRUD.afficherChauffeur3());
        int column = 0;
        int row = 3;
        for (int i = 0; i < chauffeurDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ChauffeurCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ChauffeurCardController item = fxmlLoader.getController();

                item.setDataClient(chauffeurDataList.get(i).getId_role().getId_user().getNom(), chauffeurDataList.get(i).getId_role().getId_user().getPrenom(),
                        chauffeurDataList.get(i).getId_role().getLibelle(), chauffeurDataList.get(i).getNum_permis(), chauffeurDataList.get(i).getImg());
                
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
    }


    public void disableChauffeur(int id_ch) {
    }

    @FXML
    private void cov_btu(ActionEvent event) {
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Menu_User.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_UserController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void stats(ActionEvent event) { 
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Stat_utilisateur.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_UserController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
