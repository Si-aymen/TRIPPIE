/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;


import edu.webuild.model.Chauffeur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import static edu.webuild.controllers.GetPassword2Controller.Ssemail2;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.repackaged.org.apache.commons.codec.EncoderException;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import com.google.api.services.gmail.model.Message;
import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.model.Chauffeur;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javax.mail.Message.RecipientType.TO;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class IdentifierCompteChController implements Initializable {

    @FXML
    private ListView<Chauffeur> cli;
    @FXML
    private Label ssemails;
    private ChauffeurCRUD chauffeurCRUD;
    private Gmail service;
    private static final String TEST_EMAIL = "zouari.aymen@esprit.tn";
    ChauffeurCRUD cc = new ChauffeurCRUD();
      

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        {
            try {
                Chauffeur ch =  cc.getChauffeur(Ssemail2);
            } catch (SQLException ex) {
                Logger.getLogger(IdentifierCompteChController.class.getName()).log(Level.SEVERE, null, ex);
            }
            chauffeurCRUD = new ChauffeurCRUD();
            cli.setCellFactory(param -> new ListCell<Chauffeur>() {
                @Override
                protected void updateItem(Chauffeur user, boolean empty) {
                    super.updateItem(user, empty);
                    if (empty || user == null) {
                        setText(null);
                    } else {
                        setText(user.getEmail() + " ");
                    }
                }
            });
            cli.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Display an alert to confirm password reset
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Password reset confirmation");
                    alert.setHeaderText("You are about to reset the user's password " + newValue.getEmail());
                    alert.setContentText("Are you sure you want to continue ?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        // User confirmed password reset
                        // Generate a token and send a password reset email
                        String token = generateToken();
                        String emailAddress = newValue.getEmail();
                        try {
                            Chauffeur cli = cc.getChauffeur(Ssemail2);
                            cli.setPassword(token);
                            cc.modifierChauffeur(cli);
                            sendMail(emailAddress, token);
                        } catch (Exception ex) {
                            Logger.getLogger(IdentifierCompteChController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
    }

    public String generateToken() {
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        return token;
    }

    public void setUserInformation(String email) {
        ssemails.setText(email);
    }

    @FXML
    private void EnvoyerToken(MouseEvent event) {
        String email = ssemails.getText();
        try {
            List<Chauffeur> users = chauffeurCRUD.getChauffeurByEmail(email);
            ObservableList<Chauffeur> observableUsers = FXCollections.observableArrayList(users);
            cli.setItems(observableUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GMailer() throws Exception {
        System.out.println("gmail");
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("Webuild")
                .build();
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        Collection<String> gm = new ArrayList<>();
        System.out.println("cred");
        List<String> scopes = Arrays.asList(GMAIL_SEND);
        System.out.println();
        gm.add(GMAIL_SEND);
        String json = "{\"installed\":{\"client_id\":\"500444830183-ddvcoqhadvgupgvhkq6kjf2qmtlubncd.apps.googleusercontent.com\",\"project_id\":\"high-transit-379208\",\"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\"token_uri\":\"https://oauth2.googleapis.com/token\",\"auth_provider_x509_cert_url\":\"https://www.googleapis.com/oauth2/v1/certs\",\"client_secret\":\"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\",\"redirect_uris\":[\"http://localhost\"]}}";
        StringReader reader = new StringReader(json);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, reader);
        //GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(Identifier_votre_compteController.class.getResourceAsStream("‪C:\\Users\\aymen\\Desktop\\code_secret_client.json")));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, scopes)
                //.setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setDataStoreFactory(new FileDataStoreFactory(new File("/path/to/credential-store")))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void sendMail(String subject, String message) throws Exception, EncoderException {
        // Load email template

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(TEST_EMAIL));
        email.addRecipient(TO, new InternetAddress(Ssemail2));// static variable globale static
        System.out.println(Ssemail2);
        email.setSubject(subject);
        System.out.println("lena");
        email.setText(message);
        System.out.println("2");
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = new String(Base64.encodeBase64(rawMessageBytes));
        String safeString = encodedEmail.replace('+', '-').replace('/', '_');
        //String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            GMailer();
            System.out.println(msg);
            System.out.println("service");
            System.out.println(service);
            Message sentMessage = service.users().messages().send("me", msg).execute();
            System.out.println(sentMessage);
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }

    @FXML
    private void connecter(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/SendPassword2.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
