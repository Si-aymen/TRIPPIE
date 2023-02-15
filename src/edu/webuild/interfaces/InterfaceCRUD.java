/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Abonnement;
import java.util.List;
/**
 *
 * @author mtirn
 */
public interface InterfaceCRUD {
    
    public void ajouterAbonnement(Abonnement A);
    public void ajouterAbonnement2(Abonnement A);
    public void modifierAbonnement(Abonnement A);
    public void supprimerAbonnement(int id) ;
    public List<Abonnement> afficherAbonnement();
    
    
}