/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class DashboardAdminController implements Initializable {

    ObservableList<Client> listUsers = FXCollections.observableArrayList();

    private SupprimerCard sup;

    private Approve app;

    Client client;
    ClientCRUD clientCRUD = new ClientCRUD();
    private int i = 0;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 0; i < clientCRUD.affiche().size(); i++) {

            listUsers.addAll(clientCRUD.affiche().get(i));
        }
        int row = 0;
        int column = 1;

        for (int i = 0; i < clientCRUD.affiche().size(); i++) {

            try {

                sup = this::supprimerr;
                app = this::approvee;
                FXMLLoader cards = new FXMLLoader();
                cards.setLocation(getClass().getResource("/edu/webuild/gui/ClientCard.fxml"));

                AnchorPane anchorPane = cards.load();

                ClientCardController cardController = cards.getController();

                cardController.setData(clientCRUD.affiche().get(i), sup, app);

                if (column == 3) {
                    column = 1;
                    row++;

                }
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(20));

////
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void supprimerr(Client client) {

        ClientCRUD ClientCRUD = new ClientCRUD();
        ClientCRUD.supprimerClient(client.getId_client());
        VBox dialogVbox = new VBox(10);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);

        dialogVbox.getChildren().add(new Text("Deleted"));
        Scene dialogScene = new Scene(dialogVbox, 200, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }

    private void approvee(Client client) {

        ClientCRUD ClientCRUD = new ClientCRUD();
        ClientCRUD.upDateStatus(client.getId_client());
        VBox dialogVbox = new VBox(10);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);

        dialogVbox.getChildren().add(new Text("Approuved"));
        Scene dialogScene = new Scene(dialogVbox, 200, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }

}
