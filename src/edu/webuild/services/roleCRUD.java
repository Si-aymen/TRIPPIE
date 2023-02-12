/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceRoleCRUD;
import edu.webuild.model.Role;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
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
             String req = "INSERT INTO `role`( `id_role`,`libelle`) VALUES ('"+r.getId_role()+"','"+r.getLibelle()+"')"; 
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
            String req = "SELECT * FROM role";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
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

}
