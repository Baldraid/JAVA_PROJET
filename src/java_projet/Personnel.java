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
public class Personnel {
    private String nomP;
    private String prenomP;
    private String adresseP;

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getAdresseP() {
        return adresseP;
    }

    public void setAdresseP(String adresseP) {
        this.adresseP = adresseP;
    }

    public Personnel(String nomP, String prenomP, String adresseP) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.adresseP = adresseP;
    }

    @Override
    public String toString() {
        return prenomP+ " " +nomP;
    }
 
    
    
}
