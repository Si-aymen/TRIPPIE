/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Client;
import edu.webuild.utils.MyConnection;
import java.io.InputStream;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

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
    private TextField fxnom;
    @FXML
    private TextField fxprenom;
    private static String currentUserEmail;
    @FXML
    private TextField fxemail;
    private String email;

    public void setEmail(String email) {
        this.email = email;
        currentUserEmail = email;
        System.out.println(email);
      
      
    }

    public void setFxnom(TextField fxnom) {
        this.fxnom = fxnom;
    }

    public void setFxprenom(TextField fxprenom) {
        this.fxprenom = fxprenom;
    }

    public void setFxemail(TextField fxemail) {
        this.fxemail = fxemail;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            fxemail.setText(email);
        // Check if there is a current user email
       /* if (email != null) {
            System.out.println("im here");
              System.out.println(email); 
            // Use the current user email to display the user's details
            try (Connection connection = MyConnection.getInstance().getConn()) {
                String query = "SELECT utilisateur.nom, utilisateur.prenom, utilisateur.email "
                        + "FROM utilisateur "
                        + "JOIN role ON utilisateur.id_user = role.id_user "
                        + "JOIN client ON role.id_role = client.id_role "
                        + "WHERE email = ? ";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    fxnom.setText(nom);
                    fxprenom.setText(prenom);
                    fxemail.setText(email);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
       
    }

    @FXML
    private void exit(ActionEvent event
    ) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

}
