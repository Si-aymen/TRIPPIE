/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.interfaces.InterfaceCRUD2;
import edu.webuild.model.reservation;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
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
        try {
            String req = "INSERT INTO `reservation`(`date_debut`,`date_fin`,`id_voiture`) VALUES ('"+r.getDate_debut()+"','"+r.getDate_debut()+"','"+r.getId_voiture()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("reservation ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("reservation non ajouté");
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
                r.setDate_debut(RS.getString(2));
                r.setDate_fin(RS.getString(3));
                r.setId_voiture(RS.getInt(4));
             
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
    public void modifierreservation(reservation r ,int id) {
        try {
            String req = "UPDATE `reservation` SET `date_debut` = '" + r.getDate_debut() + "', `date_fin` = '" + r.getDate_fin() + "' WHERE `id` = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
      public reservation getUserByIDre(int id ) throws SQLException {
       String querry="SELECT *  FROM reservation WHERE `id`="+id;
       Statement stm=conn.createStatement();
       ResultSet RS=stm.executeQuery(querry);
       
       reservation r=new reservation ();
        while (RS.next()) {            
            
          r.setId(RS.getInt(1));
          r.setDate_debut(RS.getString(2));
          r.setDate_fin(RS.getString(3));
            
        }
    return r;
    }
         @Override
    public List<reservation> trierReservation() {
       List<reservation> list = new ArrayList<>();
        try {
            String req = "Select * from reservation order by date_debut ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             reservation r = new reservation();
             r.setId(RS.getInt(1));
                r.setDate_debut(RS.getString(2));
                r.setDate_fin(RS.getString(3));
                r.setId_voiture(RS.getInt(4));
             
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
     @Override
    public List<reservation> Filter_reservation(String S, String SS) {
        List<reservation> list = new ArrayList<>();
        try {
            if (S.equals("id") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `reservation` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    reservation r = new reservation();
               r.setId(RS.getInt(1));
                r.setDate_debut(RS.getString(2));
                r.setDate_fin(RS.getString(3));
               r.setId_voiture(RS.getInt(4));

                    list.add(r);
                }
            } else {
                String req = "SELECT * FROM `reservation` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                reservation r = new reservation();
               r.setId(RS.getInt(1));
                r.setDate_debut(RS.getString(2));
                r.setDate_fin(RS.getString(3));
                r.setId_voiture(RS.getInt(4));

                    list.add(r);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

    
    
}
