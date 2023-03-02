package edu.webuild.interfaces;

import javafx.scene.shape.Rectangle;

public interface InterfaceObstacleService {
    void addObstacle(double x, double y);
    boolean checkCollision(Rectangle obstacle);
}
