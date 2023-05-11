/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.model.cartefidelite;
import edu.webuild.model.AbonnementCarteFidelite;
import edu.webuild.utils.MyConnection;

import edu.webuild.interfaces.InterfaceCarte;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mtirn
 */
public class CartefideliteCRUD implements InterfaceCarte {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    @Override
    public void ajoutercarte(cartefidelite cf, int idA) {
      String query = "INSERT INTO cartefidelite(idA,pointMerci,dateExpiration) VALUES (?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idA);
            ps.setString(2, cf.getPointMerci());
            ps.setDate(3, Date.valueOf(cf.getDateExpiration().toString())); // convert LocalDate to java.sql.Date
           
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
            System.out.println("cartefidelite ajoutée!");
        } else {
            System.out.println("Erreur: cartefidelite non ajouté.");
        }

      
        } catch (SQLException ex) {

           System.out.println(ex.getMessage());
 

                      }
 }
     @Override
    public List<cartefidelite> affichercarte() {
       List<cartefidelite> list = new ArrayList<>();
        try {
            String req = "Select *from cartefidelite";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             cartefidelite cf = new cartefidelite();
                cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getDate(3));
                cf.setIdA(RS.getInt(4));
             
             list.add(cf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

  @Override
    public void supprimercarte(int id_cf) {
        try {
            String req = "DELETE FROM `cartefidelite` WHERE id_cf = " + id_cf;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("cartefidelite deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      @Override
public void modifiercarte(cartefidelite cf, int id_cf) {
    try {
        String req = "UPDATE `cartefidelite` SET `pointMerci` = ? WHERE `id_cf` = ?";
        PreparedStatement ps = conn.prepareStatement(req);
        ps.setString(1, cf.getPointMerci());
        ps.setInt(2, id_cf);
        ps.executeUpdate();
        System.out.println("Carte Fidelite updated!");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

    
    
    @Override
      public cartefidelite getUserByIDcf(int id_cf ) {
          cartefidelite cartefidelite=null;
       String query="SELECT *  FROM cartefidelite WHERE `id_cf`="+id_cf;
       try{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
      if (rs.next()) {
            cartefidelite = new cartefidelite();
            cartefidelite.setId_cf(rs.getInt("id_cf"));
            cartefidelite.setPointMerci(rs.getString("pointMerci"));
            cartefidelite.setDateExpiration(rs.getDate("dateExpiration")); 
           cartefidelite.setIdA(rs.getInt("idA"));

        }
       }
       catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
               
         
          
            
        
    return cartefidelite;
    }
      
         @Override
    public List<cartefidelite> triercarte() {
       List<cartefidelite> list = new ArrayList<>();
        try {
            String req = "Select * from cartefidelite order by pointMerci ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             cartefidelite cf = new cartefidelite();
             cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getDate(3));
                cf.setIdA(RS.getInt(4));
             
             list.add(cf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
     @Override
    public List<cartefidelite> Filter_carte(String S, String SS) {
        List<cartefidelite> list = new ArrayList<>();
        try {
            if (S.equals("id_cf") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `cartefidelite` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                 cartefidelite cf = new cartefidelite();
                cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getDate(3));
                cf.setIdA(RS.getInt(4));

                    list.add(cf);
                }
            } else {
                String req = "SELECT * FROM `cartefidelite` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                cartefidelite cf = new cartefidelite();
                  cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getDate(3));
                cf.setIdA(RS.getInt(4));
                    list.add(cf);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<AbonnementCarteFidelite> getAllCarteFideliteWithAbonnement() {
      
         List<AbonnementCarteFidelite> cartesFidelitesAbonnements = new ArrayList<>();
    String query = "SELECT * FROM abonnement JOIN cartefidelite ON abonnement.idA = cartefidelite.pointMerci";
    try (
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            int idA = rs.getInt("idA");
            String type = rs.getString("type");
            Date dateExpiration = rs.getDate("dateExpiration");
            Date dateAchat = rs.getDate("dateAchat");
            double prix = rs.getDouble("prix");
            int id_cf = rs.getInt("id_cf");
            int pointMerci = rs.getInt("pointMerci");
            
            AbonnementCarteFidelite cfa = new AbonnementCarteFidelite(idA, type, dateExpiration, dateAchat, prix, id_cf, pointMerci);
            cartesFidelitesAbonnements.add(cfa);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return cartesFidelitesAbonnements;
        
        
        
        
        
        
    }
  

    }

