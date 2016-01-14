/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.Iterator;
/**
 *
 * @author Benjamin
 */
public class Affecter {
   
    private final HashMap <Vol, ArrayList> affectationVol; 
    private final HashMap <Vol, Avion> affectationVolAvion;
   
    


    // Constructeur qui initialise juste la HashMap
    public Affecter() {
        
         this.affectationVol = new HashMap <> ();  
         this.affectationVolAvion = new HashMap <>();
    }

//fonction pour affecter un avion à un vol 
    //retourne un boolean pour déterminer si l'on affecte l'avion au vol en question
    //attribut ArrayList avionaffecter de la classe vol
    //si false on l'ajoute sinon non
    public boolean affecterAvionVol(Vol vol, Avion av) {
  
        //HashMap qui récupère le vol et l'avion en conflit avec le vol auquel on veut affecter 
        //Se remplie avec la fonction memeAvion
        HashMap<Vol, ArrayList> memeAvion;
        memeAvion = this.memeAvion(vol, av);
        //list qui récupère les vols en conflits de plage horaire
        //se remplie avec la fonction verifPlageHoraire
        String retard = "AUCUN";
        int dureeRetard = 0;
        
        ArrayList<Vol> volConflictuel;
        volConflictuel = this.verifPlageHoraire(retard, dureeRetard, vol, memeAvion);
        //Booleen pour le retour de la fonction
        boolean conflit = false;
        //S'il n'y a pas d'avion en conflit ou pas de conflit de plage horaire alors on ajoute directement
        if (memeAvion.isEmpty() || volConflictuel.isEmpty()) {
            //On ajoute tous l'avion à l'ArrayList affecter
        }
        
        //Sinon on vérifie les plages horaires du vol qu'on veut affecter
        //aux vols auxquels il peut être en conflits car même avion
        else {
            // le boolean prend la valeur true donc on ajoutera pas l'avion à la classe vol
            conflit = true;
            //Pour chaque entrée de la HashMap même avion
            for (Map.Entry< Vol, ArrayList> entry : memeAvion.entrySet()) {
                Vol volAvion = entry.getKey();
                ArrayList avionConflict = entry.getValue();
                // et pour chaque entrée de la HashMap volConflictuel
                for (int i = 0; i < volConflictuel.size(); i++) {
                    Vol volConflict = volConflictuel.get(i);
                    // On vérifie si le vol est le même dans les deux HashMap
                    // Si c'est bon alors on println l'avion en conflit
                    //avec le vol où l'on veut affecter
                    if (volAvion.equals(volConflict)) {
                        System.out.println("Le vol n°" + volAvion.getNumVol() + " est en conflit avec le vol n°" + vol.getNumVol());
                        System.out.println("L'avion "+avionConflict.get(i).toString()+" est déjà affecté au vol " +volAvion.getNumVol());
                        System.out.println("----------------------------------------------------------------------------------");
                    }
                }
            }
        }
        // et on renvoie la valeur du booleen pour savoir si on ajoute ou non à la classe vol.
        return conflit;
    }

