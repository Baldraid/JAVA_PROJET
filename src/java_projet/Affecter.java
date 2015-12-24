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

    //methode pour affecter un avion à un vol
    public void affecterAvion(Vol vol, Avion a){
        //ArrayList pour la valeur de l'HashMap
        ArrayList affecter = new ArrayList();
        //ArrayList qui récupère les vols en conflits
        ArrayList <Vol> memeAvion = new ArrayList<> ();
        //On insère les vols en conflits à cause d'un même avion grâce à la fonction memeAvion plus loin 
        memeAvion = this.memeAvion(vol, a);
        //s'il n'y a pas de vols en conflits alors on ajoute directement l'avion à l'ArrayList qui sera valeur de la HashMap
        //et on ajoute à la HashMap le vol et l'arraylist de l'avion affecté
        if (memeAvion.isEmpty())
        {
            affecter.add(a);
            this.affectationVol.put(vol, affecter);
            //on ajoute au vol l'arrayList de l'avion affecté
            vol.affecteravion(affecter);
            //Sinon on vérifie les plages horaires du vol qu'on veut affecter aux vols auxquels il peut être en conflits car même membre du personnel
        }
        else {
            //pour chaque vols en conflit
            for (int i = 0; i< memeAvion.size(); i ++)
            {   
            //si pas de conflit de plage horaire alors on ajoute le personnel à l'arraylist et on ajoute le vol et l'arrayList à la Hashmap
                if (verifPlageHoraire(vol)== true) {
                    affecter.add(a);
                    this.affectationVol.put(vol, affecter);
                    vol.affecteravion(affecter);
                    System.out.println("Avion bien affecté");
                }
                else 
                {
                    //Sinon message d'erreur
                    System.out.println("Vous ne pouvez pas affecter cet avion à ce vol, conflit avec un autre vol");
                }
           }
        }
    }
    
    //fonction qui ajoute les vols éventuellement en conflits (s'ils ont un avion en commun)
    private ArrayList memeAvion (Vol v, Avion a)
    {
        //arraylist qui reçoit les vols en conflits
        ArrayList <Vol> volMemeAvion = new ArrayList<>();
        //pour chaque entrée de la HashMap d'affectation
        for(Map.Entry< Vol, ArrayList> entry : this.affectationVol.entrySet()) 
        {
            Vol cle = entry.getKey();
            ArrayList valeur = entry.getValue();
                //si l'avion est sur un autre vol on ajoute le vol à l'arraylist
                for (int i = 0; i<valeur.size(); i++) {
                    if (valeur.get(i).equals(a))
                    {
                       volMemeAvion.add(cle);
                    }
                }
        }
        //et on retourne l'arraylist
        return volMemeAvion;   
    }
    
    //fonction pour affecter le personnel à un vol 
    //retourne un boolean pour déterminer si l'on ajoute les membres du personnel au vol en question
    // attribut ArrayList personnelaffecter de la classe vol
    // si false on l'ajoute sinon non
     public boolean affecterPersoVol(Vol vol, Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3) {
        //ArrayList pour la valeur de l'HashMap affectation vol de cette classe
        ArrayList affecter = new ArrayList();
        //HashMap qui récupère le vol et le personnel en conflit avec le vol auquel on veut affecter 
        // Se remplie avec la fonction memepersonnel
        HashMap<Vol, ArrayList> memePersonnel;
        memePersonnel = this.memePersonnel(vol, pilote, copilote, hotesse1, hotesse2, hotesse3);
        //HashMap qui récupère les vols en conflits de plage horaire
        //J'aurais pu juste utiliser une ArrayList mais tant pis je changerais plus tard
        // se remplie avec la fonction verifPlageHoraire
        ArrayList<Vol> volConflictuel;
        volConflictuel = this.verifPlageHoraire(vol, memePersonnel);
        //Booleen pour le retour de la fonction
        boolean conflit = false;
        //S'il n'y a pas de personnel en conflit ou pas de conflit de plage horaire alors on ajoute directement
        if (memePersonnel.isEmpty() || volConflictuel.isEmpty()) {
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
        } //Sinon on vérifie les plages horaires du vol qu'on veut affecter
        //aux vols auxquels il peut être en conflits car même membre du personnel
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
    //On vérifie les conflits de plages horaires
    //à partir d'un Vol et d'une liste contenant le vol en conflit et les membres du personnel associés
    //Renvoie une HashMap contenant le vol en conflit et un booleen seulement s'il y a conflit
    //Si conflit = true alors il n'y a pas de conflit de plage horaire si = false alors conflit
    // (oui c'est plutot l'inverse mais flemme de changer ^^)
    private ArrayList verifPlageHoraire(Vol v, HashMap<Vol, ArrayList> memepersonnel) {
        //liste qui stock les vols conflictuels 
        ArrayList<Vol> volconflictuel = new ArrayList<>();
        // Boolean qui determine si un vol est conflictuel ou non
        Boolean conflit = true;
        // pour chaque entrée de la HashMap en entrée de la fonction
        for (Map.Entry< Vol, ArrayList> entry : memepersonnel.entrySet()) {
            Vol cle = entry.getKey();
            ArrayList valeur = entry.getValue();
            //si l'heure de départ du vol de la clé est avant l'heure de départ du vol qu'on vérifie
            if (cle.getHeureDepart().isBefore(v.getHeureDepart())) {
                // on vérifie si l'arrivé du vol de la clé est avant l'heure de départ du vol qu'on vérifie
                if (cle.getHeureArrive().isBefore(v.getHeureDepart())) {
                    // si oui on retourne vrai 
                    conflit = true;
                } //sinon on retourne faux
                else {
                    conflit = false;
                }
            }
            //si l'heure de départ du vol de la clé est après l'heure de départ du vol qu'on vérifie
            if (cle.getHeureDepart().isAfter(v.getHeureDepart())) {
                //alors on vérifie si l'heure de départ de la clé est après l'heure d'arrivé du vol qu'on vérifie
                if (cle.getHeureDepart().isAfter(v.getHeureArrive())) {
                    //si ok alors true
                    conflit = true;
                } //sinon faux 
                else {
                    conflit = false;
                }
            }
            // Si conflit est faux 
            if (!conflit) {
                //on ajoute le vol à la liste des vols conflictuels
                volconflictuel.add(cle);
            }
        }
        return volconflictuel;
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
    ArrayList valeur = entry.getValue();
        // Pour chaque membre du personnel de chaque vol de la HashMap affectationVol 
         //Si un membre du personnel est en conflit on l'ajoute à l'arraylist du personnel en conflit
      if (v.getJourSemaine().equals(cle.getJourSemaine())){
         for (int i = 0; i<valeur.size(); i++) {
            if (valeur.get(i).equals(p1)) {
                personnelDoublon.add(p1);
            }
            else if (valeur.get(i).equals(p2))
            {
                personnelDoublon.add(p2);
            }
            else if (valeur.get(i).equals(h1))
            {
                personnelDoublon.add(h1);
            }
            else if (valeur.get(i).equals(h2))
            {
                personnelDoublon.add(h2);
            }
            else if (valeur.get(i).equals(h3))
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

    public void setAffectationVol(HashMap<Vol, ArrayList> affectationVol) {
        this.affectationVol = affectationVol;
    }


}