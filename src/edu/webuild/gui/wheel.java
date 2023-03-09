/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.controllers.Main;

import javafx.application.Application;

import javafx.stage.Stage;


/**
 *
 * @author HP
 */
public class wheel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
          Main main = new Main();
          main.start(new Stage());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
