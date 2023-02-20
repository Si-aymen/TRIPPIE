/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceRoleCRUD;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
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
 * @author aymen
 */
public class roleCRUD implements InterfaceRoleCRUD {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
     @Override
    public void ajouterRole(Role r) {
        try {
             String req = "INSERT INTO `role`( `id_role`,`libelle`,id_user) VALUES ('"+r.getId_role()+"','"+r.getLibelle()+"','"+r.getId_user()+"')"; 
             ste = conn.createStatement();
            ste.executeUpdate(req);
             System.out.println("Role ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Role non ajouté");
                      }
 }
    
 
     @Override
    public void modifierRole(Role r) {
        try {
            String req = "UPDATE `role` SET `libelle` = '" + r.getLibelle() + "' WHERE `role`.`id_role` = " + r.getId_role();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
     @Override
    public void supprimerRole(int id_role) {
        try {
            String req = "DELETE FROM `role` WHERE id_role = " + id_role;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
     @Override
    public List<Role> afficherRole() {
       List<Role> list = new ArrayList<>();
        try {
            String req = "SELECT libelle FROM role";//"SELECT role. *, role.libelle FROM role INNER JOIN role ON role.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Role r = new Role();
            // r.setId_role(RS.getInt(1));
             r.setLibelle(RS.getString(1));
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Role> getById(int id_role) {
       List<Role> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `role` WHERE id_role = " + id_role;//"SELECT role. *, role.libelle FROM role INNER JOIN role ON role.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
             while(RS.next()){
             Role r = new Role();
             r.setId_role(RS.getInt(1));
             r.setLibelle(RS.getString(2));
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
    @Override
    public List<Role> FiltrerRole(String f1, String f2) {
       List<Role> list = new ArrayList<>();
        try {
            if (f1.equals("id") ) {
            int temp = Integer.parseInt(f2);
            String req = "SELECT * FROM `role` WHERE " + f1 + "=" + temp;
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Role r = new Role();
             r.setId_role(RS.getInt(1));
             r.setLibelle(RS.getString(2));
            
             
             
             list.add(r);
            }
            }else{
                     String req = "SELECT * FROM `role` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                    
            while(RS.next()){
             Role r = new Role();
             r.setId_role(RS.getInt(1));

             r.setLibelle(RS.getString(2));             
             
                          list.add(r);

            }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }

        return list;
    }
    
    
     @Override
    public List<Role> trierRole() {
       List<Role> list = new ArrayList<>();
        try {
            String req = "Select * from role order by nom  DESC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
            Role r = new Role();
             r.setId_role(RS.getInt(1));
             
             r.setLibelle(RS.getString(2));
             
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
     @Override
    public void affecterUser(Role r, Utilisateur u) {
        try {
            String req ="UPDATE `role` SET `utilisateur`= ? WHERE id_role = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, u.getId_user());
            ps.setInt(2, r.getId_role());
             ps.executeUpdate();
            System.out.println("Player updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    

}
