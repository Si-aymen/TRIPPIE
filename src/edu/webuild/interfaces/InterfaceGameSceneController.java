package edu.webuild.interfaces;

public interface InterfaceGameSceneController extends InterfaceCarService, InterfaceObstacleService, InterfaceScore {
    void initialize();
    void startGame();
    void pauseGame();
    void restartGame();
    void moveRight();
    void jump();
    void checkCollision();
    void updateObstaclePosition();
    void spawnObstacle();
    void updateCanvas();
    void gameLoop();
}
