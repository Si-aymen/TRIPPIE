package edu.webuild.game;


import edu.webuild.interfaces.InterfaceScore;
import edu.webuild.interfaces.InterfaceGameSceneController;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;



public class GameSceneController implements InterfaceGameSceneController {

    @FXML
    private Canvas canvas;

    @FXML
    private Button startButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button restartButton;
    @FXML
    private Button playAgainButton;

    @FXML
    private Label scoreLabel;
  

    private AnimationTimer gameLoop;

    private boolean gamePaused;

    private boolean gameStarted;

    private Rectangle car;

    private Rectangle obstacle;

    private int score;

    private InterfaceScore scoreService;

    private double obstacleXPosition;

    private double obstacleWidth;

    private double carXPosition;

    private double carYPosition;

    private double carWidth;

    private double obstacleHeight;

    private double carHeight;

    private double obstacleYPosition;

    private double carSpeed;

    private double obstacleSpeed;

    private boolean isJumping;

    private boolean hasCollided;
   private ObservableList<Node> obstacles;


@Override
    public void initialize() {
        car = new Rectangle(50, 400, 40, 20);
        car.setFill(Color.BLUE);
        obstacle = new Rectangle(0, 0, 0, 0);
        obstacle.setFill(Color.RED);
        
      obstacles = canvas.getChildren().filtered(node -> node.getStyleClass().contains("obstacle"));
for (Node obstacle : obstacles) {
        obstacle.setUserData("obstacle");
    }
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gamePaused = true;
        gameStarted = false;
        score = 0;
        scoreLabel.setText("Score: " + score);
        carXPosition = car.getX();
        carYPosition = car.getY();
        carWidth = car.getWidth();
        carHeight = car.getHeight();
        obstacleXPosition = canvas.getWidth() - 50;
        obstacleYPosition = canvas.getHeight() - 30;
        obstacleWidth = 30;
        obstacleHeight = 30;
        carSpeed = 5;
        obstacleSpeed = 3;
        isJumping = false;
        hasCollided = false;
        startButton.setOnAction(event -> startGame());
        pauseButton.setOnAction(event -> pauseGame());
        restartButton.setOnAction(event -> restartGame());
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                moveRight();
            }
            if (event.getCode() == KeyCode.SPACE) {
                jumpCar();
            }
        });
        scoreService = new Score();
    }
    @Override
public ObservableList<Node> obstacles() {
    return obstacles;
}
    
@Override
    public void pauseGame() {
        gamePaused = true;
    }
@Override
    public void restartGame() {
        gameStarted = false;
        gamePaused = true;
        score = 0;
        scoreLabel.setText("Score: " + score);
        hasCollided = false;
        obstacle.setWidth(0);
        obstacle.setHeight(0);
        car.setX(50);
        obstacleXPosition = canvas.getWidth() - 50;
        obstacleYPosition = canvas.getHeight() - 30;
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    @Override
public void moveRight() {
    car.setX(car.getX() + carSpeed);
}



    @Override
    public void jump() {
        jumpCar();
    }
public void jumpCar() {
        if (!isJumping) {
            isJumping = true;
            final double originalY = car.getY();
            final double jumpHeight = 100;
            final double jumpDuration = 0.5; // seconds
            final long startTime = System.nanoTime();
            Timeline jumpAnimation = new Timeline(new KeyFrame(Duration.seconds(jumpDuration), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    double elapsedSeconds = (System.nanoTime() - startTime) / 1_000_000_000.0;
                    double fractionComplete = elapsedSeconds / jumpDuration;
                    if (fractionComplete >= 1.0) {
                        car.setY(originalY);
                        isJumping = false;
                    } else {
                        double yOffset = jumpHeight * 4 * (fractionComplete - fractionComplete * fractionComplete);
                        car.setY(originalY - yOffset);
                    }
                }
            }));
            jumpAnimation.setCycleCount(1);
            jumpAnimation.play();
        }
    }
   @Override
public void addObstacle(double x, double y) {
    obstacle.setX(x);
    obstacle.setY(y);
}


    public void updateScore(boolean hitObstacle) {
    score++;
    scoreLabel.setText("Score: " + score);
    scoreService.updateScore(hitObstacle);
}
@Override
    public void checkCollisions() {
    for (Node obstacle : obstacles) {
        if (car.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
            gameOver();
            return;
        }
    }
    score++;
    scoreLabel.setText("Score: " + score);
}
@Override
    public void gameOver() {
        pauseGame();
        saveScore();
        scoreLabel.setText("Game Over. Score: " + score);
        playAgainButton.setVisible(true);
    }
@Override
public void saveScore() {
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    String query = "INSERT INTO scores (score) VALUES (?)";
    try {
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, score);
        statement.executeUpdate();
    } catch (SQLException ex) {
        System.err.println("Error updating score in the database: " + ex.getMessage());
    }
}
@Override
    public void updateObstaclePosition() {
        obstacleXPosition -= obstacleSpeed;
        obstacle.setX(obstacleXPosition);
    }
@Override
    public void spawnObstacle() {
        if (obstacle.getWidth() <= 0) {
            obstacle.setWidth(obstacleWidth);
            obstacle.setHeight(obstacleHeight);
            obstacleXPosition = canvas.getWidth() - 50;
            obstacleYPosition = canvas.getHeight() - obstacle.getHeight() - 5;
            obstacle.setX(obstacleXPosition);
            obstacle.setY(obstacleYPosition);
            updateScore(true); // pass true if obstacle is hit, false otherwise
        }
    }
@Override
    public void updateCanvas() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.getGraphicsContext2D().setFill(Color.BLUE);
        canvas.getGraphicsContext2D().fillRect(car.getX(), car.getY(), car.getWidth(), car.getHeight());
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
    }
  @Override
public boolean checkCollision(Rectangle obstacle) {
    return car.getBoundsInParent().intersects(obstacle.getBoundsInParent());
}

@Override
    public void gameLoop() {
        updateObstaclePosition();
        spawnObstacle();
        checkCollisions();
        updateCanvas();
    }
    @Override
    public void start() {
    gameLoop = new AnimationTimer() {
        @Override
        public void handle(long now) {
            gameLoop();
        }
    };
    gameLoop.start();
}

    
    
    
@Override
    public void startGame() {
        gameStarted = true;
        gamePaused = false;
        start();
    }

}
