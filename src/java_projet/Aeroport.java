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
public class Aeroport {
    private int codeA;
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

    
    
    public Aeroport(int codeA, String villeA, String paysA) {
        this.codeA = codeA;
        this.villeA = villeA;
        this.paysA = paysA;
    }
    
    
}
