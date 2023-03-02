package edu.webuild.game;

import edu.webuild.interfaces.InterfaceScore;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Score implements InterfaceScore {
    private int idScore;
    private int playerId;
    private int score;
    private int highestScore;

    public Score(int idScore, int playerId, int score, int highestScore) {
        this.idScore = idScore;
        this.playerId = playerId;
        this.score = score;
        this.highestScore = highestScore;
    }

    public Score(int playerId, int score, int highestScore) {
        this.playerId = playerId;
        this.score = score;
        this.highestScore = highestScore;
    }

    public Score() {
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

   @Override
public void updateScore(boolean hitObstacle) {
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    if (!hitObstacle) {
        score++;
    } else {
        // Game over
        try {
            
                String req = "UPDATE scores SET score = ?, highest_score = ? WHERE id_score = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            
            ps.setInt(1, score);
            if (score > highestScore) {
                ps.setInt(2, score);
                highestScore = score;
            } else {
                ps.setInt(2, highestScore);
            }
            ps.setInt(3, idScore);
            ps.executeUpdate();
            System.out.println("Score updated in the database");
        } catch (SQLException ex) {
            System.out.println("Error updating score in the database: " + ex.getMessage());
        }
    }
}}
