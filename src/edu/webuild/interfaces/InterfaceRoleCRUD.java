/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Role;
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
}






