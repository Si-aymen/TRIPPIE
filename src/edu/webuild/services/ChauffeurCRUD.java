/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.model.Chauffeur;
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
public class ChauffeurCRUD implements InterfaceChauffeurCRUD {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
     @Override
    public void ajouterChauffeur(Chauffeur c) {
        try {
             String req = "INSERT INTO `chauffeur`(`id_ch`,`id_role`,`id_user`,`num_permis`,`marque_voiture`,`couleur_voiture`,`immatriculation`,`email`,`password`)"
                     + " VALUES ('"+c.getId_ch()+"','"+c.getId_role()+"','"+c.getId_user()+"','"+c.getNum_permis()+"','"+c.getMarque_voiture()+"','"+c.getCouleur_voiture()+"','"+c.getImmatriculation()+"',"
                     + "'"+c.getEmail()+"','"+c.getPassword()+"')"; 
             ste = conn.createStatement();
            ste.executeUpdate(req);
             System.out.println("Chauffeur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Chauffeur non ajouté");
                      }
 }
   
    
 
     @Override
    public void modifierChauffeur(Chauffeur ch) {
        try {
            String req = "UPDATE `chauffeur` SET `num_permis` = '" + ch.getNum_permis()+ "',`marque_voiture` = '" + ch.getMarque_voiture()+ "',`couleur_voiture` = '"
                    + ch.getCouleur_voiture()+ "',`immatriculation` = '" + ch.getImmatriculation()+ "',"
                    + "`email` = '" + ch.getEmail() + "',`password` = '" + ch.getPassword()+ "' WHERE `client`.`id_client` = " + ch.getId_ch();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Chauffeur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
     @Override
    public void supprimerChauffeur(int id_ch) {
        try {
            String req = "DELETE FROM `role` WHERE id_role = " + id_ch;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Chauffeur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
     @Override
    public List<Chauffeur> afficherChauffeur() {
       List<Chauffeur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM chauffeur";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Chauffeur ch = new Chauffeur();
             ch.setId_ch(RS.getInt(1));
             ch.setId_role(RS.getInt(2));
             ch.setId_user(RS.getInt(3));
             ch.setNum_permis(RS.getString(4));
             ch.setMarque_voiture(RS.getString(5));
             ch.setCouleur_voiture(RS.getString(6));
             ch.setImmatriculation(RS.getString(7));
             ch.setEmail(RS.getString(8));
             ch.setPassword(RS.getString(9));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
