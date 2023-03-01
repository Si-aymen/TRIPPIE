/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.interfaces.InterfaceCarService;
import edu.webuild.model.Car;

/**
 *
 * @author mtirn
 */

import edu.webuild.interfaces.InterfaceCarService;
import edu.webuild.model.Car;
import java.util.Random;
public class CarService implements InterfaceCarService {

    private Car car;
    
    //The CarService class provides the functionality needed to move the Car object across the screen, jump the Car object over obstacles, reset the Car object to its initial position, and detect collisions between the Car object and Obstacle objects.

    public CarService(Car car) {
        this.car = car;
    }
//update the position of the Car object based on its current speed.
    @Override
    public void moveCar(int distance) {
    double newX = car.getX() + distance * car.getSpeed();
    car.setX(newX);
}

//change the y coordinate of the Car object to simulate a jump.
    @Override
    public void jumpCar() {
        Random rand = new Random();
        double newY = rand.nextDouble() * 100 + 50;
        car.setY(newY);
    }
//reset the x and y coordinates of the Car object to their default values.
    @Override
    public void resetCar() {
        car.setX(0);
        car.setY(250);
        car.setSpeed(5);
    }
//determine if there is a collision between the Car object and the Obstacle object by comparing their coordinates and dimensions. If there is a collision, return true, otherwise return false.
    @Override
    public boolean isCollision(double obstacleX, double obstacleY, double obstacleWidth, double obstacleHeight) {
        if (car.getX() + 50 >= obstacleX && car.getX() <= obstacleX + obstacleWidth) {
            if (car.getY() <= obstacleY + obstacleHeight) {
                return true;
            }
        }
        return false;
    }
@Override
    public Car getCar() {
        return car;
    }
}