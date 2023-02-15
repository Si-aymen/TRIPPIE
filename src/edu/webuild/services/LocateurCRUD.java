/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Locateur;
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
public class LocateurCRUD implements InterfaceLocateurCRUD{
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
     @Override
    public void ajouterLocateur(Locateur l) {
        try {
            String req = "INSERT INTO `locateur`(`id_loc`, `id_role`,`id_user`,`nom_agence`,`email`,`password`) VALUES ('"+l.getId_loc()+"','"+l.getId_role()+"','"+l.getId_user()+"','"+l.getNom_agence()+"','"+l.getEmail()+"','"+l.getPassword()+"')"; 
             ste = conn.createStatement();
            ste.executeUpdate(req);
             System.out.println("Locateur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Locateur non ajouté");
            System.out.println(ex);
                      }
 }
    
      @Override
    public void modifierLocateur(Locateur loc) {
        try {
            String req = "UPDATE `role` SET `nom_agence` = '" + loc.getNom_agence()+ "',`email` = '" + loc.getEmail() + "',`password` = '" + loc.getPassword()+ "' WHERE `locateur`.`id_locateur` = " + loc.getId_loc();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
    public void supprimerLocateur(int id_loc) {
        try {
            String req = "DELETE FROM `locateur` WHERE id_loc = " + id_loc;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Locateur> afficherLocateur() {
       List<Locateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `locateur`";//"SELECT locateur. *, role.libelle FROM locateur INNER JOIN role ON locateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Locateur loc = new Locateur();
             loc.setId_loc(RS.getInt(1));
             loc.setId_role(RS.getInt(2));
             loc.setId_user(RS.getInt(3));
             loc.setNom_agence(RS.getString(4));
             loc.setEmail(RS.getString(5));
             loc.setPassword(RS.getString(6));
             
            
             
             
             list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public List<Locateur> getById(int id_loc) {
       List<Locateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `locateur` WHERE id_loc = " + id_loc;//"SELECT locateur. *, role.libelle FROM locateur INNER JOIN role ON locateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
           Locateur loc = new Locateur();
             loc.setId_loc(RS.getInt(1));
             loc.setId_role(RS.getInt(2));
             loc.setId_user(RS.getInt(3));
             loc.setNom_agence(RS.getString(4));
             loc.setEmail(RS.getString(5));
             loc.setPassword(RS.getString(6));
            
             
             
             list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }

        return list;
    }
    
    
    @Override
    public List<Locateur> FiltrerLocateur(String f1, String f2) {
       List<Locateur> list = new ArrayList<>();
        try {
            if (f1.equals("id") ) {
            int temp = Integer.parseInt(f2);
            String req = "SELECT * FROM `locateur` WHERE " + f1 + "=" + temp;
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Locateur loc = new Locateur();
             loc.setId_loc(RS.getInt(1));
             loc.setId_role(RS.getInt(2));
             loc.setId_user(RS.getInt(3));
             loc.setNom_agence(RS.getString(4));
             loc.setEmail(RS.getString(5));
             loc.setPassword(RS.getString(6));
            
             
             
             list.add(loc);
            }
            }else{
                     String req = "SELECT * FROM `locateur` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                    
            while(RS.next()){
             Locateur u = new Locateur();
             Locateur loc = new Locateur();
             loc.setId_loc(RS.getInt(1));
             loc.setId_role(RS.getInt(2));
             loc.setId_user(RS.getInt(3));
             loc.setNom_agence(RS.getString(4));
             loc.setEmail(RS.getString(5));
             loc.setPassword(RS.getString(6));
             
             
                          list.add(loc);

            }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }

        return list;
    }
    
    
     @Override
    public List<Locateur> trierLocateur() {
       List<Locateur> list = new ArrayList<>();
        try {
            String req = "Select * from locateur order by nom  DESC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Locateur loc = new Locateur();
             loc.setId_loc(RS.getInt(1));
             loc.setId_role(RS.getInt(2));
             loc.setId_user(RS.getInt(3));
             loc.setNom_agence(RS.getString(4));
             loc.setEmail(RS.getString(5));
             loc.setPassword(RS.getString(6));
             
             list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    
}
