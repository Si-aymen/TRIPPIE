/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author belkn
 */
public class MyConnection {

    private static Connection conn;  //DB Credations
    String url = "jdbc:mysql://localhost:3306/webuild2?zeroDateTimeBehavior=convertToNull";
    //String url = "jdbc:mysql://localhost:3306/webuild";
    String user = "root";
    String pwd = "";
    private static MyConnection instance;

    private MyConnection() {
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie!!!");
        } catch (SQLException ex) {
            System.out.println("Prebleme de connexion");
        }
    }

    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

    public Connection getConn() {
        return MyConnection.getInstance().conn;
    }

=======

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
   
   
>>>>>>> 9d50923a1a42e629ddfc92983077ffa5c623bbf0
}
