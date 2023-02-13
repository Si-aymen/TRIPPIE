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
             String req = "INSERT INTO `utilisateur`( `cin` , `nom`, `prenom` , `age`, `role`) VALUES ('"+u.getCin()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getAge()+"','"+u.getRole()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Utilisateur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Utilisateur non ajouté");
                      }
 }
    
 
    @Override
    public void modifierUtilisateur(Utilisateur u) {
        try {
            String req = "UPDATE `utilisateur` SET `nom` = '" + u.getNom() + "', `prenom` = '" + u.getPrenom() + "', `age` = '" + u.getAge() + "' WHERE `utilisateur`.`cin` = " + u.getCin();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    @Override
    public void supprimerUtilisateur(String cin) {
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
    public List<Utilisateur> afficherUtilisateur() {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `utilisateur`";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur u = new Utilisateur();
             u.setCin(RS.getString(1));
             u.setNom(RS.getString(2));
             u.setPrenom(RS.getString(3));
             u.setAge(RS.getInt(4));
             u.setRole(RS.getInt(5));
            
             
             
             list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    


}
