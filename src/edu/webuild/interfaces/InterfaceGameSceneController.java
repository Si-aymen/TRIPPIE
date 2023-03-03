package edu.webuild.interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public interface InterfaceGameSceneController extends InterfaceCarService, InterfaceObstacleService, InterfaceScore {
    
    
      public  ObservableList<Node> obstacles();
    
    void initialize();
    
    void pauseGame();
    void restartGame();
    void moveRight();
    void jump();
  
    void checkCollisions();
    
    void gameOver() ;
    void saveScore();
    void updateObstaclePosition();
    void spawnObstacle();
    void updateCanvas();
   public boolean checkCollision(Rectangle obstacle);

    void gameLoop();
    void start();

    void startGame();
}
