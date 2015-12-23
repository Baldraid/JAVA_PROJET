/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;

/**
 *
 * @author Mathilde Bedel
 */
public class Pilote extends Personnel{
    
    public Pilote(String nomP, String prenomP, String adresseP) {
        super(nomP, prenomP, adresseP);
    }

    @Override
    public String toString() {
        return "Le pilote " +super.toString();
    }
    
    
}