    //fonction renvoie une HashMap contenant le vol en key et une ArrayList des
    //avions en conflit en valeur;
    //Prend en entrée l'avion trouver les éventuels doublons
    private HashMap memeAvion(Vol v, Avion av) {
        //HashMap qui récupère le vol avec lequel il y a un conflit d'avion et l'avion en conflit
        HashMap<Vol, ArrayList> volMmAvion = new HashMap<>();
        //ArrayList pour remplir la HashMap du dessus avec l'avion en conflit
        ArrayList avionDoublon = new ArrayList();
        //pour chaque entrée de la HashMap d'affectation
        for (Map.Entry< Vol, Avion> entry : this.affectationVolAvion.entrySet()) 
        {
            Vol cle = entry.getKey();
            Avion valeur = entry.getValue();
            // Pour chaque avion de chaque vol de la HashMap affectationVol 
            //Si un avion est en conflit on l'ajoute à l'arraylist des avions en conflit
            if (v.getJourSemaine().equals(cle.getJourSemaine())) 
            {
                 if (valeur.equals(av)) 
                    {
                        avionDoublon.add(av);
                    }
                    //Si on a trouvé un même avion alors l'ArrayList n'est pas vide
                    if (!avionDoublon.isEmpty())
                    {
                        // donc on clone l'ArrayList avion doublon
                        ArrayList copy = (ArrayList) avionDoublon.clone();
                        // et on ajoute l'arraylist clonée à la HashMap 
                        volMmAvion.put(cle, copy);
                        // Puis on vide l'ArrayList pour le tour suivant 
                        avionDoublon.clear();
                    }
                }
            }
         //et on retourne la HashMap 
        return volMmAvion;
        }
       

    
    //fonction pour affecter le personnel à un vol 
    //retourne un boolean pour déterminer si l'on ajoute les membres du personnel au vol en question
    // attribut ArrayList personnelaffecter de la classe vol
    // si false on l'ajoute sinon non
     public boolean affecterPersoVol(Vol vol, Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3) {
        //ArrayList pour la valeur de l'HashMap affectation vol de cette classe
        ArrayList <Personnel> affecter = new ArrayList();
        //HashMap qui récupère le vol et le personnel en conflit avec le vol auquel on veut affecter 
        // Se remplie avec la fonction memepersonnel
        HashMap<Vol, ArrayList> memePersonnel;
        memePersonnel = this.memePersonnel(vol, pilote, copilote, hotesse1, hotesse2, hotesse3);
        
        HashMap <Vol, String> HashTemp1 = this.trouveVolAvAp(vol, memePersonnel);
        HashMap <Vol, String> HashTemp2 = this.trouveJusteAvAp(vol, HashTemp1);
        
        HashMap <Vol, String> conflitLocaV; 
        conflitLocaV = this.verifLocaVol(vol, HashTemp2);
        
        String retard = "AUCUN";
        int dureeRetard = 0;
        //HashMap qui récupère les vols en conflits de plage horaire
        //J'aurais pu juste utiliser une ArrayList mais tant pis je changerais plus tard
        // se remplie avec la fonction verifPlageHoraire
        ArrayList<Vol> volConflictuel;
        volConflictuel = this.verifPlageHoraire(retard, dureeRetard, vol, memePersonnel);
        //Booleen pour le retour de la fonction
        boolean conflit = false;
        //S'il n'y a pas de personnel en conflit ou pas de conflit de plage horaire alors on ajoute directement
        if (memePersonnel.isEmpty() || volConflictuel.isEmpty() && conflitLocaV.isEmpty()) {
            //On ajoute tous les membres du personnel à l'ArrayList affecter
            affecter.add(pilote);
            affecter.add(copilote);
            affecter.add(hotesse1);
            affecter.add(hotesse2);
            affecter.add(hotesse3);
            //On ajoute à la HashMap la clé : vol et la valeur : ArrayList du personnel affecté
            this.affectationVol.put(vol, affecter);
            // et le boolean prend la valeur faux 
            conflit = false;
            System.out.println("Tous les membres du personnel ont été affectés au vol n°" + vol.getNumVol());
            System.out.println("----------------------------------------------------------------------------------");
        } 
       else if (!conflitLocaV.isEmpty())
        {
       System.out.println("Vous ne pouvez pas affecter ce personnel à ce vol (" +vol.getNumVol()+ ") :");
       for(Map.Entry< Vol, String> entry : conflitLocaV.entrySet()) 
     {
        Vol cle = entry.getKey();
        String valeur = entry.getValue();
        switch (valeur) {
            case "AVANT":
                System.out.println("Le vol n°" +cle.getNumVol()+ " qui part avant : Heure de départ : " +cle.getHeureDepart()+ " - Heure d'arrivée " +cle.getHeureArrive()+ " :" );
                System.out.println("(Arrive à " +cle.getArrive()+ " alors que ce vol part de " +vol.getDepart()+ ")");
                break;
            case "APRES":
                System.out.println("Le vol n°" +cle.getNumVol()+ " qui part après : Heure de départ : " +cle.getHeureDepart()+ " - Heure d'arrivée " +cle.getHeureArrive()+ " :" );
                System.out.println("(Part de " +cle.getDepart()+ " alors que ce vol arrive à " +vol.getArrive()+ ")");
                break;
        }
     }
    System.out.println("------------------------------------------");
        }
        else {
            // le booleen prend la valeur true donc on ajoutera pas les membre du personnel à la classe vol
            conflit = true;
            //Pour chaque entrée de la HashMap même personnel
            for (Map.Entry< Vol, ArrayList> entry : memePersonnel.entrySet()) {
                Vol volPerso = entry.getKey();
                ArrayList personnelConflict = entry.getValue();
                // et pour chaque entrée de la HashMap volConflictuel
                for (int i = 0; i < volConflictuel.size(); i++) {
                    Vol volConflict = volConflictuel.get(i);
                        // On vérifie si le vol est le même dans les deux HashMap
                    // Si c'est bon alors on println tous les membres du personnel en conflits
                    //avec le vols où l'on veut affecter
                    if (volPerso.equals(volConflict)) {
                        System.out.println("Le vol n°" + volPerso.getNumVol() + " est en conflit avec le vol n°" + vol.getNumVol());
                        System.out.println("Le(s) membre(s) du personnel suivant(s) sont déjà affecté(s) :");
                        for (int j = 0; j < personnelConflict.size(); j++) {
                            System.out.println(personnelConflict.get(j).toString());
                        }
                        System.out.println("----------------------------------------------------------------------------------");
                    }
                }
            }
        }
        // et on renvoie la valeur du booleen pour savoir si on ajoute ou non à la classe vol.
        return conflit;
    }

