/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Utilisateur;
import java.util.List;

/**
 *
 * @author aymen
 */
public interface InterfaceUserCRUD {
    
    public void ajouterUtilisateur(Utilisateur u);
   public void modifierUtilisateur(Utilisateur u);
   public void supprimerUtilisateur(String cin) ;
   public List<Utilisateur> afficherUtilisateur();
  
    
    
}
