/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

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
import static edu.webuild.controllers.GetPasswordController.Ssemail2;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Role;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.roleCRUD;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import edu.webuild.controllers.IdentifierCompteController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
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
public class Ajouter_chauffeurController implements Initializable {

    @FXML
    private TextField fxperm;
  
    @FXML
    private TextField fxmail;
    @FXML
    private TextField fxpass;
    @FXML
    private Button btn;
    @FXML
    private TextField fxid;
    @FXML
    private ToggleButton showbtnnewnew;
    @FXML
    private PasswordField fxpass1;
    @FXML
    private ToggleButton showbtnnewnew1;
    private Gmail service;
    @FXML
    private TextField fxtel;
    private static final String TEST_EMAIL = "zouari.aymen@esprit.tn";
    @FXML
    private Button btnimg;
    @FXML
    private ImageView fximg;
     static String url_image;
    static String image;
    /**
     *
     * @param id
     */
    public void SetId_role(String id) {
        this.fxid.setText(id);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          image = url_image;
        showbtnnewnew.setOnAction(event -> {
            if (showbtnnewnew.isSelected()) {
                fxpass.setPromptText(fxpass.getText());
                fxpass.setText("");
            } else {
                fxpass.setText(fxpass.getPromptText());
                fxpass.setPromptText("");
            }
        });
        showbtnnewnew1.setOnAction(event -> {
            if (showbtnnewnew1.isSelected()) {
                fxpass1.setPromptText(fxpass1.getText());
                fxpass1.setText("");
            } else {
                fxpass1.setText(fxpass1.getPromptText());
                fxpass1.setPromptText("");
            }
        });
    }

    @FXML
    private void addch(ActionEvent event) throws Exception {
          String img = url_image;
        Role r = new Role();
        roleCRUD rc = new roleCRUD();
        r.setId_role(Integer.parseInt(fxid.getText()));
        String num_permis = fxperm.getText();
   
        String email = fxmail.getText();
        String password = fxpass.getText();
      
        int tel = Integer.parseInt(fxtel.getText());

        // Définir la regex pour valider l'adresse e-mail
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (num_permis.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please complete all fields.");
            alert.show();

        } else if (!email.matches(regex)) {
            // Afficher un message d'erreur si la saisie est invalide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
        } else if (!(fxpass.getText().equals(fxpass1.getText()))) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Wrong password.");
            alert.showAndWait();

        } else {
            Chauffeur ch = new Chauffeur(r, img, num_permis, tel, email, password);
            rc.affecterRole(ch, r);

//            String subject="Tripee";
//            String message="Registration successfully";
//            sendMail(subject, message);
         
          
        }
    }
    
  
      public void sendMail(String subject, String message) throws Exception, EncoderException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(TEST_EMAIL));
        email.addRecipient(TO, new InternetAddress(fxmail.getText()));// static variable globale static
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

    @FXML
    private void image(ActionEvent event) {
          ImageView imageView = fximg;

        // Create a FileChooser
        FileChooser fileChooser = new FileChooser();

        // Add a filter to only show image files
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
        );

        // Get the primary stage from the image view
        Stage primaryStage = (Stage) imageView.getScene().getWindow();

        // Show the file chooser dialog
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            // Load the selected image into the image view
            Image image = new Image(file.toURI().toString());

            //url_image = file.toURI().toString();
            System.out.println(file.toURI().toString());
            imageView.setImage(image);

            // Create a new file in the destination directory
            File destinationFile = new File("C:\\xampp\\htdocs\\" + file.getName());
            // url_image = "C:\\xampp\\htdocs\\image_trippie_cov\\" + file.getName();
            url_image = file.getName();

            try {
                // Copy the selected file to the destination file
                Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
