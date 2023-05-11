/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manou
 */
public class CoVoiturageCRUD implements InterfaceCoVoiturage {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    /**
     *
     * @param v
     */
    @Override
    public void ajouterCoVoiturage(CoVoiturage v) {
        try {
            String req;
            //req = "INSERT INTO `CoVoiturage`(`depart`,`destination`,'date_dep','nmbrplace') VALUES('"+v.getDepart() )+"','"+v.getDestinaion()+"','"+v.getDate_dep()+"','"+v.getNmbr_place()+"') ";
            req = "INSERT INTO `co_voiturage`( `depart`, `destination`, `date_dep`, `nmbr_place`) VALUES ('" + v.getDepart() + "','" + v.getDestination() + "','" + v.getDate_dep() + "','" + v.getNmbr_place() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Co Voiturage  ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Co voiturage non ajouté");
        }
    }

    @Override
    public void ajouterCoV(CoVoiturage v) {
        try {
            String req;
            req = "INSERT INTO `co_voiturage`( `depart`, `destination`, `date_dep`, `nmbr_place`,`cov_img`,`id_ch`) VALUES ('" + v.getDepart() + "','" + v.getDestination() + "','" + v.getDate_dep() + "','" + v.getNmbr_place() + "','" + v.getCov_img() + "','" + v.getId_ch() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Co Voiturage  ajouté!!!");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Co voiturage non ajouté");
        }
    }

    /**
     *
     * @param v
     */
    @Override
    public void ajouterCoVoiturage2(CoVoiturage v) {
        try {
            String req = "INSERT INTO `co_voiturage` ( `depart`, `destination`, `date_dep`, `nmbr_place`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);

            ps.setString(1, v.getDepart());
            ps.setString(2, v.getDestination());
            ps.setDate(3, (Date) v.getDate_dep());
            ps.setInt(4, v.getNmbr_place());

            ps.executeUpdate();
            System.out.println("co voiturage ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<CoVoiturage> afficherCoVoiturage() {
        List<CoVoiturage> list = new ArrayList<>();
        try {
            String req = "Select * from co_voiturage ";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                CoVoiturage v = new CoVoiturage();
                v.setId_co(RS.getInt(1));
                v.setDepart(RS.getString(2));
                v.setDestination(RS.getString(3));
                v.setDate_dep(RS.getDate(4));
                v.setNmbr_place(RS.getInt("nmbr_place"));
                v.setCov_img(RS.getString(6));

                list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void supprimerCoVoiturage(int id) {
        try {
            String req = "DELETE FROM `co_voiturage` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("co voiturage deleted ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierCoVoiturage(CoVoiturage v, int id) {
        try {
            //String req = "UPDATE `co_voiturage` SET `nom` = '" + p.getNom() + "', `prenom` = '" + p.getPrenom() + "' WHERE `personne`.`id` = " + p.getId();
            //UPDATE `co_voiturage` SET `id`='[value-1]',`depart`='[value-2]',`destination`='[value-3]',`date_dep`='[value-4]',`nmbr_place`='[value-5]' WHERE
            String req = "UPDATE `co_voiturage` SET `depart`='" + v.getDepart() + "',`destination`='" + v.getDestination() + "',`date_dep`='" + v.getDate_dep() + "',`nmbr_place`='" + v.getNmbr_place() + "' WHERE  `id`= " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("co voiturage updated !");
        } catch (SQLException ex) {
            System.out.println("co voiturage  not updated !");
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public List<CoVoiturage> rechCoVoiturage(int id) {
        List<CoVoiturage> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `co_voiturage` WHERE id= " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                CoVoiturage v = new CoVoiturage();
                v.setId_co(RS.getInt("id"));
                v.setDepart(RS.getString("depart"));
                v.setDestination(RS.getString("destination"));
                v.setDate_dep(RS.getDate("date_dep"));
                v.setNmbr_place(RS.getInt("nmbr_place"));
                v.setCov_img(RS.getString("Cov_img"));

                list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<CoVoiturage> Filter_CoVoiturage(String S, String SS) {
        List<CoVoiturage> list = new ArrayList<>();
        try {
            if (S.equals("id") || S.equals("nmbr_place")) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `co_voiturage` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    CoVoiturage v = new CoVoiturage();
                    v.setId_co(RS.getInt("id"));
                    v.setDepart(RS.getString("depart"));
                    v.setDestination(RS.getString("destination"));
                    v.setDate_dep(RS.getDate("date_dep"));
                    v.setNmbr_place(RS.getInt("nmbr_place"));

                    list.add(v);
                }
            } else {
                String req = "SELECT * FROM `co_voiturage` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    CoVoiturage v = new CoVoiturage();
                    v.setId_co(RS.getInt("id"));
                    v.setDepart(RS.getString("depart"));
                    v.setDestination(RS.getString("destination"));
                    v.setDate_dep(RS.getDate("date_dep"));
                    v.setNmbr_place(RS.getInt("nmbr_place"));

                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public String count_CoVoiturage() {
        int count = 0;
        try {
            String req = "SELECT count(*) FROM `co_voiturage` ";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                count = RS.getInt(1);
            }
            RS.close();
            st.close();
            //conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Integer.toString(count);
    }
}
