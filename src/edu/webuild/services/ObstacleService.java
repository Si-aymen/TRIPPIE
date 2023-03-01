/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.model.Obstacle;
import java.util.ArrayList;
import java.util.List;
import edu.webuild.interfaces.InterfaceObstacleService;

/**
 *
 * @author mtirn
 */
public class ObstacleService implements InterfaceObstacleService {

    private Obstacle Obstacle;
    

    private final List<Obstacle> obstacles = new ArrayList<>();

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void removeObstacle(Obstacle obstacle) {
        obstacles.remove(obstacle);
    }
public Obstacle getObstacle()
{return Obstacle;}
}