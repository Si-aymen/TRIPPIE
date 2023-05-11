/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import java.util.List;

/**
 *
 * @author guerf
 */
public interface InterfaceCRUDrec {

    public void ajouterReclamation(reclamation r);

    public void modifierReclamation(reclamation r, int id);

    public void supprimerReclamation(int id);

    public List<reclamation> afficherReclamation(int id);
    
    public List<reclamation> afficher();

    public reclamation detailsReclamation(int id);

    public reclamation getById_rec(int id);

    public void traite(reclamation r);

    public void ajouterReponse(reponse r);

    public void modifierReponse(reponse r, int id);

    public void supprimerReponse(int id);

    public List<reponse> afficherReponse();

    public reponse detailsReponse(int id);

    public List<reponse> getById_rep(int id);
   
    public int countRec(String type);
   
    public List<reclamation> rechReclamation(int id);

    //public List<reponse> afficher_join();
}