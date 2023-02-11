/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Personne;
import java.util.List;

/**
 *
 * @author belkn
 */
public interface InterfaceCRUD {
    
    public void ajouterPersonne(Personne p);
    public void ajouterPersonne2(Personne p);
    public void modifierpersonne(Personne p);
    public void supprimerpersonne(int id) ;
    public List<Personne> afficherPersonne();
    
    
}
