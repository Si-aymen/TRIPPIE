/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.model.cartefidelite;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.webuild.interfaces.InterfaceCarte;

/**
 *
 * @author mtirn
 */
public class CartefideliteCRUD implements InterfaceCarte {
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    @Override
    public void ajoutercarte(cartefidelite cf) {
        try {
            String req = "INSERT INTO `cartefidelite`(`pointMerci`,`dateExpiration`,`idA`) VALUES ('"+cf.getPointMerci()+"','"+cf.getPointMerci()+"','"+cf.getIdA()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("cartefidelite ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("cartefidelite non ajouté");
                      }
 }
     @Override
    public List<cartefidelite> affichercarte() {
       List<cartefidelite> list = new ArrayList<>();
        try {
            String req = "Select * from cartefidelite";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             cartefidelite cf = new cartefidelite();
             cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getString(3));
                cf.setIdA(RS.getInt(4));
             
             list.add(cf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

  @Override
    public void supprimercarte(int id_cf) {
        try {
            String req = "DELETE FROM `cartefidelite` WHERE id_cf = " + id_cf;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("cartefidelite deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
       @Override
    public void modifiercarte(cartefidelite cf ,int id_cf) {
        try {
            String req = "UPDATE `cartefidelite` SET `pointMerci` = '" + cf.getPointMerci() + "', `dateExpiration` = '" + cf.getDateExpiration() + "' WHERE `id_cf` = " + id_cf;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("cartefidelite updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
      public cartefidelite getUserByIDcf(int id_cf ) throws SQLException {
       String querry="SELECT *  FROM cartefidelite WHERE `id_cf`="+id_cf;
       Statement stm=conn.createStatement();
       ResultSet RS=stm.executeQuery(querry);
       cartefidelite cf = new cartefidelite();
      
        while (RS.next()) {            
            
             
             cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getString(3));
               
         
          
            
        }
    return cf;
    }
      
         @Override
    public List<cartefidelite> triercarte() {
       List<cartefidelite> list = new ArrayList<>();
        try {
            String req = "Select * from cartefidelite order by pointMerci ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             cartefidelite cf = new cartefidelite();
             cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getString(3));
                cf.setIdA(RS.getInt(4));
             
             list.add(cf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
     @Override
    public List<cartefidelite> Filter_carte(String S, String SS) {
        List<cartefidelite> list = new ArrayList<>();
        try {
            if (S.equals("id_cf") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `cartefidelite` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                 cartefidelite cf = new cartefidelite();
                cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getString(3));
                cf.setIdA(RS.getInt(4));

                    list.add(cf);
                }
            } else {
                String req = "SELECT * FROM `cartefidelite` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                cartefidelite cf = new cartefidelite();
                  cf.setId_cf(RS.getInt(1));
                cf.setPointMerci(RS.getString(2));
                cf.setDateExpiration(RS.getString(3));
                cf.setIdA(RS.getInt(4));
                    list.add(cf);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

    
    
}
