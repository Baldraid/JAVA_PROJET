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
    private HashMap <Vol, Pilote> pilote; 
    private HashMap <Vol, Pilote> copilote ;
    private HashMap <Vol, Hotesse> hotesse ;
    private HashMap <Vol, Hotesse> hotesse2 ;
    private HashMap <Vol, Hotesse> hotesse3 ;
    
// Je veux récup une ArrayList qui récupère toutes les HashMap, je sais pas si 
    //ça sert à quelque chose
        //ni si ça marche
    //DELIRE PERSONNEL INC
    public ArrayList getAffecter ()
    {
        ArrayList affecter = new ArrayList();
        
        affecter.add(this.pilote);
        affecter.add(this.copilote);
        affecter.add(this.hotesse);
        affecter.add(this.hotesse2);
        affecter.add(this.hotesse3);
        
        return affecter;
    }

    // Constructeur qui prend un vol et tout le personnel, on ajoute ensuite à chaque HashMap le vol et le personnel correspondant
    public Affecter(Vol vol, Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3) {
       this.pilote = new HashMap <> ();
       this.copilote = new HashMap <> ();
       this.hotesse = new HashMap <> ();
       this.hotesse2 = new HashMap <> ();
       this.hotesse3 = new HashMap <> ();
       
       this.pilote.put(vol, pilote);
       this.copilote.put(vol, copilote);
       this.hotesse.put(vol, hotesse1);
       this.hotesse2.put(vol, hotesse2);
       this.hotesse3.put(vol, hotesse3);
       
    }
    
    
}
