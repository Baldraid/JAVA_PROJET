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
public class Aeroport {
    private int codeA;
    private static final AtomicInteger count = new AtomicInteger(0); //compteur pour auto-increment
    private String villeA;
    private String paysA;
    private ArrayList lstAero;

    public int getCodeA() {
        return codeA;
    }

    public void setCodeA(int codeA) {
        this.codeA = codeA;
    }

    public String getVilleA() {
        return villeA;
    }

    public void setVilleA(String villeA) {
        this.villeA = villeA;
    }

    public String getPaysA() {
        return paysA;
    }

    public void setPaysA(String paysA) {
        this.paysA = paysA;
    }

    public ArrayList getLstAero() {
        return lstAero;
    }

    public void setLstAero(ArrayList lstAero) {
        this.lstAero = lstAero;
    }

    
    
    public Aeroport(String villeA, String paysA) {
        this.codeA = count.incrementAndGet();
        this.villeA = villeA;
        this.paysA = paysA;
    }
    
    
}
