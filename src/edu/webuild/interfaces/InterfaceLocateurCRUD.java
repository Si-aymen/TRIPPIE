/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Locateur;
import java.util.List;

/**
 *
 * @author aymen
 */
public interface InterfaceLocateurCRUD {
      public void ajouterLocateur(Locateur l);
      
   public void modifierLocateur(Locateur loc);
   public void supprimerLocateur(int id_loc);
   public List<Locateur> afficherLocateur();
}
