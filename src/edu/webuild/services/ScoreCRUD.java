/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.model.score;
import java.sql.Connection;
import edu.webuild.interfaces.interfaceScore;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtirn
 */
public class ScoreCRUD implements interfaceScore{
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

//    @Override
//    public void addScore(score s) {
//     
//        
//   
//    
//              try{
//                  PreparedStatement ps = conn.prepareStatement("INSERT INTO score (playerId, score, date) VALUES (?, ?, NOW())");
//           
//            ps.setInt(1, s.getPlayerId());
//            ps.setInt(2, s.getScore());
//            ps.executeUpdate();
//        }
//              catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        
//        
//        }
        // whenever the user hit a new sccore the score will be updated 
    
    
    
       @Override
public int getScore(int playerId) {
    int score = 0;
    try {
        PreparedStatement ps = conn.prepareStatement("SELECT score FROM score WHERE playerId = ?");
        ps.setInt(1, playerId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            score = rs.getInt("score");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return score;}




    @Override
public void updateScore(score s) {
    try {
        PreparedStatement ps = conn.prepareStatement("UPDATE score SET score = ?, date = NOW() WHERE playerId = ?");
        ps.setInt(1, s.getScore());
        ps.setInt(2, s.getPlayerId());
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

     
}

        
        
        
        
        
   
    
    
    
    

