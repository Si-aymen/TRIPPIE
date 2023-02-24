/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class tablemain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        try {
            // charger l'interface graphique 
            //FXMLLoader.load, vous spécifiez le nom du fichier FXML que vous souhaitez charger 
            //cette méthode crée un objet de type Parent qui représente la racine de votre interface utilisateur
           Parent   root = FXMLLoader.load(getClass().getResource("main.fxml"));
           //qui représente la racine de votre interface utilisateur qui représente la racine de votre interface utilisateur
            Scene scene = new Scene(root,700,700);
        
        primaryStage.setTitle("Promotion");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(tablemain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
