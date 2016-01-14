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
    private ArrayList<Vol> lstVolAffecte = new ArrayList ();

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



    @Override
    public String toString() {
        return this.getVilleA();
    }

   

    
    
    public Aeroport(String villeA, String paysA) {
        this.codeA = count.incrementAndGet();
        this.villeA = villeA;
        this.paysA = paysA;
    }
    
    public void consult ()
    {
        System.out.println("Aéroport n°" +this.codeA);
        System.out.println("Ville : " +this.villeA);
        System.out.println("Pays : " +this.paysA);
        System.out.println("-------------------");

    }
    public void ajouterVol (Vol v )
    {
        lstVolAffecte.add(v);
    }

    public void modify(String ville, String pays)
    {
        String villeA = this.getVilleA();
        String paysA = this.getPaysA();
        this.setPaysA(pays);
        this.setVilleA(ville);
        System.out.println("L'aéroport a bien été modifié");
        System.out.println("Anciennes valeurs :" +this.getCodeA()+ ", " +villeA+ ", " +paysA);
        System.out.println("Nouvelles valeurs :" +this.getCodeA()+ ", " +ville+ ", " +pays);
        System.out.println("-------------------");
    }
   
   public ArrayList getLstvol() {
        return lstVolAffecte;
    }

    public void setLstvol(ArrayList lstvol) {
        this.lstVolAffecte = lstvol;
    }

public void delete ()
    {
       
       //on parcours à l'aide de Iterator() (pour eviter les erreurs lors de suppressions d'objets dans la boucle for)
    if (this.lstVolAffecte.isEmpty()) {
                this.setCodeA(0);
                this.setPaysA(null);
                this.setVilleA(null);
                System.out.println("L'aéroport a bien été supprimé");
                System.out.println("-------------------");
    }
    else{
        System.out.println("Vous ne pouvez pas supprimer cet aéroport :");
        for (int i = 0; i < lstVolAffecte.size(); i++) {          
                System.out.println("Il est associé au vol : "+lstVolAffecte.get(i).getNumVol());
                
            }
        }
                System.out.println("-----------------------------------------");
    }}
