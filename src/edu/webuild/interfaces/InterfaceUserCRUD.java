/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import java.util.List;

/**
 *
 * @author aymen
 */
public interface InterfaceUserCRUD {

    public void ajouterUtilisateur(Utilisateur u);

    public void modifierUtilisateur(Utilisateur u);

    public void modifierUtilisateur(Utilisateur u, int id_user);

    public void supprimerUtilisateurByCin(String cin);

    public void supprimerUtilisateurById(int id_user);

    public List<Utilisateur> afficherUtilisateur();

    public List<Utilisateur> getById(int id_user);

    public List<Utilisateur> FiltrerUtilisateur(String f1, String f2);

    public List<Utilisateur> trierUtilisateur();

    public void affecterClient(Role r, Utilisateur u);

    public void affecterChauffeur(Role r, Utilisateur u);

    public void affecterLocateur(Role r, Utilisateur u);

    public Utilisateur getByCin(String cin);


}
