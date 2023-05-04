/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khmir
 */
public class reservationCRUD implements InterfaceCRUD2 {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
     @Override
public void ajouterreservation(reservation r) {
    String query = "INSERT INTO reservation (date_debut, date_fin, id_voiture_id,id_client) VALUES (?, ?, ?,?)";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setDate(1, r.getDate_debut());
        ps.setDate(2, r.getDate_fin());
        ps.setInt(3, r.getV().getId());
          ps.setInt(4, r.getId_client());
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Reservation ajoutée!");
        } else {
            System.out.println("Erreur: la réservation n'a pas été ajoutée.");
        }
    } catch (SQLException ex) {
        System.out.println("Erreur: " + ex.getMessage());
    }
}


    
     @Override
    public List<reservation> afficherreservations() {
       List<reservation> list = new ArrayList<>();
        try {
            String req = "Select * from reservation";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             reservation r = new reservation();
             r.setId(RS.getInt(1));
                r.setDate_debut(RS.getDate(2));
                r.setDate_fin(RS.getDate(3));
                /*
                r.setId_voiture(RS.getInt(4));
             */
                voitureCRUD voit = new voitureCRUD();
                int user_id = RS.getInt(4);
                voiture v = voit.getUserByID(user_id);
                r.setV(v);
                list.add(r);
                
                
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
         @Override
    public List<reservation> afficherreservations2(int id) {
       List<reservation> list = new ArrayList<>();
        try {
            String req = "Select * from reservation WHERE id_client= " + id ;
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             reservation r = new reservation();
             r.setId(RS.getInt(1));
                r.setDate_debut(RS.getDate(2));
                r.setDate_fin(RS.getDate(3));
           
                voitureCRUD voit = new voitureCRUD();
                int user_id = RS.getInt(4);
                
                voiture v = voit.getUserByID(user_id);
                r.setV(v);
                list.add(r);
                
                
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
     @Override
    public List<reservation> rechercherreservation(int id ) {
       List<reservation> list = new ArrayList<>();
        try {
          String req = "SELECT * FROM `reservation` WHERE id= " + id;
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             reservation r = new reservation();
             r.setId(RS.getInt(1));
                r.setDate_debut(RS.getDate(2));
                r.setDate_fin(RS.getDate(3));
              
                voitureCRUD voit = new voitureCRUD();
                int user_id = RS.getInt(4);
                voiture v = voit.getUserByID(user_id);
                r.setV(v);
                list.add(r);
                
                
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }


  @Override
    public void supprimerreservation(int id) {
        try {
            String req = "DELETE FROM `reservation` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       @Override
    public void modifierreservation(reservation r ) {
        try {
            String req = "UPDATE `reservation` SET `date_debut` = '" + r.getDate_debut() + "', `date_fin` = '" + r.getDate_fin() + "' WHERE `id` = " + r.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

}

