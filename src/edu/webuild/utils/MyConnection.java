/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class MyConnection {
     public String url ="jdbc:mysql://localhost:3306/promotion";
    
     public String login  ="root";
      public String password ="";
   Connection cnx;
   public static MyConnection instance;
   
         public MyConnection() {
        try {
           cnx= DriverManager.getConnection(url, login, password);
           System.out.println("connection etablie !!! ");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
           
      }
             public Connection getcnx(){
         return cnx;
    }
    public static MyConnection getinstance(){
        if(instance==null){
            instance= new MyConnection();
        }
        return instance;
    }
   
   
}
