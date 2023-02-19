/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import java.util.List;
/**
 *
 * @author HP
 */
public interface cadeau {
    
 public void ajoutercadeau();
 public void ajoutercadeau2(cadeau c);
 public List<cadeau> displayCadeau();  
 public  int Supprimer(int id ); 
public List<cadeau> rech(int id );
public List<cadeau> sortCoupons(String column, String order);
public boolean validatecadeau(cadeau cadeau);

}
