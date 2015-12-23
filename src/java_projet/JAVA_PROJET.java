/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;


import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Map.Entry;


/**
 *
 * @author Mathilde Bedel
 */
public class JAVA_PROJET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String lundi = "Lundi";
        String mardi = "Mardi";
        
        //Pays
        String P1, P2, P3;
        P1 = "France";
        P2 = "Angleterre";
        P3 = "Espagne";
        
        //Ville
        String V1, V2, V3;
        V1 = "Londres";
        V2 = "Toulouse";
        V3 = "Paris";
        
        //Avions
        Avion Av1, Av2, Av3;
        Av1 = new Avion (1);
        Av2 = new Avion(2);
        Av3 = new Avion(3);
        
        //Aéroports
        Aeroport A1, A2;
        A1 = new Aeroport( V2, P1);
        A2 = new Aeroport( V3, P1);
        
        //Heures de départ et d'arrivée
        LocalTime depart1 = LocalTime.parse("08:00:00");
        LocalTime arrive1 = LocalTime.parse("12:00:00");
        
        LocalTime depart2 = LocalTime.parse("06:00:00");
        LocalTime arrive2 = LocalTime.parse("07:00:00");
        
        LocalTime depart3 = LocalTime.parse("06:00:00");
        LocalTime arrive3 = LocalTime.parse("13:00:00");
        
        //Vol
        Vol v = new Vol(lundi, A1, A2, depart1, arrive1, (float)50.5 );
        Vol v2 = new Vol(lundi, A1, A2, depart2, arrive2, (float)50.5 );
        Vol v3 = new Vol(lundi, A1, A2, depart3, arrive3, (float)50.5 );

        
        // Pilotes
        String prenom1 = "Kevin";
        String prenom2 = "Kevina";
        String prenom3 = "Michel";
        String prenom4 = "Robert";

        String nom1 = "Lepilote";
        String nom2 = "lacopilote";
        String nom3 = "Lepilote";
        String nom4 = "Lecopilote";
     
        String adresse1 = "blabla";
        String adresse2 = "blabla";
        String adresse3 = "blabla";
        String adresse4 = "blabla";

        
        Pilote pilote1 = new Pilote ( nom1, prenom1, adresse1);
        Pilote pilote2 = new Pilote ( nom2, prenom2,  adresse2);
        Pilote pilote3 = new Pilote ( nom3, prenom3,  adresse3);
        Pilote pilote4 = new Pilote ( nom4, prenom4,  adresse4);

        
        
        //Hotesse
        
        
        String prenom5 = "Jeanne";
        String prenom6 = "Serge";
        String prenom7 = "Sangoku";
        String prenom8 = "Trunk";
        String prenom9 = "Boo";
        String prenom10 = "Vegeta"; 
        
        
        String nom5 = "L'hotesse n°1";
        String nom6 = "L'hotesse n°2";
        String nom7 = "L'hotesse n°3";
        String nom8 = "L'hotesse n°4";
        String nom9 = "L'hotesse n°5";
        String nom10 = "L'hotesse n°6";
        
        
        String adresse5 = "blabla";
        String adresse6 = "blabla";
        String adresse7 = "blabla";
        String adresse8 = "blabla";
        String adresse9 = "blabla";
        String adresse10 = "blabla";
        
        Hotesse hotesse1 = new Hotesse (nom5, prenom5, adresse5);
        Hotesse hotesse2 = new Hotesse (nom6, prenom6, adresse6);
        Hotesse hotesse3 = new Hotesse (nom7, prenom7, adresse7);
        Hotesse hotesse4 = new Hotesse (nom8, prenom8, adresse8);
        Hotesse hotesse5 = new Hotesse (nom9, prenom9, adresse9);
        Hotesse hotesse6 = new Hotesse (nom10, prenom10, adresse10);

        //Création d'affecter
            //Personnel
        v.affecterpersonnel (pilote1, pilote2, hotesse1, hotesse2, hotesse3);
        v2.affecterpersonnel (pilote3, pilote4, hotesse1, hotesse4, hotesse5);
        v3.affecterpersonnel (pilote1, pilote4, hotesse1, hotesse4, hotesse5);

            //Avion
       /* Affecter a = new Affecter ();
        a.affecterAvion(v, Av2);
        a.affecterAvion(v2, Av2);
        a.affecterAvion(v3, Av2);*/
        
        //Affecter a = new Affecter ();
        //a.affecterPersoVol (v, pilote1, pilote2, hotesse1, hotesse2, hotesse3);
        //a.affecterPersoVol (v2, pilote3, pilote4, hotesse1, hotesse5, hotesse6);
        //affecterpersonnel au VOl
        
        
       // System.out.println(v.getClass().getDeclaredFields().toString());
       
       
}
}