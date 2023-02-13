/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
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
            String req = "INSERT INTO `client`(`id_client` ,`id_role`,`id_user`,`email`,`password`) VALUES ('"+cl.getId_client()+"','"+cl.getId_role()+"','"+cl.getId_user()+"','"+cl.getEmail()+"','"+cl.getPassword()+"')"; 
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
            String req = "UPDATE `role` SET `email` = '" + cl.getEmail() + "',`password` = '" + cl.getPassword()+ "' WHERE `client`.`id_client` = " + cl.getId_client();
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
            String req = "SELECT * FROM `client`";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Client cl = new Client();
             cl.setId_client(RS.getInt(1));
             cl.setId_role(RS.getInt(2));
             cl.setId_user(RS.getInt(3));
             cl.setEmail(RS.getString(4));
             cl.setPassword(RS.getString(5));
             
            
             
             
             list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
