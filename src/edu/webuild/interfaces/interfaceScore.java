/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.score;

public interface interfaceScore {
    
//    public void addScore(score s);
   public int getScore(int playerId) ;
    public void updateScore(score s);

}
