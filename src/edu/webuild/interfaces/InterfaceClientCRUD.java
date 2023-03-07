/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Client;
import edu.webuild.model.Role;
import java.util.List;

/**
 *
 * @author aymen
 */
public interface InterfaceClientCRUD {

    public void ajouterClient(Client cl);

    public void modifierClient(Client cl);

    public void supprimerClient(int id_client);

    public List<Client> afficherClient();

    public List<Client> getById(int id_client);

    public List<Client> FiltrerClient(String f1, String f2);

    public List<Client> trierClient();

    public Role getRole(int id_role);

    public String afficherProfilClient(String email);

    public List<Client> afficherClient2();

    public void disable(int id_client);

    public boolean isEnabled(int clientId);

    public void modifierProfil(Client cl);

    public List<Client> affiche();

    public List<Client> afficherClient3();

   
}
