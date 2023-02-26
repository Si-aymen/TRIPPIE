package edu.webuild.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.mapsfx.MapView;

/**
 * FXML Controller class
 */
public class MapController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a MapView
        MapView mapView = new MapView();

        // Create a border pane to hold the MapView
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mapView);

        // Create a scene
        Scene scene = new Scene(borderPane, 800, 600);

        // Create a stage
        Stage stage = new Stage();
        stage.setTitle("Map Example");

        // Set the scene on the stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

}
