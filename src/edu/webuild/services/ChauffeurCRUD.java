/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
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
public class ChauffeurCRUD implements InterfaceChauffeurCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterChauffeur(Chauffeur c) {
        try {
            String req = "INSERT INTO `chauffeur`(`id_role`,`num_permis`,`marque_voiture`,`couleur_voiture`,`immatriculation`,`email`,`password`)"
                    + " VALUES ('" + c.getId_role() + "','" + c.getNum_permis() + "','" + c.getMarque_voiture() + "','" + c.getCouleur_voiture() + "','" + c.getImmatriculation() + "',"
                    + "'" + c.getEmail() + "','" + c.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Chauffeur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Chauffeur non ajouté");
        }
    }

    @Override
    public void ajouterChauffeur2(Chauffeur c) {
        try {
            String req = "INSERT INTO `chauffeur`(`num_permis`,`marque_voiture`,`couleur_voiture`,`immatriculation`,`email`,`password`)"
                    + " VALUES ('" + c.getNum_permis() + "','" + c.getMarque_voiture() + "','" + c.getCouleur_voiture() + "','" + c.getImmatriculation() + "',"
                    + "'" + c.getEmail() + "','" + c.getPassword() + "')";
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
            String req = "UPDATE `chauffeur` SET `num_permis` = '" + ch.getNum_permis() + "',`marque_voiture` = '" + ch.getMarque_voiture() + "',`couleur_voiture` = '"
                    + ch.getCouleur_voiture() + "',`immatriculation` = '" + ch.getImmatriculation() + "',"
                    + "`email` = '" + ch.getEmail() + "',`password` = '" + ch.getPassword() + "' WHERE `client`.`id_client` = " + ch.getId_ch();
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
            String req = "DELETE FROM `chauffeur` WHERE id_ch = " + id_ch;
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
        String req = "SELECT chauffeur.*, role.libelle FROM chauffeur INNER JOIN role ON chauffeur.id_role = role.id_role";
        Statement st = conn.createStatement();
        ResultSet RS = st.executeQuery(req);
        while (RS.next()) {
            Chauffeur ch = new Chauffeur();
            ch.setId_ch(RS.getInt(1));
            ch.setNum_permis(RS.getString(2));
            ch.setMarque_voiture(RS.getString(3));
            ch.setCouleur_voiture(RS.getString(4));
            ch.setImmatriculation(RS.getString(5));
            ch.setEmail(RS.getString(6));
            ch.setPassword(RS.getString(7));
            Role role = new Role();
            ch.setId_role(role);
            role.setLibelle(RS.getString(9));
           
            list.add(ch);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return list;
}



    @Override
    public List<Chauffeur> getById(int id_ch) {
        List<Chauffeur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `chauffeur` WHERE id_ch = " + id_ch;//"SELECT chauffeur. *, role.libelle FROM chauffeur INNER JOIN role ON chauffeur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));
                ch.setMarque_voiture(RS.getString(3));
                ch.setCouleur_voiture(RS.getString(4));
                ch.setImmatriculation(RS.getString(5));
                ch.setEmail(RS.getString(6));
                ch.setPassword(RS.getString(7));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Chauffeur> FiltrerChauffeur(String f1, String f2) {
        List<Chauffeur> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `chauffeur` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Chauffeur ch = new Chauffeur();
                    ch.setId_ch(RS.getInt(1));
                    ch.setNum_permis(RS.getString(2));
                    ch.setMarque_voiture(RS.getString(3));
                    ch.setCouleur_voiture(RS.getString(4));
                    ch.setImmatriculation(RS.getString(5));
                    ch.setEmail(RS.getString(6));
                    ch.setPassword(RS.getString(7));

                    list.add(ch);
                }
            } else {
                String req = "SELECT * FROM `chauffeur` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Chauffeur ch = new Chauffeur();
                    ch.setId_ch(RS.getInt(1));
                    ch.setNum_permis(RS.getString(2));
                    ch.setMarque_voiture(RS.getString(3));
                    ch.setCouleur_voiture(RS.getString(4));
                    ch.setImmatriculation(RS.getString(5));
                    ch.setEmail(RS.getString(6));
                    ch.setPassword(RS.getString(7));

                    list.add(ch);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Chauffeur> trierChauffeur() {
        List<Chauffeur> list = new ArrayList<>();
        try {
            String req = "Select * from chauffeur order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));
                ch.setMarque_voiture(RS.getString(3));
                ch.setCouleur_voiture(RS.getString(4));
                ch.setImmatriculation(RS.getString(5));
                ch.setEmail(RS.getString(6));
                ch.setPassword(RS.getString(7));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }


   

}