     private HashMap <Vol, String> verifLocaVol (Vol v, HashMap<Vol, String> voljusteAvantApres)
     {
         HashMap <Vol, String> conflitVolLoca = new HashMap <>();
           for(Map.Entry< Vol, String> entry : voljusteAvantApres.entrySet()) 
     {
        Vol cle = entry.getKey();
        String valeur = entry.getValue();
        
        
            if (valeur.equals("AVANT")) {
                    if (!cle.getArrive().equals(v.getDepart()))
                    {
                        conflitVolLoca.put(cle, "AVANT");
                    }
            }
            else{
                    if (!cle.getDepart().equals(v.getArrive()))
                    {
                        conflitVolLoca.put(cle, "APRES");
                    }
                    }
       }
       return conflitVolLoca;
     }
     
     private HashMap <Vol, String> trouveJusteAvAp(Vol v, HashMap <Vol, String> volAvantApres)
     {
         HashMap<Vol, String> voljusteAvantApres = new HashMap <> ();
          long minAV = 10000;
          long minAP = 10000;
        
          
         for(Map.Entry< Vol, String> entry : volAvantApres.entrySet()) 
     {
        Vol cle = entry.getKey();
        String valeur = entry.getValue();
        if (valeur.equals("AVANT")){
                if (MINUTES.between(cle.getHeureArrive(), v.getHeureDepart()) < minAV)
                {
                    minAV = MINUTES.between(cle.getHeureArrive(), v.getHeureDepart());
                    supprimerVolValeur (voljusteAvantApres, "AVANT");            
                    voljusteAvantApres.put(cle, "AVANT");
                }
        }
        else {
                if (MINUTES.between(v.getHeureDepart(), cle.getHeureArrive()) < minAP)
                {
                    minAP = MINUTES.between(v.getHeureDepart(), cle.getHeureArrive());
                    supprimerVolValeur (voljusteAvantApres, "APRES");            
                    voljusteAvantApres.put(cle, "APRES");
                }  
        }
     } return voljusteAvantApres; 
     }
         
     
     
     private HashMap <Vol, String> supprimerVolValeur (HashMap <Vol, String> voljusteAvantApres, String avap)
     {
         for (Iterator<Map.Entry<Vol, String>> it = voljusteAvantApres.entrySet().iterator(); it.hasNext();) {
            Map.Entry< Vol, String> entry = it.next();
            //creation d'une variable destiné à récuperer la valeur de la hashmap parcouru
            String valeur = entry.getValue();
            {
                if (valeur.equals(avap))
                {
                     it.remove();
                }
            }        
     }
         return voljusteAvantApres;
     }
     
     
     private HashMap <Vol, String> trouveVolAvAp (Vol v, HashMap<Vol, ArrayList> memePersonnel)
     {
         
         HashMap <Vol, String> volAvantApres = new HashMap <>();
     
         for(Map.Entry< Vol, ArrayList> entry : memePersonnel.entrySet()) 
     {
    Vol cle = entry.getKey();
            
         if (cle.getHeureArrive().isBefore(v.getHeureDepart()))
         {
             volAvantApres.put(cle, "AVANT");
         }
         else if (cle.getHeureDepart().isAfter(v.getHeureArrive()))
         {
             volAvantApres.put(cle, "APRES");
         }
     }
         return volAvantApres;
     }
     
     
    //fonction renvoie une HashMap contenant le vol en key et une ArrayList des
    //membres du personnel en conflit en valeur;
    //Prend en entrée le pilote1, pilote2, hotesse1, 2, 3 pour trouver les éventuels doublons
    private HashMap memePersonnel (Vol v, Pilote p1, Pilote p2, Hotesse h1, Hotesse h2, Hotesse h3)
    {
        //HashMap qui récupère le vol avec lequel il y a un conflit de personnel et le personnel en conflit
        HashMap <Vol, ArrayList> volMmPersonnel = new HashMap <>();
        //ArrayList pour remplir la HashMap du dessus avec le personnel en conflit
        ArrayList personnelDoublon = new ArrayList ();
        
        //pour chaque entrée de la HashMap d'affectation
        for(Map.Entry< Vol, ArrayList> entry : this.affectationVol.entrySet()) 
     {
    Vol cle = entry.getKey();
    ArrayList  valeur = entry.getValue();
        // Pour chaque membre du personnel de chaque vol de la HashMap affectationVol 
         //Si un membre du personnel est en conflit on l'ajoute à l'arraylist du personnel en conflit
      if (v.getJourSemaine().equals(cle.getJourSemaine())){
         for (int i = 0; i<valeur.size(); i++) {
            if (valeur.get(i).equals(p1)) {
                personnelDoublon.add(p1);
            }
            if (valeur.get(i).equals(p2))
            {
                personnelDoublon.add(p2);
            }
            if (valeur.get(i).equals(h1))
            {
                personnelDoublon.add(h1);
            }
            if (valeur.get(i).equals(h2))
            {
                personnelDoublon.add(h2);
            }
            if (valeur.get(i).equals(h3))
            {
                personnelDoublon.add(h3);
            }
            
        }
        //Si on a trouvé un même membre du personnel alors l'ArrayList n'est pas vide
        if (!personnelDoublon.isEmpty())
            {
                // donc on clone l'ArrayList personnel doublon
                ArrayList copy = (ArrayList) personnelDoublon.clone();
                // et on ajoute l'arraylist clonée à la HashMap 
                volMmPersonnel.put(cle, copy);
                // Puis on vide l'ArrayList pour le tour suivant 
               personnelDoublon.clear();
            }
             
     }
     }
        //et on retourne la HashMap 
     return volMmPersonnel;   
    }
    
    
    
