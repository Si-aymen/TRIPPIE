/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static edu.webuild.controllers.GetPassword2Controller.Ssemail2;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author aymen
 */
public class SendPassword2Controller implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button loginBtn;
    @FXML
    private PasswordField txtpass1;
    @FXML
    private PasswordField txtcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Confirm(ActionEvent event) throws SQLException, IOException {
         if (validateInputs()) {
            try {
                ChauffeurCRUD cc = new ChauffeurCRUD();
                String email = txtusername.getText();
                String mdp = txtpass.getText();
                cc.changePassword(mdp, email);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Updated");
                alert.setContentText("Password updated successfully");
                alert.showAndWait();

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SendPassword2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
      private boolean validateInputs() throws SQLException {
        ChauffeurCRUD cc = new ChauffeurCRUD();
        Chauffeur c = cc.getChauffeur(Ssemail2);
        if (txtusername.getText().isEmpty() || txtpass.getText().isEmpty() || txtpass1.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur");
            alert1.setContentText("Please complete all fields");
            alert1.setHeaderText("Input Control");
            alert1.show();
            return false;
        } else if (!(txtpass.getText().equals(txtpass1.getText()))) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Error");
            alert2.setContentText("Verify your password");
            alert2.setHeaderText(null);
            alert2.show();
            return false;
        } else if (!(txtcode.getText().equals(c.getPassword()))) {

            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Error");
            alert2.setContentText("Wrong code");
            alert2.setHeaderText(null);
            alert2.show();
            return false;
        }
        return true;

    }

    
}
