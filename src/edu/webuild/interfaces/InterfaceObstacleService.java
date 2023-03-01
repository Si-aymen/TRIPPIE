/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.Obstacle;
import edu.webuild.services.ObstacleService;

/**
 *
 * @author mtirn
 */
import edu.webuild.model.Obstacle;
import java.util.List;

public interface InterfaceObstacleService {

    void addObstacle(Obstacle obstacle);

    List<Obstacle> getObstacles();

    void removeObstacle(Obstacle obstacle);
Obstacle getObstacle();
}