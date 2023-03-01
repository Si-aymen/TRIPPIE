/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.Car;
import edu.webuild.services.CarService;

/**
 *
 * @author mtirn
 */

public interface InterfaceCarService{
void moveCar(int distance);

    void jumpCar();

    void resetCar();

    boolean isCollision(double obstacleX, double obstacleY, double obstacleWidth, double obstacleHeight);
Car getCar();
}
