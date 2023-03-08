/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.controllers.Menu_CoVoiturageController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class CarteController implements Initializable {

    @FXML
    private ImageView imagepost;
    @FXML
    private Label id_user_lab;
    @FXML
    private Label Depart_lab;
    @FXML
    private Label tfdescription;
    @FXML
    private Label destination_lab;
    @FXML
    private Label tfdatepost;
    @FXML
    private Label tfnbr_jaime;
    @FXML
    private Label idpostlabel;
    @FXML
    private Label labelimage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void setData(String id, String depart, String destination) {
        Depart_lab.setText(depart);
        id_user_lab.setText(id);
        destination_lab.setText(destination);

    }

    @FXML
    private void details(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/details.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
