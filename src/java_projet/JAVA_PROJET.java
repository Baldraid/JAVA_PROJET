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
        String mercredi = "Mercredi";
        String jeudi = "Jeudi";
        String vendredi = "Vendredi";
        String samedi = "Samedi";
        String dimanche = "Dimanche";
        
        //Pays
        String P1, P2, P3, P4;
        P1 = "France";
        P2 = "Angleterre";
        P3 = "Espagne";
        P4 = "Belgique";
        
        //Ville
        String V1, V2, V3, V4, V5;
        V1 = "Londres";
        V2 = "Toulouse";
        V3 = "Paris";
        V4 = "Madrid";
        V5 = "Bruxelles";
        
    
        //Aéroports
        Aeroport A1, A2, A3, A4;
        A1 = new Aeroport( V2, P1);
        A2 = new Aeroport( V3, P1);
        A3 = new Aeroport( V1, P2);
        A4 = new Aeroport( V4, P3);

        
            //Avions
        Avion Av1, Av2, Av3, Av4, Av5, Av6, Av7, Av8;
        Av1 = new Avion (A1);
        Av2 = new Avion(A1);
        Av3 = new Avion(A2);
        Av4 = new Avion(A2);
        Av5 = new Avion(A3);
        Av6 = new Avion(A3);
        Av7 = new Avion(A2);
        Av8 = new Avion(A2);
        
        
        //Heures de départ et d'arrivée
        LocalTime depart1 = LocalTime.parse("08:00:00");
        LocalTime arrive1 = LocalTime.parse("10:00:00");
        
        LocalTime depart2 = LocalTime.parse("09:00:00");
        LocalTime arrive2 = LocalTime.parse("11:00:00");
        
        LocalTime depart3 = LocalTime.parse("11:00:00");
        LocalTime arrive3 = LocalTime.parse("13:00:00");
        
        LocalTime depart4 = LocalTime.parse("20:00:00");
        LocalTime arrive4 = LocalTime.parse("22:00:00");
        
        LocalTime depart5 = LocalTime.parse("14:00:00");
        LocalTime arrive5 = LocalTime.parse("17:00:00");
        
        //Vol
            //Vol tout ok
        Vol v = new Vol(lundi, A1, A2, depart1, arrive1, (float)50.5 );
        
            //Vol horaire Avion
        Vol v2 = new Vol(lundi, A1, A2, depart2, arrive2, (float)50.5 );
        
            //Vol horaire personnel 
        Vol v3 = new Vol(lundi, A2, A1, depart3, arrive3, (float)50.5 );
        
        
        Vol v4 = new Vol(lundi, A1, A3, depart4, arrive4, (float)50.5 );
        
        Vol v5 = new Vol(lundi, A3, A4, depart5, arrive5, (float)50.5 );
        
        // Pilotes
        String prenom1 = "Kevin";
        String prenom2 = "Kevina";
        String prenom3 = "Michel";
        String prenom4 = "Robert";
        String prenom5 = "Gragas";
        String prenom6 = "Patrick";
        String prenom7 = "Bob";
        String prenom8 = "Pikachu";
        String prenom9 = "Bulma";
        String prenom10 = "Teemo";

        String nom1 = "Lepilote n°1";
        String nom2 = "lacopilote n°1";
        String nom3 = "Lepilote n°2";
        String nom4 = "Lecopilote n°2";
        String nom5 = "Lepilote n°3";
        String nom6 = "lacopilote n°3";
        String nom7 = "Lepilote n°4";
        String nom8 = "Lecopilote n°5";
        String nom9 = "Lepilote n°6";
        String nom10 = "LE CAPITAINE n°6";
    
        String adresse1 = "blabla";
        
        Pilote pilote1 = new Pilote ( nom1, prenom1, adresse1, A1);
        Pilote pilote2 = new Pilote ( nom2, prenom2,  adresse1, A1);
        Pilote pilote3 = new Pilote ( nom3, prenom3,  adresse1, A2);
        Pilote pilote4 = new Pilote ( nom4, prenom4,  adresse1, A2);
        Pilote pilote5 = new Pilote ( nom5, prenom5, adresse1, A3);
        Pilote pilote6 = new Pilote ( nom6, prenom6,  adresse1, A3);
        Pilote pilote7 = new Pilote ( nom7, prenom7,  adresse1, A4);
        Pilote pilote8 = new Pilote ( nom8, prenom8,  adresse1, A4);
        Pilote pilote9 = new Pilote ( nom9, prenom9,  adresse1, A1);
        Pilote pilote10 = new Pilote ( nom10, prenom10,  adresse1, A1);            
        
        //Hotesse
        
        
        String prenom11 = "Jeanne";
        String prenom12 = "Serge";
        String prenom13 = "Sangoku";
        String prenom14 = "Trunk";
        String prenom15 = "Boo";
        String prenom16 = "Vegeta";
        String prenom17 = "Tristana";
        String prenom18 = "Jinx";
        String prenom19 = "Fizz";
        String prenom20 = "Miss Fortune";
        String prenom21 = "Heimeirdinger";
        String prenom22 = "Freeze"; 
        
        
        String nom11 = "L'hotesse n°1";
        String nom12 = "L'hotesse n°2";
        String nom13 = "L'hotesse n°3";
        String nom14 = "L'hotesse n°4";
        String nom15 = "L'hotesse n°5";
        String nom16 = "L'hotesse n°6";
        String nom17 = "L'hotesse n°7";
        String nom18 = "L'hotesse n°8";
        String nom19 = "L'hotesse n°9";
        String nom20 = "L'hotesse n°10";
        String nom21 = "L'hotesse n°11";
        String nom22 = "L'hotesse n°12";
        

        
        
        Hotesse hotesse1 = new Hotesse (nom11, prenom11, adresse1, A1);
        Hotesse hotesse2 = new Hotesse (nom12, prenom12, adresse1, A1);
        Hotesse hotesse3 = new Hotesse (nom13, prenom13, adresse1, A1);
        Hotesse hotesse4 = new Hotesse (nom14, prenom14, adresse1, A2);
        Hotesse hotesse5 = new Hotesse (nom15, prenom15, adresse1, A2);
        Hotesse hotesse6 = new Hotesse (nom16, prenom16, adresse1, A2);
        Hotesse hotesse7 = new Hotesse (nom17, prenom17, adresse1, A3);
        Hotesse hotesse8 = new Hotesse (nom18, prenom18, adresse1, A3);
        Hotesse hotesse9 = new Hotesse (nom19, prenom19, adresse1, A3);
        Hotesse hotesse10 = new Hotesse (nom20, prenom20, adresse1, A4);
        Hotesse hotesse11 = new Hotesse (nom21, prenom21, adresse1, A4);
        Hotesse hotesse12 = new Hotesse (nom22, prenom22, adresse1, A4);

        //Création d'affectation
        
             //Avion
                //Tout Ok
        v.affecteravion(Av1);
                //Conflit horaire
        v2.affecteravion(Av1);
                // Conflit localisation
        v3.affecteravion(Av3);
        
        v4.affecteravion(Av1);
        //v5.affecteravion(Av1);

           //Personnel
                //Tout Ok
        v.affecterpersonnel (pilote1, pilote2, hotesse1, hotesse2, hotesse3);
                //Conflit horaire
        v2.affecterpersonnel (pilote1, pilote2, hotesse1, hotesse2, hotesse3);
                // Conflit localisation
        v3.affecterpersonnel (pilote1, pilote2, hotesse4, hotesse5, hotesse6);
        
        v4.affecterpersonnel (pilote1, pilote2, hotesse1, hotesse2, hotesse3);
        
        v5.affecterpersonnel (pilote1, pilote2, hotesse1, hotesse2, hotesse3);

           
            
        // Consulter
            //Aeroport
         A3.consult();
         A3.modify(V5, P4);
         A1.delete();
      /* A1.consult();
         A1.delete();
         A1.consult();*/
      
           // Vol
      v.consult();
      v4.modify(mardi, A3, A4, depart4, arrive4, (float)25);
      v.delete();
          
     //Durée de vol du personnel/avion
     
       hotesse1.getDureeVol();
       pilote1.getDureeVol();
       Av1.getDureeVol();
       
     
     
     //Validate un vol 
        v.validateVol();
        v2.validateVol();
        //v2.validateVol();
        //v4.validateVol();
        
      //Arrive un vol 
      
     // v.arriveVol();
      //v2.arriveVol();
      //v4.arriveVol();
      String retard = "PRE-DECOLLAGE";
      int dureeRetard = 6;
      v.calculerRetard6h(retard, dureeRetard);
}
}