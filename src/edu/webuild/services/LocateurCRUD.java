/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Locateur;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aymen
 */
public class LocateurCRUD implements InterfaceLocateurCRUD{
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
     @Override
    public void ajouterLocateur(Locateur l) {
        try {
            String req = "INSERT INTO `locateur`(`id_loc` ,`id_role`,`nom_agence`,`email`,`password`) VALUES ('"+l.getId_loc()+"','"+l.getId_role()+"','"+l.getNom_agence()+"','"+l.getEmail()+"','"+l.getPassword()+"')"; 
             ste = conn.createStatement();
            ste.executeUpdate(req);
             System.out.println("Locateur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Locateur non ajouté");
            System.out.println(ex);
                      }
 }
    
}
