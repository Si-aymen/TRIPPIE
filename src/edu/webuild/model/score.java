/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.util.Date;

/**
 *
 * @author mtirn
 */
public class score {
   private int  idScore;
   private int playerId;
   private int score;
   private Date date;

    public score(int idScore, int playerId, int score, Date date) {
        this.idScore = idScore;
        this.playerId = playerId;
        this.score = score;
        this.date = date;
    }

    public score(int playerId, int score, Date date) {
        this.playerId = playerId;
        this.score = score;
        this.date = date;
    }

    public score(int score, Date date) {
        this.score = score;
        this.date = date;
    }

    public score() {
    }

    public int getIdScore() {
        return idScore;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "score{" + "playerId=" + playerId + ", score=" + score + ", date=" + date + '}';
    }
   
   
   
    
}
