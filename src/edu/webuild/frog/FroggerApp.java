/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.frog;


import java.sql.*;
import edu.webuild.utils.MyConnection;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;



import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mtirn
 */
public class FroggerApp extends Application {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    
//an AnimationTimer object that is used to update
//the game state and handle animation.
    private AnimationTimer timer;

    private Pane root;
//Node for the game's scene graph.
    private List<Node> cars = new ArrayList<>();
    private Node frog;
    private int score = 0;
    private Text scoreText;
    
    // Right here m gonna declare buttons variable
    
    //Back button
     private Button backToMenuButton;
    
    
    
    
//    private Button startButton;
    private Button restartButton;


    //score system variable
    private long startTime;

    
    //a method that creates and returns the game's scene graph.
    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(1050, 600); //Screen size
        //add background image
		try(InputStream is = Files.newInputStream(Paths.get("src/edu/webuild/resources/bg.png"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			root.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
        
        scoreText = new Text("Score: 0");
        scoreText.setFont(Font.font(24));
        scoreText.setFill(Color.BLACK);
        scoreText.setTranslateX(500);
        scoreText.setTranslateY(30);
        root.getChildren().add(scoreText);

        frog = initFrog();
        

        root.getChildren().add(frog);
initBackToMenuButton(); // Initialize the back to menu button
         
        initRestartButton(); // Initialize the restart button
        
        
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
       timer.start();

        return root;
    }
//a method that initializes the player's frog.
    private Node initFrog() {
        Rectangle rect = new Rectangle(38, 38, Color.GREEN);
        rect.setTranslateY(600 - 38);

        return rect;
    }

    //a method that creates a new car and adds it to the scene graph.
   private Node spawnCar() {
    Rectangle rect = new Rectangle(40, 40, Color.RED);
    double middleY = (400 + 90 - 40) / 2.0; // calculate the middle of the restricted range
    rect.setTranslateY((int)(Math.random() * 200) + middleY); // set y-coordinate
    root.getChildren().add(rect);
    return rect;
}



    
    //a method that updates the game state on each frame.
    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX() + Math.random() * 15);

        if (Math.random() < 0.0075) { //speed
            cars.add(spawnCar());
        }

        checkState();
    }

    //a method that checks if the game is over and handles the end of the game.
   private void checkState() {
    for (Node car : cars) {
        if (car.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            frog.setTranslateX(0);
            frog.setTranslateY(600 - 39);
            restartButton.setDisable(false); // Enable the restart button

   timer.stop();
    String win = "YOU LOST";
    Text winText = new Text(win);
        winText.setFont(Font.font(48));
        winText.setTranslateX(300);
        winText.setTranslateY(250);
        winText.setOpacity(0);
        root.getChildren().add(winText);
        FadeTransition ft = new FadeTransition(Duration.seconds(1), winText);
         ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
            return;
        }
    }

    if (frog.getTranslateY() <= 180) {
        // Calculate the elapsed time in seconds
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        
        // Calculate the score based on the elapsed time
        int timeScore = (int)(1000 - elapsedTime * 10);
        if (timeScore < 0) {
            timeScore = 0;
        }
        score += timeScore;
        scoreText.setText("Score: " + score);
        
        // Update high score if necessary
        int currentHighScore = getHighScore();
        if (score > currentHighScore) {
            updateHighScore(score);
            currentHighScore = score;
        }
        
        // Display high score
        Text highScoreText = new Text("High Score: " + currentHighScore);
        highScoreText.setFont(Font.font(24));
        highScoreText.setFill(Color.BLUE);
        highScoreText.setTranslateX(460);
        highScoreText.setTranslateY(80);
        root.getChildren().add(highScoreText);
        
        // Stop the timer and display the win message
        timer.stop();
        restartButton.setDisable(false);
//        startButton.setDisable(true);
        String win = "YOU WIN";
        Text winText = new Text(win);
        winText.setFont(Font.font(48));
        winText.setTranslateX(300);
        winText.setTranslateY(250);
        winText.setOpacity(0);
        root.getChildren().add(winText);
        FadeTransition ft = new FadeTransition(Duration.seconds(2), winText);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
    }
}

//a method that sets up the game's scene and starts the AnimationTimer.
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setScene(new Scene(createContent()));
        // Set the starting time to the current time
    startTime = System.currentTimeMillis();

        stage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: 
                    frog.setTranslateY(frog.getTranslateY() - 40);
                    break;
                case DOWN:
                    frog.setTranslateY(frog.getTranslateY() + 40);
                    break;
                case LEFT:
                    frog.setTranslateX(frog.getTranslateX() - 40);
                    break;
                case RIGHT:
                    frog.setTranslateX(frog.getTranslateX() + 40);
                    break;
                default:
                    break;
            }
        });

        stage.show();
    }
    public void updateHighScore(int score) {
    try {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO highscores (score) VALUES (?)");
        ps.setInt(1, score);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public int getHighScore() {
        int highScore = 0;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(score) FROM highscores");
            if (rs.next()) {
                highScore = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highScore;
    }
    
    //Buttons methods
  
    //RESTART
private void initRestartButton() {
    
    restartButton = new Button("Restart");
    restartButton.setStyle(
            "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    
   restartButton.setOnMouseEntered(e -> {
   restartButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});
    

restartButton.setOnMouseExited(e -> {
   restartButton.setStyle( "-fx-background-color: #6143F7; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});

restartButton.setOnMouseEntered(e -> {
restartButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});
    restartButton.setOnAction(event -> {
        resetGame();
    });

    HBox hBox = new HBox();
    hBox.setTranslateX(900);
    hBox.setTranslateY(10);
    hBox.getChildren().add(restartButton);
         restartButton .setStyle("-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");


    root.getChildren().add(hBox);
    
}
               //----reset----
private void resetGame() {

    score = 0;
    scoreText.setText("Score: " + score);
    frog.setTranslateX(0);
    frog.setTranslateY(600 - 39);
    timer.start();
    restartButton.setDisable(true);
  
  
    
}
//BACK TO MENU
    private void initBackToMenuButton() {
       
        backToMenuButton = new Button("Back to Menu");

    backToMenuButton.setStyle(
        "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
        + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;"
    );

        backToMenuButton.setStyle(
                "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
                        + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");

        backToMenuButton.setOnMouseEntered(e -> {
            backToMenuButton.setStyle("-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
        });

        backToMenuButton.setOnMouseExited(e -> {
            backToMenuButton.setStyle("-fx-background-color: #6143F7; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
        });

        backToMenuButton.setOnAction(event -> {
            // Switch to the main menu scene
            Menu mainMenuApp = new Menu();
            Stage stage = (Stage) backToMenuButton.getScene().getWindow();
            try {
                mainMenuApp.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        HBox hBox = new HBox();
        hBox.setTranslateX(70);
    hBox.setTranslateY(20);
        hBox.getChildren().add(backToMenuButton);

        root.getChildren().add(hBox);
    }
  


    public static void main(String[] args) {
        launch(args);
    }
}