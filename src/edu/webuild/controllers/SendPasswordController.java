package edu.webuild.controllers;

import static com.sun.glass.ui.Cursor.setVisible;
import static edu.webuild.controllers.Affiche_chController.email;
import static edu.webuild.controllers.Affiche_chController.password;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    int randomCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Confirm(ActionEvent event) {
        ChauffeurCRUD chcrud=new ChauffeurCRUD();
        Chauffeur ch=new Chauffeur(email, password);
        if (txtusername.getText().equals(txtpass.getText())) {
//check whether the user enter same password in both textfield
            try {
                chcrud.resetPass(ch);
                JOptionPane.showMessageDialog(null, "Reset Successfully");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "password do not match");
        }
    }

}
