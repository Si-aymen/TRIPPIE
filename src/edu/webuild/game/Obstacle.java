package edu.webuild.game;

import edu.webuild.interfaces.InterfaceObstacleService;
import javafx.scene.shape.Rectangle;

public class Obstacle implements InterfaceObstacleService {

    private Rectangle obstacle;

    public Obstacle() {
        obstacle = new Rectangle(50, 50, 30, 30);
        obstacle.setFill(javafx.scene.paint.Color.RED);
    }

    @Override
    public void addObstacle(double x, double y) {
        obstacle.setX(x);
        obstacle.setY(y);
    }

    @Override
    public boolean checkCollision(Rectangle obstacle) {
        return obstacle.getBoundsInParent().intersects(obstacle.getBoundsInParent());
    }

    public Rectangle getObstacle() {
        return obstacle;
    }
}
