package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class GetPasswordController implements Initializable {

    @FXML
    private TextField txtusername;

    static String Ssemail2;
    @FXML
    private Button btnRechercher;
    Client c = new Client();
    Chauffeur ch = new Chauffeur();
    Locateur loc = new Locateur();

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
    private void Rechercher(ActionEvent event) throws IOException, SQLException {
        if (validateInputs()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/IdentifierCompte.fxml"));
            Parent rat = loader.load();
            IdentifierCompteController dc = loader.getController();
            String email = txtusername.getText();
            Ssemail2 = txtusername.getText();
            dc.setUserInformation(email);
            // Create a new scene with the loaded FXML file and show it
            Scene scene = new Scene(rat);
            Stage stage = (Stage) btnRechercher.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

    private boolean validateInputs() throws SQLException {

        if (txtusername.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur");
            alert1.setContentText("Veuillez remplir tous les champs");
            alert1.setHeaderText("Controle de saisie");
            alert1.show();
            return false;
        } else if (!(txtusername.getText().equals(c.getEmail()) || txtusername.getText().equals(ch.getEmail()) || txtusername.getText().equals(loc.getEmail()))) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Erreur");
            alert2.setContentText("L'adresse email est incorrecte");
            alert2.setHeaderText(null);
            alert2.show();
            return false;
        }
        return true;

    }
}
