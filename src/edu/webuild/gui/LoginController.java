/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.gui;

import edu.webuild.controllers.ProfilChauffeurController;
import edu.webuild.controllers.ProfilClientController;
import edu.webuild.controllers.ProfilLocateurController;
import edu.webuild.controllers.WelcomeController;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.LocateurCRUD;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
    @FXML
    private ChoiceBox<String> fxchoice;
    private String email;
    static String SSemail;
    @FXML
    private ToggleButton showbtnnewnew;
    private boolean labelVisible = false;

    public void setMain(FirstWindow main) {
        this.main = main;

    }

    public void setTxtusername(String email) {
        this.txtusername.setText(email);
    }

    public void initialize() {
        fxchoice.getItems().addAll("Client", "Chauffeur", "Locateur", "Admin");
        fxchoice.setValue("Client"); // sélectionne "Option 1" comme valeur par défaut
        showbtnnewnew.setOnAction(event -> {
            if (showbtnnewnew.isSelected()) {
            txtpass.setPromptText(txtpass.getText());
            txtpass.setText("");
        } else {
            txtpass.setText(txtpass.getPromptText());
            txtpass.setPromptText("");
        }
        });
    }

//    private boolean validateInput() throws SQLException, NoSuchAlgorithmException {
//        boolean isValid = true;
//        String email = txtusername.getText();
//        String password = txtpass.getText();
//        String role=fxchoice.getValue();
//
//        ClientCRUD cc = new ClientCRUD();
//
//        // Validate email address
//        if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email)) {
//            isValid = false;
//            txtusername.setStyle("-fx-border-color: red;");
//        } else {
//            txtusername.setStyle("");
//        }
//
//        // Validate password
//        if (password.isEmpty()) {
//            isValid = false;
//            txtpass.setStyle("-fx-border-color: red;");
//        } else {
//            txtpass.setStyle("");
//        }
//        if (!cc.FoundClient(email, password)) {
//            isValid = false;
//
//        }
//
//        return isValid;
//    }
    @FXML
    public void exit(ActionEvent event) throws IOException {
        exitBtn.setOnAction(e -> Platform.exit());
    }


    private boolean validateInput() throws SQLException, NoSuchAlgorithmException {
        boolean isValid = true;
        String email = txtusername.getText();
        String password = txtpass.getText();

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

        // Validate user based on selected choice
        String selectedUser = fxchoice.getValue();
        if (selectedUser.equals("Client")) {
            ClientCRUD cc = new ClientCRUD();
            if (!cc.FoundClient(email, password)) {
                isValid = false;
            }
        } else if (selectedUser.equals("Chauffeur")) {
            ChauffeurCRUD cr = new ChauffeurCRUD();
            if (!cr.FoundChauffeur(email, password)) {
                isValid = false;
            }
        } else if (selectedUser.equals("Locateur")) {
            // Add validation for locateur
            LocateurCRUD lc = new LocateurCRUD();
            if (!lc.FoundLocateur(email, password)) {
                isValid = false;
            }
        }

        return isValid;
    }

    @FXML
    public void login(ActionEvent event) throws IOException, SQLException, NoSuchAlgorithmException {
        String email = txtusername.getText();
        String password = txtpass.getText();
        String userType = fxchoice.getValue();

        if (validateInput()) {
            switch (userType) {
                case "Client":
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilClient.fxml"));
                    Parent root = loader.load();
                    ProfilClientController dc = loader.getController();
                    txtusername.getScene().setRoot(root);
                    dc.setEmail_lbl(email);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                    break;
                case "Chauffeur":
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("ProfilChauffeur.fxml"));
                    Parent root2 = loader2.load();
                    ProfilChauffeurController pc = loader2.getController();
                    txtusername.getScene().setRoot(root2);
                    pc.setEmail_lbl(email);
                    Scene scene2 = new Scene(root2);
                    Stage stage2 = (Stage) loginBtn.getScene().getWindow();
                    stage2.setScene(scene2);
                    stage2.show();

                    break;
                case "Locateur":

                    // ouvrir la fenêtre d'accueil pour les locateurs
                    FXMLLoader loader3 = new FXMLLoader(getClass().getResource("ProfilLocateur.fxml"));
                    Parent root3 = loader3.load();
                    ProfilLocateurController lc = loader3.getController();
                    txtusername.getScene().setRoot(root3);
                    lc.setEmail_lbl(email);
                    Scene scene3 = new Scene(root3);
                    Stage stage3 = (Stage) loginBtn.getScene().getWindow();
                    stage3.setScene(scene3);
                    stage3.show();

                    break;
//                case "Admin":
//                    // valider les informations d'identification de l'administrateur
//                    if (adminCRUD.foundAdmin(email, password)) {
//                        // ouvrir la fenêtre d'accueil pour les administrateurs
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
//                        Parent root = loader.load();
//                        Scene scene = new Scene(root);
//                        Stage stage = (Stage) loginBtn.getScene().getWindow();
//                        stage.setScene(scene);
//                        stage.show();
//                    } else {
//                        // afficher un message d'erreur si les informations d'identification sont incorrectes
//                        showError("Nom d'utilisateur ou mot de passe incorrect");
//                    }
//                    break;

            }
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
