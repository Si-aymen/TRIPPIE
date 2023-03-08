package edu.webuild.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class TestMapController implements Initializable {

    public static double lon;
    public static double lat;

    @FXML
    private WebView webview;
    private WebEngine webengine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webengine = webview.getEngine();
        System.out.println("map load");
        // Load the web page from the correct URL
        // webengine.load(getClass().getResource("/edu/webuild/controllers/map/index.html").toString());
        url = this.getClass().getResource("/edu/webuild/controllers/map/googleMaps.html");
//        url = this.getClass().getResource("/edu/webuild/controllers/map/recupMap.html");
//        File file = new File("/edu/webuild/controllers/map/index.html");
        webengine.load(url.toString());
        webengine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            System.out.println("Web page loading status: " + newState);
        });
        //webengine.load(url.toString());

        //webengine.load("https://www.google.com");
        System.out.println("map loaded");
    }

    @FXML

    private void tt(ActionEvent event) {

        lat = (Double) webview.getEngine().executeScript("lat");
        lon = (Double) webview.getEngine().executeScript("lon");

        System.out.println("Lat: " + lat);
        System.out.println("Lon: " + lon);

    }

    // JavaScript interface object
    private class JavaApp {

        public void exit() {
            Platform.exit();
        }

    }
}
