/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.inter;

import edu.webuild.model.cadeau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface interfacecadeau {

   

    public void ajoutercadeau2(cadeau c);

    public List<cadeau> displayCadeau();

    public int Supprimer(String cadeau);

    public void modifier(cadeau c);

    public List<cadeau> rech(int id);

    public List<cadeau> sortCoupons(String column, String order);

}
