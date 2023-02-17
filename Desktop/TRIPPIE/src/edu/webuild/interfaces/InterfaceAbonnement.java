/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.abonnement;
import java.sql.SQLException;
import java.util.List;
public interface InterfaceAbonnement {
    
    public void ajouterabonnement(abonnement A);
  // public void ajouterPersonne2(Personne p);
    public void modifierabonnement(abonnement A , int idA);
   public void supprimerabonnement(int idA);
   public List<abonnement> afficherabonnement();
    public abonnement getUserByID(int idA ) throws SQLException;
    public List<abonnement> trierabonnement();
     public List<abonnement> Filter_abonnement(String S, String SS);
    
    
}
