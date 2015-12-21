/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author Mathilde Bedel
 */
public class Avion {
    private int numAvion;
    private static final AtomicInteger count = new AtomicInteger(0); //compteur pour auto-increment


    public int getNumAvion() {
        return numAvion;
    }

    public void setNumAvion(int numAvion) {
        this.numAvion = numAvion;
    }

    public Avion(int numAvion) {
        this.numAvion = count.incrementAndGet();
    }
    
    
}
