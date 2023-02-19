/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.voiture;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceCRUD {

    public void ajoutervoiture(voiture v);
    // public void ajouterPersonne2(Personne p);

    public void modifiervoiture(voiture v);

    public void supprimervoiture(int id);

    public List<voiture> affichervoitures();

    public voiture getUserByID(int id) throws SQLException;

    public List<voiture> triervoiture();

    public List<voiture> Filter_voiture(String S, String SS);

}
