/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author belkn
 */
public class voitureCRUD implements InterfaceCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
    @Override
    public void ajoutervoiture(voiture v) {
        try {
            String req = "INSERT INTO `voiture`(`matricule`,`marque`,`puissance`,`prix_jours`,`picture`,`energie`,`etat`,`id_loc`) VALUES ('"+v.getMatricule()+"','"+v.getMarque()+"','"+v.getPuissance()+"','"+v.getPrix_jours()+"','"+v.getImage_voiture()+"','"+v.getEnergie()+"','non reservé','"+v.getId_locateur()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("voiture ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("voiture non ajouté");
                      }
 }
      
 
    @Override
    public void modifiervoiture(voiture v ) {
        try {
            String req = "UPDATE `voiture` SET `matricule` = '" + v.getMatricule() + "', `marque` = '" + v.getMarque() +"',`puissance` = '" + v.getPuissance()+ "',`prix_jours` = '" + v.getPrix_jours()+ "',`energie` = '" + v.getEnergie()+ "',`picture` = '" + v.getImage_voiture()+ "' WHERE `id` = " + v.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
    public void modifieretat(voiture v ) {
        try {
       String req = "UPDATE `voiture` SET `etat` = 'reservé' WHERE `id` = " + v.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public void supprimervoiture(int id) {
        try {
            String req = "DELETE FROM `voiture` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<voiture> affichervoitures1() {
       List<voiture> list = new ArrayList<>();
        try {
            String req = "Select * from voiture where etat='non reservé'";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             voiture v = new voiture();
             v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
                v.setImage_voiture(RS.getString(6)); 
                v.setEnergie(RS.getString(7)); 
                 v.setEtat(RS.getString(8)); 
               v.setId_locateur(RS.getInt(9));
             
             list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    @Override
    public List<voiture> affichervoitures() {
       List<voiture> list = new ArrayList<>();
        try {
            String req = "Select * from voiture";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             voiture v = new voiture();
             v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
                v.setImage_voiture(RS.getString(6)); 
                v.setEnergie(RS.getString(7)); 
                 v.setEtat(RS.getString(8)); 
                 v.setId_locateur(RS.getInt(9));
             
             list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
        @Override
    public List<voiture> affichervoitures2(int id) {
       List<voiture> list = new ArrayList<>();
        try {
            String req = "Select * from voiture WHERE id_loc = " + id;
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             voiture v = new voiture();
             v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
                v.setImage_voiture(RS.getString(6)); 
                v.setEnergie(RS.getString(7)); 
                 v.setEtat(RS.getString(8)); 
                    v.setId_locateur(RS.getInt(9));
             
             list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    @Override
    public List<voiture> rechVoiture(int id) {
        List<voiture> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `voiture` WHERE id= " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                 voiture v = new voiture();
             v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
                v.setImage_voiture(RS.getString(6)); 
                v.setEnergie(RS.getString(7)); 
                 v.setEtat(RS.getString(8)); 
             
             list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    @Override
      public voiture getUserByID(int id ) throws SQLException {
       String querry="SELECT *  FROM voiture WHERE `id`="+id;
       Statement stm=conn.createStatement();
       ResultSet RS=stm.executeQuery(querry);
       
       voiture v=new voiture ();
        while (RS.next()) {            
            
           v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
            
        }
    return v;
    }
       @Override
    public List<voiture> triervoiture() {
       List<voiture> list = new ArrayList<>();
        try {
            String req = "Select * from voiture order by Prix_jours ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             voiture v = new voiture();
             v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
             
             list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
   
   @Override
    public List<voiture> Filter_voiture(String S, String SS) {
        List<voiture> list = new ArrayList<>();
        try {
            if (S.equals("id") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `voiture` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    voiture v = new voiture();
                v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
            //     v.setEtat(RS.getString(6)); 

                    list.add(v);
                }
            } else {
                String req = "SELECT * FROM `voiture` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                   voiture v = new voiture();
                v.setId(RS.getInt(1));
                v.setMatricule(RS.getString(2));
                v.setMarque(RS.getString(3));
                v.setPuissance(RS.getString(4));    
                v.setPrix_jours(RS.getInt(5));
//   v.setEtat(RS.getString(6)); 
                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

   
   
    
}
