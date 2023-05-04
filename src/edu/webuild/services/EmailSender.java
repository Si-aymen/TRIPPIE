package edu.webuild.services;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailSender {

    private static final String USERNAME = "aymen.rahali@esprit.tn";
    private static final String PASSWORD = "tumlrjgqhmlmbpwt";

    public static void sendEmail_add(String toEmail, String message) {
        //String toEmail = "manouch2001.ra@gmail.com";
        String subject = "Trippie Add Cov_voiturage ";
        //String message = "confirmation email";

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
//    public static void sendEmail_add(String toEmail, String message, File pdfFile) {
//    String fromEmail = "your.email@gmail.com";
//    String password = "yourpassword";
//
//    Properties props = new Properties();
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "true");
//    props.put("mail.smtp.host", "smtp.gmail.com");
//    props.put("mail.smtp.port", "587");
//
//    Session session = Session.getInstance(props, new Authenticator() {
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(fromEmail, password);
//        }
//    });
//
//    try {
//        Message emailMessage = new MimeMessage(session);
//        emailMessage.setFrom(new InternetAddress(fromEmail));
//        emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//        emailMessage.setSubject("Trippie Add Cov_voiturage");
//
//        // Create the message part for the message body
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setText(message);
//
//        // Create the message part for the attachment
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        DataSource source = new FileDataSource(pdfFile);
//        attachmentPart.setDataHandler(new DataHandler(source));
//        attachmentPart.setFileName(pdfFile.getName());
//
//        // Create a multipart message and add the message body and attachment to it
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        multipart.addBodyPart(attachmentPart);
//
//        // Set the content of the message to the multipart object
//        emailMessage.setContent(multipart);
//
//        // Send the message
//        Transport.send(emailMessage);
//        System.out.println("Email sent successfully.");
//    } catch (MessagingException e) {
//        throw new RuntimeException(e);
//    }
//}

    public static void sendEmail_mod(String toEmail, String subject) {

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
