/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private String fromEmail;
    private String password;
    private String toEmail;
    private String subject;
    private String message;

    public Email(String fromEmail, String password, String toEmail, String subject, String message) {
        this.fromEmail = fromEmail;
        this.password = password;
        this.toEmail = toEmail;
        this.subject = subject;
        this.message = message;
    }

    public void sendEmail() throws MessagingException {
        // Configuration des propriétés SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // Configuration de l'authentification
        Session session = Session.getInstance(props,
                new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        //session.setDebug(true);
        // Création du message
        Message e_message = new MimeMessage(session);
        e_message.setFrom(new InternetAddress(fromEmail));
        e_message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        e_message.setSubject(subject);
        e_message.setText(this.message);

        // Envoi du message
        Transport.send(e_message);
        
        System.out.println("mail envoyé avec succés");
    }
}
