/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import java.util.List;

/**
 *
 * @author aymen
 */

public interface InterfaceRoleCRUD {
   public void ajouterRole(Role r);
   public void modifierRole(Role r);
   public void supprimerRole(int id_role);
   public List<Role> afficherRole();
    public List<Role> getById(int id_role);
    public List<Role> FiltrerRole(String f1, String f2);
     public List<Role> trierRole();
       public void affecterRole(Chauffeur ch,Role r);
       public void affecterRole2(Client cli,Role r);
       public void affecterRole3(Locateur loc,Role r);
        public Role getById_user(int id_user);
        
}






