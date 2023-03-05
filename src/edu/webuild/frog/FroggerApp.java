/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.frog;


import java.sql.*;
import edu.webuild.utils.MyConnection;



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
    
    private Button startButton;
    private Button restartButton;


    //score system variable
    private long startTime;

    
    //a method that creates and returns the game's scene graph.
    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(800, 600);
        
        scoreText = new Text("Score: 0");
        scoreText.setFont(Font.font(24));
        scoreText.setFill(Color.BLACK);
        scoreText.setTranslateX(10);
        scoreText.setTranslateY(30);
        root.getChildren().add(scoreText);

        frog = initFrog();
        

        root.getChildren().add(frog);

         
        initRestartButton(); // Initialize the restart button
        
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
//        timer.start();

        return root;
    }
//a method that initializes the player's frog.
    private Node initFrog() {
        Rectangle rect = new Rectangle(38, 38, Color.GREEN);
        rect.setTranslateY(600 - 39);

        return rect;
    }

    //a method that creates a new car and adds it to the scene graph.
    private Node spawnCar() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        rect.setTranslateY((int)(Math.random() * 14) * 40);

        root.getChildren().add(rect);
        return rect;
    }

    
    //a method that updates the game state on each frame.
    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX() + Math.random() * 15);

        if (Math.random() < 0.0375) {
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
            startButton.setDisable(true); // Disable the start button
            return;
        }
    }

    if (frog.getTranslateY() <= 0) {
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
        highScoreText.setFill(Color.BLACK);
        highScoreText.setTranslateX(10);
        highScoreText.setTranslateY(60);
        root.getChildren().add(highScoreText);
        
        // Stop the timer and display the win message
        timer.stop();
        restartButton.setDisable(false);
        startButton.setDisable(true);
        String win = "YOU WIN";
        Text winText = new Text(win);
        winText.setFont(Font.font(48));
        winText.setTranslateX(300);
        winText.setTranslateY(250);
        winText.setOpacity(0);
        root.getChildren().add(winText);
        FadeTransition ft = new FadeTransition(Duration.seconds(2), winText);
        ft.setToValue(1);
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
    //START
//private void initStartButton() {
//    startButton = new Button("Start");
//    //This event handler should start the game by calling the timer.start() method.
//    startButton.setOnAction(event -> {
//        timer.start();
//    });
//
//    HBox hBox = new HBox();
//    hBox.setTranslateX(600);
//    hBox.setTranslateY(30);
//    hBox.getChildren().add(startButton);
//
//    root.getChildren().add(hBox);
//}
    
    //RESTART
private void initRestartButton() {
    restartButton = new Button("Restart");
    restartButton.setOnAction(event -> {
        resetGame();
    });

    HBox hBox = new HBox();
    hBox.setTranslateX(600);
    hBox.setTranslateY(60);
    hBox.getChildren().add(restartButton);

    root.getChildren().add(hBox);
    
}
               //----reset----
private void resetGame() {
    cars.clear();
    score = 0;
    scoreText.setText("Score: " + score);
    frog.setTranslateX(0);
    frog.setTranslateY(600 - 39);
    timer.start();
    restartButton.setDisable(true);
    startButton.setDisable(false);
}


    public static void main(String[] args) {
        launch(args);
    }
}