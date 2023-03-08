/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_code;

import java.util.Collection;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 *
 * @author manou
 */
public class Mappy extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create a JFXPanel to hold the map
        JFXPanel jfxPanel = new JFXPanel();

        // create a TileFactoryInfo object for OpenStreetMap
        TileFactoryInfo info = new TileFactoryInfo(1, 17, 19, 256, true, true, "https://a.tile.openstreetmap.org/", "x", "y", "z");

        // create a DefaultTileFactory using the TileFactoryInfo
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        // create a JXMapViewer using the DefaultTileFactory
        JXMapViewer mapViewer = new JXMapViewer();

        mapViewer.setTileFactory(tileFactory);

        // set the center position of the map to Paris
        GeoPosition paris = new GeoPosition(48.8567, 2.3508);
        mapViewer.setAddressLocation(paris);

        // add the JXMapViewer to the JFXPanel
        Group p = new Group((Collection<Node>) mapViewer);
        Scene c = new Scene(p, 800, 600);
        jfxPanel.setScene(c);

        // create the JavaFX stage and set the JFXPanel as the root node
        primaryStage.setScene(c);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
