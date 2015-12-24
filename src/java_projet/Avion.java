/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author Mathilde Bedel
 */
public class Avion {
    private int numAvion;
    private ArrayList <Vol> volAffecte = new ArrayList <>();
    private static final AtomicInteger count = new AtomicInteger(0); //compteur pour auto-increment


    public int getNumAvion() {
        return numAvion;
    }

    public void setNumAvion(int numAvion) {
        this.numAvion = numAvion;
    }

    public Avion() {
        this.numAvion = count.incrementAndGet();
    }

    @Override
    public String toString() {
        return  ""+numAvion ;
    }
    
    public void ajouterVolAffecter (Vol v)
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

           System.out.println("L'avion n°" +this.numAvion+ " a volé " +dureeTot+ " minutes pendant la semaine");   
           System.out.println("soit " +dureeTot/60+ " heures");
           System.out.println("----------------------------------");   


        }
    
}
