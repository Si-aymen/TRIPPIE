package edu.webuild.controllers;

import edu.webuild.services.ChauffeurCRUD;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class GetPasswordController implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button loginBtn;

    @FXML
    private Button loginBtn1;
    int randomCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private int generateVerificationCode() {
        // générer un nombre aléatoire entre 100000 et 999999
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    private void sendVerificationCode(String recipientEmail, int verificationCode) {
        // adresse e-mail de l'expéditeur
        String senderEmail = "aymen58zouari@gmail.com";

        // mot de passe de l'expéditeur
        String senderPassword = "aymenzouari1";

        // adresse e-mail du serveur SMTP à utiliser pour envoyer l'e-mail
        String smtpServer = "smtp.gmail.com";

        // port SMTP à utiliser pour l'envoi des e-mails
        int smtpPort = 587;

        // créer une session SMTP avec les paramètres de configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
        props.put("mail.smtp.host", smtpServer);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // créer un message e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Code de vérification");
            message.setText("Votre code de vérification est : " + verificationCode);

            // envoyer le message
            Transport.send(message);
        } catch (MessagingException e) {
            // gérer les erreurs liées à l'envoi de l'e-mail
            e.printStackTrace();
        }
    }

    @FXML
    private void Codeverif(ActionEvent event) {
        // récupérer l'adresse e-mail du destinataire
        String recipientEmail = txtusername.getText();

        // générer un code de vérification aléatoire
        int verificationCode = generateVerificationCode();

        // envoyer le code de vérification par e-mail
        sendVerificationCode(recipientEmail, verificationCode);
    }

    @FXML
    private void Verif(ActionEvent event
    ) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sendcode.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            // Hide the current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (txtpass.getText().equals(String.valueOf(randomCode))) {
            try {
                int code = Integer.parseInt(txtpass.getText());
                if (code == randomCode) {
                    // Open the reset password form
                } else {
                    JOptionPane.showMessageDialog(null, "Code do not match");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid code format");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid code");
        }
    }

}
