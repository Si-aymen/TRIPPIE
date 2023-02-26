/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.utils.MyConnection;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import static javax.mail.Flags.Flag.USER;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilClientController implements Initializable {

    @FXML
    private Button exitBtn;
    private int id_client_connecte;
    @FXML
    private Label fxnom;
    @FXML
    private Label fxprenom;
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @FXML
    private void exit(ActionEvent event) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

}
