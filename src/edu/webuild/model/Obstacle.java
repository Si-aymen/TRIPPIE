/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;
import javafx.scene.image.Image;

/**
 *
 * @author mtirn
 */
public class Obstacle {

    private double x; // the x-coordinate of the obstacle
    private double y; // the y-coordinate of the obstacle
    private double width; // the width of the obstacle
    private double height; // the height of the obstacle
    private Image image; // the image of the obstacle

    public Obstacle(double x, double y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public Obstacle() {
    }
    
    

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}