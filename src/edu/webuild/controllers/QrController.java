/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class QrController implements Initializable {

    @FXML
    private StackPane root;
     private String codeCoupon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createQRCode();
        // TODO
    }    
    private void createQRCode() {
   QRCodeWriter qrCoodeWriter = new QRCodeWriter();
       String k = "code_coupon:" + codeCoupon;
        int width = 300;
        int height = 300;
        String fileQR_codetype = "png";
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCoodeWriter.encode(k, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            System.err.append("success");
        } catch (WriterException ex) {
            Logger.getLogger(QrController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageView qrview = new ImageView();
        qrview.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        root.getChildren().add(qrview);
       
        
 }
     public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
          createQRCode();
    }
}
