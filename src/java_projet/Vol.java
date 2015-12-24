/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;


import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.ArrayList;
//import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Mathilde Bedel
 */
public class Vol {
    private int numVol;
    private static final AtomicInteger count = new AtomicInteger(0); //compteur auto-increment
    private String jourSemaine;
    private Avion avionaffecte;
    private Aeroport depart;
    private Aeroport arrive;
    private LocalTime heureDepart;
    private LocalTime heureArrive;
    private long duree;
    private float tarif;
    private String etat;
    private ArrayList personnelaffecte;
    private static final Affecter a = new Affecter ();





    public int getNumVol() {
        return numVol;
    }

    
    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    public String getJourSemaine() {
        return jourSemaine;
    }

  

    public void setJourSemaine(String jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(LocalTime heureArrive) {
        this.heureArrive = heureArrive;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public ArrayList getPersonnelaffecte() {
        return personnelaffecte;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrive() {
        return arrive;
    }

    public void setArrive(Aeroport arrive) {
        this.arrive = arrive;
    }

    public Avion getAvionaffecte() {
        return avionaffecte;
    }

    public void setAvionaffecte(Avion avionaffecte) {
        this.avionaffecte = avionaffecte;
    }



    
  public Vol(String jourSemaine, Aeroport depart, Aeroport arrive, LocalTime heureDepart, LocalTime heureArrive, float tarif) {
        this.numVol = count.incrementAndGet();
        this.jourSemaine = jourSemaine;
        this.depart = depart;
        this.arrive = arrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.etat = "En création";
        // Calcule la durée en minute du vol en soustrayant l'heure d'arrivé à l'heure de départ
        this.duree = MINUTES.between( this.heureDepart, this.heureArrive);
        this.tarif = tarif;
       
        
    }
    
    public void affecterpersonnel (Pilote pilote, Pilote copilote, Hotesse hotesse1, Hotesse hotesse2, Hotesse hotesse3)
    {
      if(a.affecterPersoVol(this, pilote, copilote, hotesse1, hotesse2, hotesse3) == false){  
       personnelaffecte = new ArrayList ();
       personnelaffecte.add(pilote);
       personnelaffecte.add(copilote);
       personnelaffecte.add(hotesse1);
       personnelaffecte.add(hotesse2);
       personnelaffecte.add(hotesse3); 
       
       copilote.ajouterVolAffecter(this);
       pilote.ajouterVolAffecter(this);
       hotesse1.ajouterVolAffecte(this);
       hotesse2.ajouterVolAffecte(this);
       hotesse3.ajouterVolAffecte(this);


       this.setEtat("Programmé");}
        
    }
    
   public void affecteravion (Avion av)
    {
       if (a.affecterAvionVol(this, av) == false)
       {
           this.avionaffecte = av;
           av.ajouterVolAffecter(this);
           
           this.setEtat("En préparation");
       }
    }
   
   public void consult()
   {
        System.out.println("Informations du vol n°" +this.numVol);
        System.out.println("Départ le " +this.jourSemaine+ "à " +this.heureDepart);
        System.out.println("En partance de " +this.depart.getVilleA());
        System.out.println("A destination de " +this.arrive.getVilleA()+ ". Arrive à " +this.heureArrive);
        System.out.println("Durée : " +this.duree+ ". Tarif : " +this.tarif);
        System.out.println("Personnel naviguant : ");
        
        for (int i = 0; i< this.personnelaffecte.size() ; i++){
        System.out.println(personnelaffecte.get(i).toString());
        }
        System.out.println("-------------------------------");
   }

   public void modify (String jourSemaine, Aeroport depart, Aeroport arrive, LocalTime heureD, LocalTime heureA, float tarif)
   {
       String ancienJsemaine = this.jourSemaine;
       Aeroport ancienADep = this.depart;
       Aeroport ancienAArr = this.arrive;
       LocalTime ancienHDep = this.heureDepart;
       LocalTime ancienHArr = this.heureArrive;
       float ancienTarif = this.tarif;
       long ancienneDurée = this.duree; 
       
       this.setDepart(depart);
       this.setArrive(arrive);
       this.setHeureDepart(heureD);
       this.setHeureArrive(heureA);
       this.setTarif((float) tarif);
       this.setJourSemaine(jourSemaine);
       this.duree = MINUTES.between( this.heureDepart, this.heureArrive);
       System.out.println("Modifier vol n° " +this.numVol);
       System.out.println("Ancien Jour Semaine : "+ancienJsemaine+ ". Nouveau : " +this.jourSemaine);
       System.out.println("Ancien Aéroport de départ : " +ancienADep.getVilleA()+ ". Nouveau : " +this.depart.getVilleA());
       System.out.println("Ancien Aéroport d'arrivé : "+ancienAArr.getVilleA()+ ". Nouveau : " +this.arrive.getVilleA());
       System.out.println("Ancienne heure de départ : "+ancienHDep+ ". Nouveau : " +this.heureDepart);
       System.out.println("Ancienne jeure d'arrivée : "+ancienHArr+ ". Nouveau : " +this.heureArrive);
       System.out.println("Ancien Tarif : "+ancienTarif+ ". Nouveau : " +this.tarif);
       System.out.println("Ancienne Durée : "+ancienneDurée+ ". Nouveau : " +this.duree);
       System.out.println("----------------------------------------------------------------------");    
   }
   
   public void delete ()
   {
       this.setDepart(null);
       this.setArrive(null);
       this.setHeureDepart(null);
       this.setHeureArrive(null);
       this.setTarif(0);
       this.setJourSemaine(null);
       this.setDuree(0);
       this.personnelaffecte.clear();
       this.setEtat("");
       this.setAvionaffecte(null);
       System.out.println("Le vol a bien été supprimé");    

   }
}
