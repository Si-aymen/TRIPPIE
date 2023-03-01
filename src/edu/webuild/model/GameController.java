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
public class GameController {
private Car car; // the car object
private Obstacle obstacle; // the obstacle object
private int score; // the player's score
private boolean isGameOver; // whether the game is over

    public GameController(Car car, Obstacle obstacle, int score, boolean isGameOver) {
        this.car = car;
        this.obstacle = obstacle;
        this.score = score;
        this.isGameOver = isGameOver;
    }

    public GameController() {
    }

    public Car getCar() {
        return car;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public int getScore() {
        return score;
    }

    public boolean isIsGameOver() {
        return isGameOver;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
    










}
