/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;

import java.time.LocalTime;

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
        
        //Aéroports
        Aeroport A1, A2;
        A1 = new Aeroport( V2, P1);
        A2 = new Aeroport( V3, P1);
        
        //Heures de départ et d'arrivée
        LocalTime depart = LocalTime.parse("23:55:10");
        LocalTime arrive = LocalTime.parse("10:55:10");
        
        //Vol
        Vol v = new Vol(lundi, A1, A2, depart, arrive, (float)50.5 );
        
        // Pilotes
        String prenom1 = "Kevin";
        String prenom2 = "Kevina";
        String nom1 = "Lepilote";
        String nom2 = "lacopilote";
        String adresse1 = "blabla";
        String adresse2 = "blabla";
        
        Pilote pilote1 = new Pilote (prenom1, nom1, adresse1);
        Pilote pilote2 = new Pilote (prenom1, nom1, adresse1);
        
        //Hotesse
        
        
        
        System.out.println(v.getDuree());
        
        
        
        
        
    }
    
}
