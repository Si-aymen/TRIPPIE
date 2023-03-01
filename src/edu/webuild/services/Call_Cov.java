/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import java.net.URI;

/**
 *
 * @author manou
 */
public class Call_Cov {

    public static final String ACCOUNT_SID = "AC1ed373981440ff3b6ccefc4eb68223b7";
    public static final String AUTH_TOKEN = "12e649ee6be8f46c2a00151f1427739a";

    public void cal(String TO) {
        System.out.println(ACCOUNT_SID);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Call call;
        call = Call.creator(new com.twilio.type.PhoneNumber("+21692554097"), new com.twilio.type.PhoneNumber("+12766226509"), URI.create("http://demo.twilio.com/docs/voice.xml")).create();
        System.out.println(call.getSid());
    }

}
