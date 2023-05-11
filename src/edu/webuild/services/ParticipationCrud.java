/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParticipationCrud implements InterfaceParticipation {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    /**
     *
     * @param p
     */
    @Override
    public void ajouterParticipation(Participation p) {
        try {
            List<CoVoiturage> list1 = new ArrayList<>();
            String req;
            req = "INSERT INTO `participation`(`nmbr_place_part`,`id_co_id`,`id_client`) VALUES ('" + p.getNmbr_place_part() + "','" + p.getId_co() + "','" + p.getId_client() + "') ";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Participation  ajouté!!!");
            CoVoiturageCRUD v = new CoVoiturageCRUD();
            list1 = v.rechCoVoiturage(p.getId_co());
            CoVoiturage co = new CoVoiturage();
            co = list1.get(0);
            System.out.println(v.rechCoVoiturage(co.getId_co()));
            int x = co.getNmbr_place() - p.getNmbr_place_part();
            co.setNmbr_place(x);
            v.modifierCoVoiturage(co, co.getId_co());
            System.out.println(v.rechCoVoiturage(co.getId_co()));
            System.out.println("co updated");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Participation non ajouté");
        }
    }

    @Override
    public void ajouterParticipation2(Participation p) {
        try {
            String req = "INSERT INTO `participation` (`nmbr_place_part`,`id_co_id` ) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, p.getNmbr_place_part());
            ps.setInt(2, p.getId_co());
            ps.executeUpdate();
            System.out.println(" participation ajouté !!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Participation> afficherParticipation() {
        List<Participation> list = new ArrayList<>();
        try {
            String req = "Select * from participation ";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Participation p = new Participation();
                p.setId_part(RS.getInt(1));
                p.setNmbr_place_part(RS.getInt(2));
                p.setId_co(RS.getInt(3));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void modifierParticipation(Participation p, int id) {
        try {

            String req = "UPDATE `participation` SET `nmbr_place_part`='" + p.getNmbr_place_part() + "',`id_co_id`='" + p.getId_co() + "' WHERE  `id`= " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Participation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void supprimerParticipation(int id) {
        try {
            String req = "DELETE FROM `participation` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("participation deleted ! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Participation> rechParticipation(int id) {
        List<Participation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `participation` WHERE id= " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Participation p = new Participation();
                p.setId_part(RS.getInt(1));
                p.setNmbr_place_part(RS.getInt(2));
                p.setId_co(RS.getInt(3));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Participation> Filter_Participation(String S, String SS) {
        List<Participation> list = new ArrayList<>();
        try {
            int temp = Integer.parseInt(SS);
            String req = "SELECT * FROM `participation` WHERE " + S + " =" + temp;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Participation p = new Participation();
                p.setId_part(RS.getInt(1));
                p.setNmbr_place_part(RS.getInt(2));
                p.setId_co(RS.getInt(3));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Participation> tri() {

        List<Participation> list = new ArrayList<>();
        String req = " select * from participation order by id";
        try {
            Statement pst = conn.prepareStatement(req);

            ResultSet RS = pst.executeQuery(req);

            while (RS.next()) {
                Participation p = new Participation();
                p.setId_part(RS.getInt(1));
                p.setNmbr_place_part(RS.getInt(2));
                p.setId_co(RS.getInt(3));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
