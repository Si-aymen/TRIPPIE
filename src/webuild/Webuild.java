/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import java.sql.SQLException;

import edu.webuild.model.*;
import edu.webuild.services.*;

/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        /// MyConnection conn = MyConnection.getInstance();
        voiture vo1 = new voiture("122tunis1259", "clio", "5ch", 280);
        voiture vo2 = new voiture("122tunis1259", "clio", "5ch", 450);
        voiture vo4 = new voiture("1259", "clio", "5ch", 280);
        voiture vo3 = new voiture("122tunis1259", "clio", "5ch", 280);
        voitureCRUD voit = new voitureCRUD();

        //    voi.ajoutervoiture(vo2);
        //voi.ajouterPersonne2(vo1);
        // System.out.println( voit.affichervoitures());
        voiture mod = new voiture("hhhh", "dtftdt", "hhhhhh", 10000);
        // voi.modifiervoiture(mod,18);
        //    System.out.println( voi.affichervoitures());
        // voi.supprimervoiture(18);
        // System.out.println("les donnes concernat votre rechercher est ");
        //    System.out.println(voi.getUserByID(25)); 
        //   System.out.println(voi.triervoiture());
        //System.out.println(voi.Filter_voiture("puissance", "5ch"));
        //------------------------------------------------------------------------------------/
        //    System.out.println("---------------- partie reservation -----------------------------");
        reservation re1 = new reservation("12/10/2022", "14/05/2021", 32);
        // reservation r2=new reservation("12/10/2052","14/05/2021");
        reservationCRUD rev = new reservationCRUD();
        //  rev.ajouterreservation(r1);
        //   System.out.println( rev.afficherreservations());
        //  rev.supprimerreservation(10);
        //       System.out.println( rev.afficherreservations());

        //  reservation mod1 = new reservation("2ihkakakakkakakakka88","25/2020");
        // rev.modifierreservation(mod1,11);
        //  System.out.println( rev.afficherreservations());
        //    System.out.println("les donnes concernat votre rechercher est ");
        // System.out.println(rev.getUserByIDre(10)); 
        //   System.out.println(rev.trierReservation());
        System.out.println(rev.Filter_reservation("date_debut", "12/10/2022"));

        // TODO code application logic here
        CoVoiturage v1 = new CoVoiturage("rades", "Esprit", "11/02/2023", 4);
        CoVoiturage v2 = new CoVoiturage("manzah", "boumhal", "10/12/2022", 4);
        CoVoiturage v3 = new CoVoiturage("ariena", "naser", "18/02/2022", 2);
        CoVoiturage v4 = new CoVoiturage("naser", "ariena", "18/02/2022", 4);

        Participation p1 = new Participation(2, 2);
        Participation p2 = new Participation(2, 4);
        Participation p3 = new Participation(7, 7);
        Participation p4 = new Participation(3, 8);
        Participation p5 = new Participation(2, 6);

        CoVoiturageCRUD voi = new CoVoiturageCRUD();
        ParticipationCrud part = new ParticipationCrud();
        //voi.ajouterCoVoiturage(v4);
        //voi.ajouterCoVoiturage2(v3);
        // System.out.println( voi.afficherCoVoiturage());
        //voi.supprimerCoVoiturage(2);
        // System.out.println( voi.afficherCoVoiturage());
        // voi.modifierCoVoiturage(v3,1);
        //System.out.println( voi.afficherCoVoiturage());
        //System.out.println( voi.rechCoVoiturage(1));
        System.out.println(voi.afficherCoVoiturage());

        System.out.println(voi.Filter_CoVoiturage("nmbr_place", "4"));
        System.out.println(voi.Filter_CoVoiturage("destination", "tunis"));
        // part.ajouterParticipation(p3);
        //part.ajouterParticipation2(p3);
        //part.ajouterParticipation(p4);
        //System.out.println(part.afficherParticipation());
        //part.modifierParticipation(p5,26);
        // part.supprimerParticipation(26);
        //System.out.println(part.afficherParticipation() );

        // System.out.println(part.rechParticipation(28));
        System.out.println(part.Filter_Participation("nmbr_place_part", "3"));
        System.out.println(part.Filter_Participation("id_part", "3"));

        /*-------------------------------Instance CRUD--------------------------------------------------------------------*/
        utilisateurCRUD uc = new utilisateurCRUD();
        roleCRUD rc = new roleCRUD();
        ChauffeurCRUD cc = new ChauffeurCRUD();
        ClientCRUD clc = new ClientCRUD();
        LocateurCRUD l = new LocateurCRUD();

        /*-----------------------------Role--------------------------------------------*/
        Role r1 = new Role(1, "Client");
        Role r2 = new Role(2, "Chauffeur");
        Role r3 = new Role(3, "Locateur");
        //rc.ajouterRole(r1);
        //rc.ajouterRole(r2);
        //rc.ajouterRole(r3);
        //rc.modifierRole(r3);
        //System.out.println(rc.afficherRole());
        //rc.supprimerRole(1);

        /*------------------------------Utilisateur-------------------------------------------------------------------------------*/
        Utilisateur u1 = new Utilisateur("12345678", "Zouari", "Aymen", "Homme", 44, 1);
        Utilisateur u2 = new Utilisateur(5, "12345677", "zwaaaw", "zzaa", "Femme", 24, 2);
        Utilisateur u3 = new Utilisateur("22245679", "Zouari", "Aymen", "Homme", 25, 3);
        Utilisateur u4 = new Utilisateur("23456789", "Saidi", "Fatma", "Femme", 28, 2);
        Utilisateur u5 = new Utilisateur("34567890", "Boudali", "Ali", "Homme", 35, 1);
        Utilisateur u6 = new Utilisateur("45678901", "Ghazi", "Nour", "Femme", 22, 2);
        Utilisateur u7 = new Utilisateur("56789012", "Hamdi", "Karim", "Homme", 31, 3);
        Utilisateur u8 = new Utilisateur("67890123", "Fakhfakh", "Nada", "Femme", 26, 2);
        Utilisateur u9 = new Utilisateur("78901234", "Ben Hamouda", "Marwen", "Homme", 29, 1);
        Utilisateur u10 = new Utilisateur("89012345", "Moussa", "Hela", "Femme", 37, 3);
        Utilisateur u11 = new Utilisateur("90123456", "Kouki", "Samir", "Homme", 41, 3);
        Utilisateur u12 = new Utilisateur("01234567", "Ben Ammar", "Safa", "Femme", 24, 2);
        //uc.ajouterUtilisateur(u1);
        //uc.ajouterUtilisateur(u2);
        //uc.ajouterUtilisateur(u3);
        //uc.ajouterUtilisateur(u4);
        //uc.ajouterUtilisateur(u5);
        //uc.ajouterUtilisateur(u6);
        //uc.ajouterUtilisateur(u7);
        //uc.ajouterUtilisateur(u8);
        //uc.ajouterUtilisateur(u9);
        //uc.ajouterUtilisateur(u10);
        //uc.ajouterUtilisateur(u11);
        //uc.ajouterUtilisateur(u12);
        // uc.ajouterUtilisateur(u1);
        // uc.ajouterUtilisateur(u2);
        //uc.ajouterUtilisateur(u3);
        //uc.modifierUtilisateur(u2);
        //uc.supprimerUtilisateurByCin("22245679");
        System.out.println(uc.afficherUtilisateur());
        //System.out.println(uc.getById(6));
        //System.out.println(uc.FiltrerUtilisateur("sexe","Femme"));
        // System.out.println(uc.trierUtilisateur());
        //System.out.println((uc.afficherUtilisateur()));
        /*---------------------------------Chauffeur----------------------------------------------------------------------------*/
        Chauffeur c1 = new Chauffeur(1, 2, 5, "12345678", "Ford", "Bleu", "172TUNIS1234", "aymen.zouari@esprit.tn", "12345");
        // cc.ajouterChauffeur(c1);
        System.out.println(cc.afficherChauffeur());
        /*----------------------------------Client-------------------------------------------------------------------------------*/
        Client cli1 = new Client(1, 1, 4, "azeae", "aaa");
        // clc.ajouterClient(cli1);
        /*----------------------------------Locateur-------------------------------------------------------------------------------*/
        Locateur l1 = new Locateur(1, 3, 6, "TravelToDo", "zouari.aymen@traveltodo.tn", "12345");
        //System.out.println(l.afficherLocateur());
        //l.ajouterLocateur(l1);

        // uc.ajouterUtilisateur(u2);
        // uc.ajouterUtilisateur(u3);
        // cc.ajouterChauffeur(c1);
        //  uc.modifierUtilisateur(u2);
        System.out.println(uc.afficherUtilisateur());
        //  System.out.println(rc.afficherRole());
        //  
        //
        // 
    }
}
