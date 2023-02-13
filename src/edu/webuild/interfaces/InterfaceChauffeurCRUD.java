/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Chauffeur;
import java.util.List;

/**
 *
 * @author aymen
 */
public interface InterfaceChauffeurCRUD {
   public void ajouterChauffeur(Chauffeur c);
   public void modifierChauffeur(Chauffeur c);
   public void supprimerChauffeur(int id_ch);
   public List<Chauffeur> afficherChauffeur();
}
