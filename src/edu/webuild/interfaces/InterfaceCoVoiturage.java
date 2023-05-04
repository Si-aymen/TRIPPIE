/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.*;
import java.util.List;

/**
 *
 * @author manou
 */
public interface InterfaceCoVoiturage {

    public void ajouterCoVoiturage(CoVoiturage v);

    public void ajouterCoVoiturage2(CoVoiturage v);

    public void modifierCoVoiturage(CoVoiturage v, int id);

    public void supprimerCoVoiturage(int id);

    public List<CoVoiturage> afficherCoVoiturage();

    public List<CoVoiturage> rechCoVoiturage(int id);

    public List<CoVoiturage> Filter_CoVoiturage(String S, String SS);

    public void ajouterCoV(CoVoiturage v);

    public String count_CoVoiturage();


}