    public HashMap<Vol, ArrayList> getAffectationVol() {
        return affectationVol;
    }

    public HashMap<Vol, Avion> getAffectationVolAvion() {
        return affectationVolAvion;
    }

    
 //method qui en fonction du moment du retard (si il y a retard) défini par le String retard (aucun/pre-decollage/post-decollage)
//et la duree du retard defini par int dureeRetard
//retourne les vol qui se retrouveront en conflit avec celui-ci pour un retard de 6heures
private ArrayList verifPlageHoraire(String retard, int dureeRetard, Vol v, HashMap<Vol, ArrayList> memepersonnel) {
        //liste qui stock les vols conflictuels 
        ArrayList<Vol> volconflictuel = new ArrayList<>();
        // Boolean qui determine si un vol est conflictuel ou non
        Boolean pasconflit = true;
        // pour chaque entrée de la HashMap en entrée de la fonction
        for (Map.Entry< Vol, ArrayList> entry : memepersonnel.entrySet()) {
            Vol cle = entry.getKey();
            //pour chaque cas de retard
            switch (retard.toUpperCase()){
                //si aucun retard 
                case "AUCUN":
                   pasconflit = conflit (cle, v, retard, dureeRetard);
                   break;
                //si le retard est pre-decollage
                case "PRE-DECOLLAGE":
                    //si l'heure de départ du vol de la clé est avant l'heure de départ du vol qu'on vérifie
                    pasconflit = conflit (cle, v, retard, dureeRetard);
                    break;
                //si le retard est post-decollage
                case "POST-DECOLLAGE":
                    pasconflit = conflit (cle, v, retard, dureeRetard);
                     break;
            } 
            // Si conflit est faux 
                    if (!pasconflit) {
                        //on ajoute le vol à la liste des vols conflictuels
                        volconflictuel.add(cle);
                    }  
        }
        return volconflictuel;
}
 
public boolean conflit (Vol clevol, Vol v, String retard, int dureeRetard)
        
{
    boolean pasconflit = true;
    
    if ("PRE-DECOLLAGE".equals(retard) || "AUCUN".equals(retard)){
     if (clevol.getHeureDepart().isBefore(v.getHeureDepart().plusHours(dureeRetard))) {
                        // on vérifie si l'arrivé du vol de la clé est avant l'heure de départ du vol qu'on vérifie
                        if (clevol.getHeureArrive().isBefore(v.getHeureDepart().plusHours(dureeRetard))) {
                            // si oui on retourne vrai 
                            pasconflit = true;
                        } //sinon on retourne faux
                        else {
                            pasconflit = false;
                        }
                    }
                    //si l'heure de départ du vol de la clé est après l'heure de départ du vol qu'on vérifie
                    if (clevol.getHeureDepart().isAfter(v.getHeureDepart().plusHours(dureeRetard))) {
                        //alors on vérifie si l'heure de départ de la clé est après l'heure d'arrivé du vol qu'on vérifie
                        if (clevol.getHeureDepart().isAfter(v.getHeureArrive().plusHours(dureeRetard))) {
                            //si ok alors true
                            pasconflit = true;
                        } //sinon faux 
                        else {
                            pasconflit = false;
                        }
                    }
                    if (clevol.getHeureDepart().equals(v.getHeureDepart().plusHours(dureeRetard)))
                    {
                        pasconflit = false;
                    }
    }
    else if ("POST-DECOLLAGE".equals(retard))
    {
        if (clevol.getHeureDepart().isBefore(v.getHeureDepart())) {
                        // on vérifie si l'arrivé du vol de la clé est avant l'heure de départ du vol qu'on vérifie
                        if (clevol.getHeureArrive().isBefore(v.getHeureDepart())) {
                            // si oui on retourne vrai 
                            pasconflit = true;
                        } //sinon on retourne faux
                        else {
                            pasconflit = false;
                        }
                    }
                    //si l'heure de départ du vol de la clé est après l'heure de départ du vol qu'on vérifie
                    if (clevol.getHeureDepart().isAfter(v.getHeureDepart())) {
                        //alors on vérifie si l'heure de départ de la clé est après l'heure d'arrivé du vol qu'on vérifie
                        if (clevol.getHeureDepart().isAfter(v.getHeureArrive().plusHours(dureeRetard))) {
                            //si ok alors true
                            pasconflit = true;
                        } //sinon faux 
                        else {
                            pasconflit = false;
                        }
                    }
                    if (clevol.getHeureDepart().equals(v.getHeureDepart()))
                    {
                        pasconflit = false;
                    }
    }
    return pasconflit;
}
 
