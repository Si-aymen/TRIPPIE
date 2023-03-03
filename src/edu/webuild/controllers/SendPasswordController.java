package edu.webuild.controllers;

import static com.sun.glass.ui.Cursor.setVisible;
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

    @FXML
    private PasswordField txtpass1;
    private PasswordField ancien;
    Client c = new Client();
    ClientCRUD cC = new ClientCRUD();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Confirm(ActionEvent event) throws SQLException {
        if (validateInputs()) {
            try {
                ClientCRUD cc = new ClientCRUD();
                String email = txtusername.getText();
                String mdp = txtpass.getText();
                cc.changePassword(mdp, email);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Succès");
                alert.setHeaderText("Modifié");
                alert.setContentText("Mot de passe changé avec succès");
                alert.showAndWait();

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

    private boolean validateInputs() throws SQLException {

        if (txtusername.getText().isEmpty() || txtpass.getText().isEmpty() || txtpass1.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur");
            alert1.setContentText("Veuillez remplir tous les champs");
            alert1.setHeaderText("Controle de saisie");
            alert1.show();
            return false;
        }
        else if (!(txtpass.getText().equals(txtpass1.getText()))) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Erreur");
            alert2.setContentText("Veuillez vérifier votre nouveau mot de passe");
            alert2.setHeaderText(null);
            alert2.show();
            return false;
        }
      
        return true;

    }

}
