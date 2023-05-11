/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.abonnement;
import edu.webuild.utils.MyConnection;
import edu.webuild.model.cartefidelite;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import edu.webuild.interfaces.InterfaceAbonnement;
import java.time.LocalDate;

/**
 *
 * @author mtirn
 */
public class AbonnementCRUD implements InterfaceAbonnement{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    
    @Override
public void ajouterabonnement(abonnement A) {
    try {
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO abonnement (type, prix, dateAchat, dateExpiration) VALUES (?, ?, ?, ?)", 
            Statement.RETURN_GENERATED_KEYS
        );
        // Set values for the insert statement
        ps.setString(1, A.getType());
        ps.setInt(2, A.getPrix());
        LocalDate today = LocalDate.now();
        ps.setDate(3, Date.valueOf(today)); // set dateAchat to today's date
        LocalDate expirationDate = today.plusYears(1);
        ps.setDate(4, Date.valueOf(expirationDate)); // set dateExpiration to 1 year + dateAchat
        
        // Execute the insert statement
        int affectedRows = ps.executeUpdate();
        System.out.println("Abonnement ajoutée!");

        if (affectedRows == 0) {
            throw new SQLException("Creating abonnement failed, no rows affected.");
        }

        // get the generated idA value
        ResultSet rs = ps.getGeneratedKeys();
        int idA = 0;
        if (rs.next()) {
            idA = rs.getInt(1);
        }

        // create a new cartefidelite record with 0 pointMerci
        CartefideliteCRUD cartefideliteCRUD = new CartefideliteCRUD();
        cartefidelite cartefidelite = new cartefidelite();
        cartefidelite.setPointMerci("0");
        cartefidelite.setDateExpiration(Date.valueOf(expirationDate)); // set expiration date
        cartefideliteCRUD.ajoutercarte(cartefidelite,idA);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

  @Override
public void modifierabonnement(int idA, abonnement A) {
    try {
        String req = "UPDATE `abonnement` SET `type` = ?, `prix` = ? WHERE `idA` = ?";
        PreparedStatement ps = conn.prepareStatement(req);
        ps.setString(1, A.getType());
        ps.setInt(2, A.getPrix());
        ps.setInt(3, idA);
        ps.executeUpdate();
        System.out.println("Abonnement updated!");
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
            // Delete associated cartefidelite record
        CartefideliteCRUD cartefideliteCRUD = new CartefideliteCRUD();
        cartefideliteCRUD.supprimercarte(idA);
       // System.out.println("cartefidelite deleted !");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<abonnement> afficherabonnement() {
       List<abonnement> list = new ArrayList<>();
        try {
        String req = "SELECT idA, type, prix, dateAchat, dateExpiration FROM abonnement";

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
                A.setDateAchat(RS.getDate(4));    

                A.setDateExpiration(RS.getDate(5));

                    list.add(A);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  
public AbonnementCRUD(Connection conn)
{

this.conn=conn;
}

    public AbonnementCRUD() {
       
    }

    
}
