/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.sql.Connection;

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
   
    @FXML
    private ListView<Client> listview;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        MyConnection c = new MyConnection();
        Connection cnx = c.getConn();
        String query = "SELECT utilisateur.nom, utilisateur.prenom, client.email "
                + "FROM utilisateur "
                + "INNER JOIN role ON utilisateur.id_user = role.id_user "
                + "INNER JOIN client ON role.id_role = client.id_role "
                + "WHERE client.email = ? AND client.password = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setString(1, "email_du_client");
            ps.setString(2, "mot_de_passe_du_client");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String list = nom + "/" + prenom + "/" + email;
                listview.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void exit(ActionEvent event) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

}
