/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.controllers.WelcomeController;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author hoxha
 */
public class LoginController {

   
    @FXML
    private Button forgotBtn;
   

 
  

    @FXML
    private TextField txtusername;

    @FXML
    private Button loginBtn;


    @FXML
    private PasswordField txtpass;


    @FXML
    private Button exitBtn;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private FirstWindow main;

    
     public void setMain(FirstWindow main) {
        this.main = main; 
       
    }
    
     private boolean validateInput() throws SQLException, NoSuchAlgorithmException {
        boolean isValid = true;
        String email = txtusername.getText();
        String password = txtpass.getText();
 

ClientCRUD cc = new ClientCRUD();

        // Validate email address
        if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email)) {
            isValid = false;
            txtusername.setStyle("-fx-border-color: red;");
        } else {
            txtusername.setStyle("");
        }

        // Validate password
        if (password.isEmpty()) {
            isValid = false;
            txtpass.setStyle("-fx-border-color: red;");
        } else {
            txtpass.setStyle("");
        }
        if (!cc.FoundUser(email, password)) {
            isValid = false;

        }

        return isValid;
    }

    
    
    @FXML
    public void exit(ActionEvent event) throws IOException {
        exitBtn.setOnAction(e -> Platform.exit());
    }

    @FXML
    void login(ActionEvent event) throws IOException, SQLException, NoSuchAlgorithmException {

        if (validateInput()) {

            String email = txtusername.getText();
           
            //User u = userService.getUserByEmai(email); // l'email de l'utilisateur connecté
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilClient.fxml"));

            Parent root = loader.load();
            WelcomeController dc = loader.getController();
            

            

            // Create a new scene with the loaded FXML file and show it
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    public void signupScene(ActionEvent event) throws IOException {
        Parent view3 = FXMLLoader.load(getClass().getResource("ajouter_user.fxml"));
        Scene scene3 = new Scene(view3);
        Stage window = new Stage();
        window.setScene(scene3);
        window.show();
    }

    @FXML
    public void forgotPsw(ActionEvent event) throws IOException {
        
        Parent view4 = FXMLLoader.load(getClass().getResource("GetPassword.fxml"));
        Scene scene4 = new Scene(view4);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.show();
    }

   
}
