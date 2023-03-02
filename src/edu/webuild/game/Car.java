package edu.webuild.game;

import edu.webuild.interfaces.InterfaceCarService;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car implements InterfaceCarService {

    private double speed;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    private Rectangle carRectangle;
    private boolean isJumping;

    public Car(double speed, double positionX, double positionY, double width, double height) {
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.carRectangle = new Rectangle(positionX, positionY, width, height);
        this.carRectangle.setFill(Color.BLUE);
    }

    @Override
    public void moveRight() {
        this.positionX += this.speed;
        this.carRectangle.setX(this.positionX);
    }

    @Override
    public void jump() {
        final double originalY = this.positionY;
        final double jumpHeight = 100;
        final double jumpDuration = 0.5; // seconds
        final long startTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double elapsedSeconds = (currentNanoTime - startTime) / 1_000_000_000.0;
                double fractionComplete = elapsedSeconds / jumpDuration;
                if (fractionComplete >= 1.0) {
                    carRectangle.setY(originalY);
                    stop();
                    isJumping = false;
                } else {
                    double yOffset = jumpHeight * 4 * (fractionComplete - fractionComplete * fractionComplete);
                    carRectangle.setY(originalY - yOffset);
                }
            }
        }.start();
        isJumping = true;
    }

    public Rectangle getCarRectangle() {
        return carRectangle;
    }
}
