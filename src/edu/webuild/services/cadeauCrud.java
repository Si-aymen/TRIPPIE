/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class cadeauCrud {
    Connection cnx2;
  public cadeauCrud(){
        cnx2= MyConnection.getinstance().getcnx();
    }
  public void ajoutercadeau(){
        
        try {
            String requete="INSERT INTO cadeau (nom_cadeau,recurrence)"+ "values ('abonnement','10')" ;
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("cadeau  ajoutee aves success ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
  
  
  
   public void ajoutercadeau2(cadeau c){
       
        
        
        try { 
            String requete2="INSERT INTO cadeau (nom_cadeau,recurrence)"+ "values (?,?)" ;
            PreparedStatement pst = cnx2.prepareStatement(requete2);
               
             
         
         
          
               pst.setString(1,c.getNom_cadeau());
               
                pst.setInt(2,c.getRecurrence());
                
                
             
              pst.executeUpdate();
              System.out.println("votre cadeau est ajouteessss ");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
    
  }
   
   
   public List<cadeau> displayCadeau() {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau";
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id_cadeau");
            String nom = rs.getString("nom_cadeau");
            int recurrence = rs.getInt("recurrence");

            cadeau c = new cadeau(id, nom, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}


 public  int Supprimer(int id ){
          
        try {
             String requete4= "delete from cadeau where id_cadeau ='"+id+"'";   
            PreparedStatement pst = cnx2.prepareStatement(requete4);
             pst.executeUpdate(requete4);
            System.out.println("cadeau supprimer aves success ");
        } catch (SQLException ex) {
              System.err.println("ex.getMessge()");
        }
        return 0;
       
   } 
 public void modifier(cadeau c ){
       
       
          try {
        
        String requete = "UPDATE cadeau SET nom_cadeau=?,recurrence=? WHERE id_cadeau =?";
        PreparedStatement st = cnx2.prepareStatement(requete);
     
       
                st.setString(1,c.getNom_cadeau());
                
                 st.setInt(2,c.getRecurrence());
               
                st.setInt(3, c.getId_cadeau());
        st.executeUpdate();
        System.out.println("cadeau modifiée avec succès !");
        
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de la personne: " + ex.getMessage());
    
}
    }  
       

 /*public List<cadeau> filter(cadeau id1) {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau where id_cadeau ='"+id1+"'" ;
        Statement stmt = cnx2.createStatement();
        ResultSet rs1 = stmt.executeQuery(query);

        while (rs1.next()) {
            int id = rs1.getInt("id_cadeau");
            String nom = rs1.getString("nom_cadeau");
            int recurrence = rs1.getInt("recurrence");

            cadeau c = new cadeau(id, nom, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}*/
 

    

    
}
