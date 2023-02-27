package edu.webuild.controllers;

import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.utils.MyConnection;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
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
    private Connection connection;
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

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @FXML
    private void Codeverif(ActionEvent event) throws SQLException, NoSuchAlgorithmException, MessagingException {
        connection = MyConnection.getInstance().getConn();
        String email = txtusername.getText();
        if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir l'email.");
            alert.showAndWait();
            return;
        }
        // Generate a new password
        String newPassword = generateRandomPassword();
        // Encrypt the new password
        String encryptedPassword = encryptPassword(newPassword);
        // Update the user's password in the database
        String updateQuery = "UPDATE client SET password = ? WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, encryptedPassword);
            statement.setString(2, email);
            statement.executeUpdate();
        }
        // Send the new password to the user's email
        sendEmail(email, "Nouveau mot de passe", "Votre nouveau mot de passe est: " + newPassword);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Un nouveau mot de passe a été envoyé à votre adresse email!");
        alert.showAndWait();
    }

    private String generateRandomPassword() {
        // Generate a new password with 8 characters
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * passwordChars.length());
            passwordBuilder.append(passwordChars.charAt(index));
        }
        return passwordBuilder.toString();
    }

    private void sendEmail(String to, String subject, String body) throws MessagingException {
        String from = "aymen58zouari@gmail.com";
        String password = "ugfvtyktyzdbanue";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);
        System.out.println("ok");
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", 587, from, password);
        System.out.println("okkkkk");
        transport.sendMessage(message, message.getAllRecipients());
         
        transport.close();
       
    }

    @FXML
    private void Verif(ActionEvent event) {
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
