/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.abonnement;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import edu.webuild.interfaces.InterfaceAbonnement;


/**
 *
 * @author mtirn
 */
public class AbonnementCRUD implements InterfaceAbonnement{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    
    @Override
    public void ajouterabonnement(abonnement A) {
        String query = "INSERT INTO abonnement (type, dateExpiration, dateAchat, prix) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
          
            ps.setString(1, A.getType());
            ps.setDate(2, Date.valueOf(A.getDateExpiration().toString())); // convert LocalDate to java.sql.Date
            ps.setDate(3, Date.valueOf(A.getDateAchat().toString())); // convert LocalDate to java.sql.Date
            ps.setInt(4, A.getPrix());
            int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Abonnement ajoutée!");
        } else {
            System.out.println("Erreur: Abonnement non ajouté.");
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void modifierabonnement(abonnement A, int idA) {
        try {
            String req = "UPDATE `abonnement` SET `type` = ?, `dateExpiration` = ?, `dateAchat` = ?, `prix` = ? WHERE `idA` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, A.getType());
            ps.setDate(2, Date.valueOf(A.getDateExpiration().toString())); // convert LocalDate to java.sql.Date
            ps.setDate(3, Date.valueOf(A.getDateAchat().toString())); // convert LocalDate to java.sql.Date
            ps.setInt(4, A.getPrix());
            ps.setInt(5, idA);
            ps.executeUpdate();
            System.out.println(" updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public void supprimerabonnement(int idA) {
        try {
            String req = "DELETE FROM `abonnement` WHERE idA = " + idA;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<abonnement> afficherabonnement() {
       List<abonnement> list = new ArrayList<>();
        try {
        String req = "SELECT type, prix, dateAchat, dateExpiration FROM abonnement";
        Statement st = conn.createStatement();
        ResultSet RS = st.executeQuery(req);
        while (RS.next()) {
            abonnement A = new abonnement();
            A.setType(RS.getString(1));
            A.setPrix(RS.getInt(2));
            A.setDateAchat(RS.getDate(3));
            A.setDateExpiration(RS.getDate(4));
            list.add(A);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
        return list;
    }
    
    
    @Override
     public abonnement getUserByID(int idA) {
      abonnement abonnement = null;
    String query = "SELECT * FROM abonnement WHERE idA=" + idA;
    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            abonnement = new abonnement();
            abonnement.setIdA(rs.getInt("idA"));
            abonnement.setType(rs.getString("type"));
            abonnement.setPrix(rs.getInt("prix"));
            abonnement.setDateAchat(rs.getDate("dateAchat")); 
            abonnement.setDateExpiration(rs.getDate("dateExpiration")); 
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return abonnement;
}

      
      
       @Override
    public List<abonnement> trierabonnement() {
       List<abonnement> list = new ArrayList<>();
        try {
            String req = "Select * from abonnement order by Prix ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
              abonnement A = new abonnement();
             A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                                A.setPrix(RS.getInt(3));
                A.setDateAchat(RS.getDate(4));    

                A.setDateExpiration(RS.getDate(5));
             
             list.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
   
   @Override
    public List<abonnement> Filter_abonnement(String S, String SS) {
        List<abonnement> list = new ArrayList<>();
        try {
            if (S.equals("idA") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `abonnement` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    abonnement A = new abonnement();
                 A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setPrix(RS.getInt(3));
                A.setDateAchat(RS.getDate(4));    

                A.setDateExpiration(RS.getDate(5));

                    list.add(A);
                }
            } else {
                String req = "SELECT * FROM `abonnement` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                 abonnement A = new abonnement();
                 A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setPrix(RS.getInt(3));

                A.setDateExpiration(RS.getDate(4));
                A.setDateAchat(RS.getDate(5));    

                    list.add(A);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

 
    
}
