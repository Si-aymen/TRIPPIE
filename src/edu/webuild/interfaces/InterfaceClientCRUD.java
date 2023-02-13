/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import edu.webuild.model.Client;
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
}
