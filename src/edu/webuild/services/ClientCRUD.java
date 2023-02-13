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
import java.sql.SQLException;

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
            String req = "INSERT INTO `client`(`id_client` ,`id_role`,`email`,`password`) VALUES ('"+cl.getId_client()+"','"+cl.getId_role()+"','"+cl.getEmail()+"','"+cl.getPassword()+"')"; 
             ste = conn.createStatement();
            ste.executeUpdate(req);
             System.out.println("Client ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Client non ajouté");
            System.out.println(ex);
                      }
 }
    
    
    
}
