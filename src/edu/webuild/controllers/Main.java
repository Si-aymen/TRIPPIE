package edu.webuild.controllers;



import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
    private static final int NUM_SECTIONS = 8;
    private static final double START_ANGLE = 0;
    private static final double ARC_LENGTH = 360.0 / NUM_SECTIONS;
    private RotateTransition rotateTransition;

    private Group root;
    private Random random;
     private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        random = new Random();
        
  // create the image

  
  





      // Create the sections of the wheel with random colors
        for (int i = 0; i < NUM_SECTIONS; i++) {
            Color color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            Arc arc = new Arc(200, 200, 150, 150, START_ANGLE + i * ARC_LENGTH, ARC_LENGTH);
            arc.setFill(color);
            arc.setType(ArcType.ROUND);
            root.getChildren().add(arc);
        }

        // Create the text sections for each section of the wheel
        double textRadius = 120;
        double textAngle = START_ANGLE + ARC_LENGTH / 2;

        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webuild3", "root", "");

            // Prepare a statement to retrieve the taux_reduction values
            stmt = conn.prepareStatement("SELECT taux from coupon");

            // Execute the statement and retrieve the results
            rs = stmt.executeQuery();

            // Loop through the results and update the text of each section
            int i = 0;
            while (i < NUM_SECTIONS) {
                if (rs.next()) {
                    double taux_reduction = rs.getDouble("taux");
                    Text text = new Text(getTextX(textRadius, textAngle), getTextY(textRadius, textAngle), String.format("%.2f", taux_reduction) + "%");
                    text.setFont(Font.font("Arial", FontWeight.BLACK, 14));
                    text.setFill(Color.BLACK);
                    text.setRotate(textAngle + 90);
                    root.getChildren().add(text);
                } else {
                    Text text = new Text(getTextX(textRadius, textAngle), getTextY(textRadius, textAngle), "Vide");
                    text.setFont(Font.font("Arial", FontWeight.BLACK, 14));
                    text.setFill(Color.BLACK);
                    text.setRotate(textAngle + 90);
                    root.getChildren().add(text);
                }

                textAngle += ARC_LENGTH;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Create a button to spin the wheel
        Circle rotateButton = new Circle(201, 197, 10);
        rotateButton.setOnMouseClicked(event -> {
            if (!rotateTransition.getStatus().equals(Animation.Status.RUNNING)) {
                rotateTransition.setByAngle(random.nextInt(360 * 5) + 360 * 5);
                rotateTransition.play();// Play the music when the animation starts
                 
                 
            }
        });
        root.getChildren().add(rotateButton);

        // Display the wheel in a scene
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a rotation transition for the wheel
        rotateTransition = new RotateTransition(Duration.seconds(2), root);
        rotateTransition.setByAngle(random.nextInt(360 * 5) + 360 * 5);
        rotateTransition.setOnFinished(event -> rotateTransition.stop());

        // Add a click event on the wheel to start the rotation transition
        root.setOnMouseClicked(event -> {
            if (!rotateTransition.getStatus().equals(Animation.Status.RUNNING)) {
                rotateTransition.setByAngle(random.nextInt(360 * 5) + 360 * 5);
                rotateTransition.play();
            }
        });
        
        //to stop the music
        rotateTransition.setOnFinished(event -> {
    rotateTransition.stop();
   // Stop the music when the animation stops
     // Display a message to the user indicating whether they have won or not
     
      // Determine which section of the wheel the arrow is pointing to
     // Determine which section of the wheel the arrow is pointing to
    double arrowAngle = root.getRotate() % 360;
    int sectionIndex = (int) Math.floor(arrowAngle / ARC_LENGTH);
      // Retrieve the taux_reduction value for the section from the database
   double taux_reduction = 0.0;
String code_coupon = "";

try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webuild3", "root", "");
    stmt = conn.prepareStatement("SELECT taux,code_coupon,type FROM coupon where type in ('simple','vip')  LIMIT ?, 1");

    stmt.setInt(1, sectionIndex);
    rs = stmt.executeQuery();

    if (rs.next()) {
        taux_reduction = rs.getDouble("taux");
        code_coupon = rs.getString("code_coupon");
        String couponType = rs.getString("type");

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("You've won a discount!");
        alert.setContentText("You've won a " + taux_reduction + "% discount !");
        String finalCodeCoupon = code_coupon;
        Button navigateButton = new Button("click here to see what you get");

        navigateButton.setOnAction(ok -> {
            try {
                if (couponType.equals("vip")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/vipshop.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } else if (couponType.equals("simple")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/qr.fxml"));
                    Parent root = loader.load();
                    QrController qrController = loader.getController();
                    qrController.setCodeCoupon(finalCodeCoupon);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add the navigate button to the alert dialog
        ((ButtonBar) alert.getDialogPane().lookup(".button-bar")).getButtons().add(navigateButton);
        alert.show();

    } else {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sorry!");
        alert.setHeaderText("Better luck next time!");
        alert.setContentText("Unfortunately, you didn't win this time.");
        alert.show();
    }

} catch (SQLException e) {
    e.printStackTrace();
} finally {
    try {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        
   });}
    /**
     * Calculates the X position of a text element at the specified radius and angle.
     */
    private double getTextX(double radius, double angle) {
        return 170 + radius * Math.cos(Math.toRadians(angle));
    }

    /**
     * Calculates the Y position of a text element at the specified radius and angle.
     */
    private double getTextY(double radius, double angle) {
        return 200 + radius * Math.sin(Math.toRadians(angle));
    } 
   public static void main(String[] args) {
        launch(args);
    }
}
