/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceUserCRUD;
import edu.webuild.model.Utilisateur;
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
public class utilisateurCRUD implements InterfaceUserCRUD {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
   @Override
    public void ajouterUtilisateur(Utilisateur u) {
        try {
             String req = "INSERT INTO `utilisateur`(`cin` , `nom`, `prenom` , `sexe` , `age`, `role`) VALUES ('"+u.getCin()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getSexe()+"','"+u.getAge()+"','"+u.getRole()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Utilisateur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Utilisateur non ajouté");
            
            System.out.println(ex);
                      }
 }
    
 
    @Override
    public void modifierUtilisateur(Utilisateur u) {
        try {
            String req = "UPDATE `utilisateur` SET `nom` = '" + u.getNom() + "', `prenom` = '" + u.getPrenom() + "', `sexe` = '" + u.getSexe() + "', `age` = '" + u.getAge() + "' WHERE `utilisateur`.`id_user` = " + u.getId_user();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
   
    @Override
    public void supprimerUtilisateurByCin(String cin) {
        try {
            String req = "DELETE FROM `utilisateur` WHERE cin = " + cin;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     @Override
    public void supprimerUtilisateurById(int id_user) {
        try {
            String req = "DELETE FROM `utilisateur` WHERE id_user = " + id_user;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
   @Override
    public List<Utilisateur> afficherUtilisateur() {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `utilisateur`";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setId_user(RS.getInt(1));
             u.setCin(RS.getString(2));
             u.setNom(RS.getString(3));
             u.setPrenom(RS.getString(4));
             u.setSexe(RS.getString(5));
             u.setAge(RS.getInt(6));
             u.setRole(RS.getInt(7));
            
             
             
             list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
@Override
    public List<Utilisateur> getById(int id_user) {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `utilisateur` WHERE id_user = " + id_user;//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setId_user(RS.getInt(1));
             u.setCin(RS.getString(2));
             u.setNom(RS.getString(3));
             u.setPrenom(RS.getString(4));
             u.setSexe(RS.getString(5));
             u.setAge(RS.getInt(6));
             u.setRole(RS.getInt(7));
            
             
             
             list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }

        return list;
    }
    
    
    @Override
    public List<Utilisateur> FiltrerUtilisateur(String f1, String f2) {
       List<Utilisateur> list = new ArrayList<>();
        try {
            if (f1.equals("id") ) {
            int temp = Integer.parseInt(f2);
            String req = "SELECT * FROM `utilisateur` WHERE " + f1 + "=" + temp;
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setId_user(RS.getInt(1));
             u.setCin(RS.getString(2));
             u.setNom(RS.getString(3));
             u.setPrenom(RS.getString(4));
             u.setSexe(RS.getString(5));
             u.setAge(RS.getInt(6));
             u.setRole(RS.getInt(7));
            
             
             
             list.add(u);
            }
            }else{
                     String req = "SELECT * FROM `utilisateur` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                    
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setId_user(RS.getInt(1));
             u.setCin(RS.getString(2));
             u.setNom(RS.getString(3));
             u.setPrenom(RS.getString(4));
             u.setSexe(RS.getString(5));
             u.setAge(RS.getInt(6));
             u.setRole(RS.getInt(7));
             
             
                          list.add(u);

            }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }

        return list;
    }
    
    
     @Override
    public List<Utilisateur> trierUtilisateur() {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from utilisateur order by nom  DESC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setId_user(RS.getInt(1));
             u.setCin(RS.getString(2));
             u.setNom(RS.getString(3));
             u.setPrenom(RS.getString(4));
             u.setSexe(RS.getString(5));
             u.setAge(RS.getInt(6));
             u.setRole(RS.getInt(7));
             
             list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }




}
