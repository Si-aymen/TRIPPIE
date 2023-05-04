/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.reservation;
import java.sql.SQLException;

import java.util.List;

/**
 *
 * @author khmir
 */
public interface InterfaceCRUD2 {
    
public void ajouterreservation(reservation r);
  // public void ajouterPersonne2(Personne p);
    public void modifierreservation(reservation r);
   public void supprimerreservation(int id) ;
   public List<reservation> afficherreservations();
    public List<reservation> rechercherreservation(int id );
     public List<reservation> afficherreservations2(int id); 
   /*
  public reservation getUserByIDre(int id ) throws SQLException;
  public List<reservation> trierReservation(); 
  public List<reservation> Filter_reservation(String S, String SS);
*/
}
