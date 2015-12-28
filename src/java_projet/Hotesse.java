/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;

import java.util.ArrayList;


/**
 *
 * @author Mathilde Bedel
 */
public class Hotesse extends Personnel{
    private ArrayList<Vol> volAffecte = new ArrayList ();        

    public Hotesse(String nomP, String prenomP, String adresseP, Aeroport a) {
        super(nomP, prenomP, adresseP, a);
    }

   
    @Override
    public String toString() {
        return "L'hotesse " +super.toString();
    }
    
    public void ajouterVolAffecte (Vol v)
    {
        volAffecte.add(v);
    }
    
    public void getDureeVol ()
    {
         long dureeTot = 0;
      
        
      
            for (int i =0; i<this.volAffecte.size(); i++)
            {
                
                dureeTot = dureeTot + volAffecte.get(i).getDuree();                
            }      

           System.out.println( this.getPrenomP()+ " " +this.getNomP()+ " a volé " +dureeTot+ " minutes pendant la semaine");   
           System.out.println("soit " +dureeTot/60+ " heures");
           System.out.println("----------------------------------");   


        }
        
             
        
     
    
    
 
}
