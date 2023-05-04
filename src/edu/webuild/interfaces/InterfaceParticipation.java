/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Participation;
import java.util.List;

/**
 *
 * @author manou
 */
public interface InterfaceParticipation {

    public void ajouterParticipation(Participation p);

    public void ajouterParticipation2(Participation p);

    public void modifierParticipation(Participation p, int id);

    public void supprimerParticipation(int id);

    public List<Participation> afficherParticipation();

    public List<Participation> rechParticipation(int id);

    public List<Participation> Filter_Participation(String S, String SS);

    public List<Participation> tri();
}
