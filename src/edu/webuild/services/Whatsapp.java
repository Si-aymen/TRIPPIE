package edu.webuild.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Whatsapp {

    private static final String ACCOUNT_SID = "AC1ed373981440ff3b6ccefc4eb68223b7";
    private static final String AUTH_TOKEN = "12e649ee6be8f46c2a00151f1427739a";

    public void sendWhatsappMessage(String toNumber, String messageBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + toNumber),
                new PhoneNumber("whatsapp: +12766226509"),
                messageBody)
                .create();
        System.out.println("Sent message with SID: " + message.getSid());
    }
}
