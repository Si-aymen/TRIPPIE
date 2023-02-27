package edu.webuild.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import static java.lang.ProcessBuilder.Redirect.to;

public class SmS_Cov {
    // Find your Account Sid and Token at twilio.com/console

    public static final String ACCOUNT_SID = "AC1ed373981440ff3b6ccefc4eb68223b7";
    public static final String AUTH_TOKEN = "12e649ee6be8f46c2a00151f1427739a";

    public void send_message(String To, String value) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message;
        //message = Message.creator(new com.twilio.type.PhoneNumber(To), new com.twilio.type.PhoneNumber("+12766226509"), value).create();
        message = Message.creator(new com.twilio.type.PhoneNumber(To), new com.twilio.type.PhoneNumber("+12766226509"), value).create();

        System.out.println(message.getSid());
    }
}
