/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import java.sql.Connection;
import java.sql.Statement;
import edu.webuild.utils.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class ClientCRUD implements InterfaceClientCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterClient(Client cl) {
        try {
            String req = "INSERT INTO `client`(`id_client` ,`id_role`,`id_user`,`email`,`password`) VALUES ('" + cl.getId_client() + "','" + cl.getId_role() + "','" + cl.getEmail() + "','" + cl.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Client ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Client non ajouté");
            System.out.println(ex);
        }
    }

    @Override
    public void modifierClient(Client cl) {
        try {
            String req = "UPDATE `role` SET `email` = '" + cl.getEmail() + "',`password` = '" + cl.getPassword() + "' WHERE `client`.`id_client` = " + cl.getId_client();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerClient(int id_client) {
        try {
            String req = "DELETE FROM `client` WHERE id_client = " + id_client;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Client> afficherClient() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT client.*, role.libelle FROM client INNER JOIN role ON client.id_role = role.id_role";//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setEmail(RS.getString(2));
                cl.setPassword(RS.getString(3));
                 Role role = new Role();
               cl.setId_role(role);
            role.setLibelle(RS.getString(4));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Client> getById(int id_client) {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `client` WHERE id_client = " + id_client;//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setEmail(RS.getString(2));
                cl.setPassword(RS.getString(3));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Client> FiltrerClient(String f1, String f2) {
        List<Client> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `client` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Client cl = new Client();
                    cl.setId_client(RS.getInt(1));
                    cl.setEmail(RS.getString(2));
                    cl.setPassword(RS.getString(3));

                    list.add(cl);
                }
            } else {
                String req = "SELECT * FROM `client` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Client cl = new Client();
                    cl.setId_client(RS.getInt(1));
                    cl.setEmail(RS.getString(2));
                    cl.setPassword(RS.getString(3));

                    list.add(cl);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Client> trierClient() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "Select * from client order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setEmail(RS.getString(3));
                cl.setPassword(RS.getString(4));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
