/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.cartefidelite;
import java.sql.SQLException;

import java.util.List;

/**
 *
 * @author mtirn
 */
public interface InterfaceCarte {
    
public void ajoutercarte(cartefidelite cf);

    public void modifiercarte(cartefidelite cf , int id_cf);
   public void supprimercarte(int id_cf);
   public List<cartefidelite> affichercarte();
  public cartefidelite getUserByIDcf(int id_cf ) throws SQLException;
  public List<cartefidelite> triercarte();
  public List<cartefidelite> Filter_carte(String S, String SS);
}
