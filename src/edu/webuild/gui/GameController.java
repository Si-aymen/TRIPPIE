package edu.webuild.gui;

import edu.webuild.model.Car;
import edu.webuild.model.Obstacle;
import edu.webuild.services.CarService;
import edu.webuild.interfaces.InterfaceCarService;
import edu.webuild.interfaces.InterfaceObstacleService;
import edu.webuild.services.ObstacleService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private Label scoreLabel;

    @FXML
    private ImageView carImage;

    private Pane gamePane;
    private InterfaceCarService carService;
    private InterfaceObstacleService obstacleService;
    private int score;
    
       private void checkCollision() {
        Obstacle obstacle = obstacleService.getObstacle();
        if (carService.isCollision(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight())) {
            carService.resetCar();
            score = 0;
            scoreLabel.setText("Score: " + score);
        } else {
            score++;
            scoreLabel.setText("Score: " + score);
        }
       }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gamePane = new Pane();
        root.getChildren().add(gamePane);

        Car car = new Car(0, 250, 5);
        carService = new CarService(car);

        carImage.setImage(carService.getCar().getImage());

        obstacleService = new ObstacleService();

        Timeline moveCarTimeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            carService.moveCar(1);
            checkCollision();
        }));
        moveCarTimeline.setCycleCount(Timeline.INDEFINITE);
        moveCarTimeline.play();

    }
    
    }
    