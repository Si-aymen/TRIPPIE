/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author khmir
 */
public class CardvoitureController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label fx_matricule;
    @FXML
    private Label fx_marque;
    @FXML
    private Label fx_puissance;
    @FXML
    private Label fx_prix_par_jour;
    @FXML
    private Label fx_energie;
    @FXML
    private Label fx_etat;
    static voiture vo = new voiture();
    private MyListener myListener;

    private Label id;
    @FXML
    private Label id_voit;

    /**
     * Initializes the controller class.
     */
    public void setData(int id, String matricule, String marque, String puissance, String url, String prix_jour, String energie, String etat, MyListener myListener) {
        this.myListener = myListener;
        this.id_voit.setText(Integer.toString(id));
        fx_matricule.setText(matricule);
        fx_marque.setText(marque);
        fx_puissance.setText(puissance);
        String fullurl = "C:\\xampp\\htdocs\\image_trippie_cov\\" + url;
        fx_prix_par_jour.setText(prix_jour);
        fx_energie.setText(energie);
        fx_etat.setText(etat);

        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void onClick() {
        myListener.onClick(vo);

    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    @FXML
    private void Click(MouseEvent event) {
        InterfaceCRUD inter = new voitureCRUD();
        List<voiture> L = new ArrayList<>();
        myListener.onClick(vo);

        L = inter.rechVoiture(Integer.parseInt(id_voit.getText()));

        vo.setId(L.get(0).getId());
        vo.setMatricule(L.get(0).getMatricule());
        vo.setMarque(L.get(0).getMarque());
        vo.setPuissance(L.get(0).getPuissance());
        vo.setEnergie(L.get(0).getEnergie());
        vo.setPrix_jours(L.get(0).getPrix_jours());
        vo.setEtat(L.get(0).getEtat());

        vo.setImage_voiture(L.get(0).getImage_voiture());

    }

    static class MyListener2 {

        public MyListener2() {
        }
    }

    public interface MyListener {

        void onClick(voiture voi);
    }

}
