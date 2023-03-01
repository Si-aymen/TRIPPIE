/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author mtirn
 */
public class Car {
    
private double x; // the x-coordinate of the car
private double y; // the y-coordinate of the car
private double speed; // the speed of the car

    public Car(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Car() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

public javafx.scene.image.Image getImage() {
    java.net.URL imageUrl = getClass().getResource("/edu/webuild/resources/car.png");
    javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toString());
    return image;
}

}
