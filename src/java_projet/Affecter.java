/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class Affecter {
   
    private HashMap <Vol, ArrayList> affectationVol; 
   
    


    // Constructeur qui initialise juste la HashMap
    public Affecter() {
        
         this.affectationVol = new HashMap <> ();      
    }

    
    //fonction pour affecter le personnel à un vol
    public void affecterPersoVol (Vol vol, Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3)
    {
        //ArrayList pour la valeur de l'HashMap
    ArrayList affecter = new ArrayList();
    //ArrayList qui récupère les vols en conflits
    ArrayList <Vol> memePersonnel = new ArrayList<> ();
    //On insère les vols en conflits à cause de même personnel grâce à la fonction memepersonnel plus loin 
    memePersonnel = this.memePersonnel(vol, pilote, copilote, hotesse1, hotesse2, hotesse3);
    //s'il n'y a pas de vols en conflits alors on ajoute directement les membres du personnel à l'ArrayList qui sera valeur de la HashMap
    //et on ajoute à la HashMap le vol et l'arraylist du personnel affecté
    if (memePersonnel.isEmpty())
    {
       affecter.add(pilote);
       affecter.add(copilote);
       affecter.add(hotesse1);
       affecter.add(hotesse2);
       affecter.add(hotesse3);
       this.affectationVol.put(vol, affecter);
       //on ajoute au vol l'arrayList du personnel affecté
       vol.affecterpersonnel(affecter);

     }
     //Sinon on vérifie les plages horaires du vol qu'on veut affecter aux vols auxquels il peut être en conflits car même membre du personnel
     else {
        //pour chaque vols en conflit
          for (int i = 0; i< memePersonnel.size(); i ++)
      {   //si pas de conflit de plage horaire alors on ajoute le personnel à l'arraylist et on ajoute le vol et l'arrayList à la Hashmap
          if (verifPlageHoraire(vol)== true) {
            affecter.add(pilote);
            affecter.add(copilote);
            affecter.add(hotesse1);
            affecter.add(hotesse2);
            affecter.add(hotesse3);
            this.affectationVol.put(vol, affecter);
            vol.affecterpersonnel(affecter);
            System.out.println("Personnel bien affecté");
 }
          else 
          {
              //Sinon message d'erreur
              System.out.println("Vous ne pouvez pas affecter ce personnel à ce vol, conflit avec un autre vol");
          }
     }
     
      }
    }
   
    //On vérifie les conflits de plages horaires à partir d'un vol v 
    private boolean verifPlageHoraire (Vol v)
    {
        // pour chaque entrée de la HashMap
        for(Map.Entry< Vol, ArrayList> entry : this.affectationVol.entrySet()) 
     {
    Vol cle = entry.getKey();
    ArrayList valeur = entry.getValue();
   
    //si l'heure de départ du vol de la clé est avant l'heure de départ du vol qu'on vérifie
    if (cle.getHeureDepart().isBefore(v.getHeureDepart()))
    {
        // on vérifie si l'arrivé du vol de la clé est avant l'heure de départ du vol qu'on vérifie
        if (cle.getHeureArrive().isBefore(v.getHeureDepart()))
        {
            // si oui on retourne vrai 
            return true;
        }
        //sinon on retourne faux
        else return false;
    }
    //si l'heure de départ du vol de la clé est après l'heure de départ du vol qu'on vérifie
    if (cle.getHeureDepart().isAfter(v.getHeureDepart()))
    {
        //alors on vérifie si l'heure de départ de la clé est après l'heure d'arrivé du vol qu'on vérifie
        if (cle.getHeureDepart().isAfter(v.getHeureArrive()))
        {
            //si ok alors true
            return true;
        }
        //sinon faux 
        else return false;
    }
     }
        return true;
    }
    
    //fonction qui ajoute les vols éventuellement en conflits (s'ils ont le un personnel en commun)
    private ArrayList memePersonnel (Vol v, Pilote p1, Pilote p2, Hotesse h1, Hotesse h2, Hotesse h3)
    {
        //arraylist qui reçoit les vols en conflits
        ArrayList <Vol> volMemePersonnel = new ArrayList<>();
        //pour chaque entrée de la HashMap d'affectation
        for(Map.Entry< Vol, ArrayList> entry : this.affectationVol.entrySet()) 
     {
    Vol cle = entry.getKey();
    ArrayList valeur = entry.getValue();
        //si le pilote, le copilote, l'hotesse1, 2 ou 3 sont sur un autre vol on ajoute le vol à l'arraylist
        for (int i = 0; i<valeur.size(); i++) {
            if (valeur.get(i).equals(p1) || valeur.get(i).equals(p2) || valeur.get(i).equals(h1) || valeur.get(i).equals(h2) || valeur.get(i).equals(h3))
            {
               volMemePersonnel.add(cle);
            }
        }
             
     }
        //et on retourne l'arraylist
     return volMemePersonnel;   
    }
    
    public HashMap<Vol, ArrayList> getAffectationVol() {
        return affectationVol;
    }

    public void setAffectationVol(HashMap<Vol, ArrayList> affectationVol) {
        this.affectationVol = affectationVol;
    }


}