/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class RecaptchaController implements Initializable {

    @FXML
    private WebView webview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //webview.getEngine().load("https://www.google.com/recaptcha/api.js");
       // webview.getEngine().load("C:\\Users\\manou\\Desktop\\recaptcha.html");
        webview.getEngine().load("https://www.google.com/recaptcha/api/fallback?k=6LeOGckkAAAAAJie-WTaI02fRKP_-thlqEcc3GHG");
    }

}
