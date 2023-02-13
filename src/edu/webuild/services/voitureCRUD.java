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
            String req = "INSERT INTO `voiture`(`matricule`,`marque`,`puissance`,`prix_jours`) VALUES ('"+v.getMatricule()+"','"+v.getMarque()+"','"+v.getPuissance()+"','"+v.getPrix_jours()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("voiture ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("voiture non ajouté");
                      }
 }
 
    @Override
    public void modifiervoiture(voiture v ,int id) {
        try {
            String req = "UPDATE `voiture` SET `matricule` = '" + v.getMatricule() + "', `marque` = '" + v.getMarque() +"',`puissance` = '" + v.getPuissance()+ "',`prix_jours` = '" + v.getPrix_jours()+ "' WHERE `id` = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne updated !");
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
/*
    @Override
    public void ajouterPersonne2(voiture p) {
 try {
            String req = "INSERT INTO `personne` (`nom`, `prenom`) VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
             ps.executeUpdate();
            System.out.println("Personne ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
    }
*/

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

                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

   
   
    
}
