/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.LocateurCRUD;
import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class CardsController implements Initializable {
 private List<Client> clientDataList = FXCollections.observableArrayList();


    private InterfaceClientCRUD ClientCRUD = new ClientCRUD();
  
  
    @FXML
    private Button back;
    @FXML
    private TextField search_bar;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ImageView det_cov_img;
    @FXML
    private Label det_dep;
    @FXML
    private Label det_dest;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         clientDataList.addAll(ClientCRUD.afficherClient3());
     
         
        int column = 0;
        int row = 3;
        for (int i = 0; i < clientDataList.size() ; i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ClientCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ClientCardController item = fxmlLoader.getController();
              
                
                item.setDataClient(clientDataList.get(i).getId_role().getId_user().getNom(), clientDataList.get(i).getId_role().getId_user().getPrenom(),clientDataList.get(i).getId_role().getLibelle(),clientDataList.get(i).getImg());
                
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

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void search_btu(ActionEvent event) {
    }

    @FXML
    private void details_btu(ActionEvent event) {
    }

   
    
}
