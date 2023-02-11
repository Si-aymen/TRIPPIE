/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Personne;
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
            req = "INSERT INTO `co_voiturage`( `depart`, `destination`, `date_dep`, `nmbr_place`) VALUES ('" + v.getDepart() + "','" + v.getDestinaion() + "','" + v.getDate_dep() + "','" + v.getNmbr_place() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Co Voiturage  ajouté!!!");
        } catch (SQLException ex) {
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
            ps.setString(2, v.getDestinaion());
            ps.setString(3, v.getDate_dep());
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
                v.setDestinaion(RS.getString(3));
                v.setDate_dep(RS.getString(4));
                v.setNmbr_place(RS.getInt("nmbr_place"));

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
            String req = "DELETE FROM `co_voiturage` WHERE id_co = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("co voiturage deleted ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierCoVoiturage(CoVoiturage v , int id){
        try {
            //String req = "UPDATE `co_voiturage` SET `nom` = '" + p.getNom() + "', `prenom` = '" + p.getPrenom() + "' WHERE `personne`.`id` = " + p.getId();
            //UPDATE `co_voiturage` SET `id_co`='[value-1]',`depart`='[value-2]',`destination`='[value-3]',`date_dep`='[value-4]',`nmbr_place`='[value-5]' WHERE
            String req = "UPDATE `co_voiturage` SET `depart`='"+v.getDepart()+"',`destination`='"+v.getDestinaion()+"',`date_dep`='"+v.getDate_dep()+"',`nmbr_place`='"+v.getNmbr_place()+"' WHERE  `id_co`= " +id  ;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("co voiturage updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
