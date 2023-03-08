/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author aymen
 */
public interface InterfaceChauffeurCRUD {
   public void ajouterChauffeur(Chauffeur c);
   public void modifierChauffeur(Chauffeur c);
   public void supprimerChauffeur(int id_ch);
   public List<Chauffeur> afficherChauffeur();
   public List<Chauffeur> getById(int id_ch);
    public List<Chauffeur> FiltrerChauffeur(String f1, String f2);
     public List<Chauffeur> trierChauffeur();
     public void ajouterChauffeur2(Chauffeur c);
    // public void modifierChauffeur2(Chauffeur ch);
      public int getById2(int id_ch);
      public List<Chauffeur> afficherChauffeur2();
       public Image afficher(String identifiant) ;
        public List<Chauffeur> afficherChauffeur3();
     public void disableChauffeur(String num_permis);
    
}
