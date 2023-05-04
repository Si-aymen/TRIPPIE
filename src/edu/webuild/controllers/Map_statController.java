/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Map_statController implements Initializable {

    @FXML
    private AnchorPane mapPane;

    String token = "pk.eyJ1IjoiYXltZW5yYWhhbGkiLCJhIjoiY2xlcXl1bm1oMHIxZzQ3bzF4cXNkd2l6aiJ9.-sBFov8MbkmGeRI3Ei0kyA";
    static String Zoom = "20";
    String url1 = "https://api.mapbox.com/styles/v1/mapbox/streets-v11/static/9.5375,33.8869," + Zoom + ",0,0/800x600?access_token=" + token;
    @FXML
    private Button plus_btu;
    @FXML
    private Button moin_btu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateImage();
    }

    private void updateImage() {
        try {
            URL obj = new URL(url1);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Image image = new Image(con.getInputStream());
                ImageView imageView = new ImageView(image);
                mapPane.getChildren().add(imageView);
            }
            con.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void plus_btu(ActionEvent event) {
        int x = Integer.parseInt(Zoom);
        x++;
        Zoom = Integer.toString(x);
        url1 = "https://api.mapbox.com/styles/v1/mapbox/streets-v11/static/9.5375,33.8869," + Zoom + ",0,0/800x600?access_token=" + token;
        mapPane.getChildren().clear(); // clear old image
        updateImage(); // load new image
    }

    @FXML
    private void moin_btu(ActionEvent event) {
        // Similar to plus_btu but for decreasing zoom level
    }
}