 public void retard (String retard, int dureeRetard, Vol vol)
 {
      Pilote pilote =(Pilote) vol.getPersonnelaffecte().get(0);
      Pilote copilote = (Pilote) vol.getPersonnelaffecte().get(1);
      Hotesse h1 =(Hotesse) vol.getPersonnelaffecte().get(2);
      Hotesse h2 =(Hotesse) vol.getPersonnelaffecte().get(3);
      Hotesse h3 =(Hotesse) vol.getPersonnelaffecte().get(4);
     
      HashMap<Vol, ArrayList> memePersonnel;
      memePersonnel = this.memePersonnel(vol, pilote, copilote, h1, h2, h3);
      
      HashMap<Vol, ArrayList> memeAvion;
      memeAvion = this.memeAvion(vol, vol.getAvionaffecte());
        
      ArrayList<Vol> volConflictuelAvion;
      volConflictuelAvion = this.verifPlageHoraire(retard, dureeRetard, vol, memeAvion);
      
      ArrayList<Vol> volConflictuelPerso;
      volConflictuelPerso =  this.verifPlageHoraire(retard, dureeRetard, vol, memePersonnel);
      
      if (volConflictuelPerso.isEmpty() && volConflictuelAvion.isEmpty())
      {
          System.out.println ("Un retard de " +dureeRetard+ "h sur ce vol n'affecterais aucun autre vol");
          System.out.println ("--------------------------------------------------------");

      }
      else if (!volConflictuelAvion.isEmpty() && volConflictuelPerso.isEmpty())
      {
          System.out.println ("Un retard de  " +dureeRetard+ "h sur ce vol affecterais "+volConflictuelAvion.size()+ " vol(s) car ils ont le même avion");
          System.out.println ("--------------------------------------------------------");

      }
      else if (!volConflictuelPerso.isEmpty() && volConflictuelAvion.isEmpty())  
      {
          System.out.println ("Un retard de  " +dureeRetard+ "h sur ce vol affecterais "+volConflictuelPerso.size()+ " vol(s) car ils ont le même personnel");
          System.out.println ("--------------------------------------------------------");

      }
      else if (!volConflictuelPerso.isEmpty() && !volConflictuelAvion.isEmpty())  
      {
          System.out.println ("Un retard de  " +dureeRetard+ "h sur ce vol affecterais "+volConflictuelPerso.size()+ " vol(s) car ils ont le même personnel");
          System.out.println ("Un retard de  " +dureeRetard+ "h sur ce vol affecterais "+volConflictuelAvion.size()+ " vol(s) car ils ont le même avion");
          System.out.println ("Un total de " +(volConflictuelPerso.size()+volConflictuelAvion.size())+ " vol(s) impactés en tout") ;
          System.out.println ("--------------------------------------------------------");



      }
 }
    
  
}