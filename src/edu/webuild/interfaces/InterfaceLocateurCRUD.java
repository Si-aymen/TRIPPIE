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
   public List<Locateur> getById(int id_loc);
    public List<Locateur> FiltrerLocateur(String f1, String f2);
     public List<Locateur> trierLocateur();
      public List<Locateur> afficherLocateur2();
        public List<Locateur> afficherLocateur3();
}
