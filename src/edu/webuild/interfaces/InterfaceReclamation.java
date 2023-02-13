/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;
import edu.webuild.model.reclamation;
import java.util.List;
public interface InterfaceReclamation {
    
   public void ajouterReclamation(reclamation r);
   public void modifierReclamation(reclamation r , int id);
   public void supprimerReclamation(int id) ;
   public List<reclamation> afficherReclamation();
   //public List<reclamation> filtrer1(int id);

    
    
}
