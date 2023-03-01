package edu.webuild.controllers;

import static com.sun.glass.ui.Cursor.setVisible;
import static edu.webuild.controllers.Affiche_chController.email;
import static edu.webuild.controllers.Affiche_chController.password;
import static edu.webuild.controllers.GetPasswordController.Ssemail2;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class SendPasswordController implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button loginBtn;
    
    ClientCRUD cc = new ClientCRUD();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Confirm(ActionEvent event) throws SQLException {
        Client c = cc.getClientbymail(Ssemail2);
        System.out.println(c);
        if (!c.getToken().equals(txtusername.getText())) {
            
        } else {
            c.setEmail(txtpass.getText());
            cc.modifierClient(c);
        }
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SendPasswordController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
