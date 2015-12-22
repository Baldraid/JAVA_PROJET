/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benjamin
 */
public class Affecter {
   
    private HashMap <Vol, ArrayList> affectationVol = new HashMap <> ();; 
   
    


    // Constructeur qui prend un vol et tout le personnel
    //On ajoute le personnel à 'Arraylist
    //et on ajoute à la HashMap : (le vol, la liste) pour associer tout le personnel au vol.
    public Affecter(Vol vol, Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3) {
     ArrayList affecter = new ArrayList();
        
     affecter.add(pilote);
     affecter.add(copilote);
     affecter.add(hotesse1);
     affecter.add(hotesse2);
     affecter.add(hotesse3);
     
    this.affectationVol.put(vol, affecter);
        
        /* this.pilote = new HashMap <> ();
       this.copilote = new HashMap <> ();
       this.hotesse = new HashMap <> ();
       this.hotesse2 = new HashMap <> ();
       this.hotesse3 = new HashMap <> ();
       
       this.pilote.put(vol, pilote);
       this.copilote.put(vol, copilote);
       this.hotesse.put(vol, hotesse1);
       this.hotesse2.put(vol, hotesse2);
       this.hotesse3.put(vol, hotesse3);*/
       
    }

    public HashMap<Vol, ArrayList> getAffectationVol() {
        return affectationVol;
    }

    public void setAffectationVol(HashMap<Vol, ArrayList> affectationVol) {
        this.affectationVol = affectationVol;
    }


}