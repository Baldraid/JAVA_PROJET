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
        
        String P1, P2, P3;
        P1 = "France";
        P2 = "Angleterre";
        P3 = "Espagne";
        
        String V1, V2, V3;
        V1 = "Londres";
        V2 = "Toulouse";
        V3 = "Paris";
        
        Aeroport A1, A2;
        A1 = new Aeroport(1, V2, P1);
        A2 = new Aeroport(2, V3, P1);
        
        LocalTime depart = LocalTime.parse("23:55:10");
        LocalTime arrive = LocalTime.parse("10:55:10");
        
        Vol v = new Vol(lundi, A1, A2, depart, arrive, (float)50.5 );
        
        System.out.println(v);
        
        
        
        
        
    }
    
}
