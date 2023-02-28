/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author zaefdfyjhlk
 */
public class Mailing {

    public String host = "smtp.gmail.com";
    public String user = "slowlife.testpi@gmail.com";
    public String pass = "slowlife3a4";
    public String from = "slowlife.testpi@gmail.com";

    public void sendEmail(String toEmail, String subject, String body) {
        try {

            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(toEmail)};

            msg.setRecipients(Message.RecipientType.TO, address);
            //msg.setSentDate(new Date());
            msg.setSubject(subject);
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);

            try (Transport transport = mailSession.getTransport("smtp")) {
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
            }
            System.out.println("Email envoyé");

        } catch (MessagingException e) {
            System.err.println(e);
        }
    }

}
