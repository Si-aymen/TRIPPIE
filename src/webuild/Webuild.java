/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.services.*;
import java.sql.Date;
import java.time.ZoneId;
import java.util.Set;

/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SmS_Cov send = new SmS_Cov();
        //send.send_message("+21692554097", "test the msg 10th time");
        Call_Cov test_call = new Call_Cov(); 
        test_call.cal("+21692554097");

    }

}
