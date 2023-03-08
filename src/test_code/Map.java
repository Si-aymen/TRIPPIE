package test_code;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

public class Map extends Application {

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

        // add the JXMapViewer to a new StackPane
        StackPane stackPane;
        stackPane = new Pane(mapViewer);

        // set the StackPane as the root node of the Scene
        jfxPanel.setScene(new Scene(stackPane, 800, 600));

        // create the JavaFX stage and set the JFXPanel as the root node
        primaryStage.setScene(new Scene(jfxPanel));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
