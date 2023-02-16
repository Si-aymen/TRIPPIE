/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceAbonnementCRUD;
import edu.webuild.model.Abonnement;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mtirn
 */
public class AbonnementCRUD implements InterfaceAbonnementCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
    @Override
    public void ajouterAbonnement(Abonnement A) {
        try {
            String req = "INSERT INTO `Abonnement`( `type`,`prix`, `dateAchat`, `dateExpiration`) VALUES ('"+A.getType()+"','"+A.getPrix()+"','"+A.getDateAchat()+"','"+A.getDateExpiration()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Abonnement ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Abonnement non ajouté");
                      }
 }
 
    @Override
    public void modifierAbonnement(Abonnement A) {
        try {
            String req = "UPDATE `Abonnement` SET `type` = '"+A.getType()+"','"+A.getPrix()+"','"+A.getDateAchat()+"','"+A.getDateExpiration()+"' WHERE `Abonnement`.`id` = " + A.getIdA();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Abonnement updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  @Override
    public void supprimerAbonnement(int idA) {
        try {
            String req = "DELETE FROM `Abonnement` WHERE idA = " + idA;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Abonnement deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterAbonnement2(Abonnement A) {
 try {
            String req = "INSERT INTO `Abonnement` (`type`, `prix`,`dateAchat`,`dateExpiration`) VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, A.getType());
            ps.setString(2, A.getPrix());
            ps.setString(3, A.getDateAchat());
            ps.setString(4, A.getDateExpiration());
             ps.executeUpdate();
            System.out.println("Abonnement ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
    }

    @Override
    public List<Abonnement> afficherAbonnement() {
       List<Abonnement> list = new ArrayList<>();
        try {
            String req = "Select * from Abonnement";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Abonnement A = new Abonnement();
             A.setType(RS.getString(2));
             A.setPrix(RS.getString(3));
             A.setDateAchat(RS.getString(4));
             A.setDateExpiration(RS.getString(5));
             A.setIdA(RS.getInt(1));
             list.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Abonnement> rechAbonnement(int idA) {
        List<Abonnement> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Abonnement` WHERE idA= " + idA;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Abonnement Ab = new Abonnement();
               Ab.setType(RS.getString("type"));
             Ab.setPrix(RS.getString("prix"));
             Ab.setDateAchat(RS.getString("dateAchat"));
             Ab.setDateExpiration(RS.getString("dateExpiration"));
             Ab.setIdA(RS.getInt("idA"));

                list.add(Ab);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


