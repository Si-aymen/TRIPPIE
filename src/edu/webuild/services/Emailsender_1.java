/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author khmir
 */
public class Emailsender_1 {
     private static final String USERNAME = "khmiri.iheb@esprit.tn";
    private static final String PASSWORD = "a1b2c3IHEB";
    
     public static void sendEmail_add(String toEmail,String message ) {
        
        String subject = "Trippie Add Cov_voiturage ";
     

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session;
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(USERNAME));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendEmail_mod(String toEmail,String subject) {

        //String subject = "Trippie modify Cov_voiturage ";
        String message = "confirmation email";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session;
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(USERNAME));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
