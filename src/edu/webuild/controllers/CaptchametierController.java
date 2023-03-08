/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class CaptchametierController implements Initializable {

    @FXML
    private Label captcha;
    @FXML
    private TextField fx_resultat_captcha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  CaptchametierController t = new CaptchametierController();
      captcha.setText(getCaptcha());
         
        // TODO
    }    
     public  String getCaptcha() {
        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9'};
        char index[] = new char[7];

        Random r = new Random();
        int i = 0;
        for (i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
        }
        return new String(index);
    }
     public String sauvegarde()
     {
      String   x=getCaptcha();
      return x ;
     }

    @FXML
    private void verif(ActionEvent event) {
        System.out.println(getCaptcha());
     
         String resultat = fx_resultat_captcha.getText();
         System.out.println(resultat);
        
      
    if(sauvegarde().equals(resultat))
        
    {
        System.out.println("ok");
    }
    else 
    {
        System.out.println("n est pas identique");
    }
        
    }
    
}
