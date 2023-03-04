/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.voiture;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class Item_voitureController implements Initializable {

    @FXML
    private Label depart;
    @FXML
    private Label destination;
    @FXML
    private Label temps;
    @FXML
    private ImageView img;
    @FXML
    private Label nb_plc;
    private MyListener myListener;
    private voiture v;
    @FXML
    private Button reserver;

    /**
     * Initializes the controller class.
     */
    public void setData(int id,String marque, String puissance, String url, String prix_jour) {
        depart.setText(marque);
        destination.setText(puissance);
        String fullurl = "C:\\xampp\\htdocs\\image_trippie_cov\\" + url;
        nb_plc.setText(prix_jour);
        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void onClick() {
        myListener.onClick(v);
       // System.out.println(v);
    }
    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }
    @FXML
    private void reservervotrevoiture(ActionEvent event) {
        try {
            Parent page1
                    = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reservervoiturefront.fxml"
                    ));

            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            Logger.getLogger(ReservervoiturefrontController.class.getName()).log(Level.SEVERE,
                    null, ex);

        }
    }

    public interface MyListener {

        void onClick(voiture v);
    }
}
