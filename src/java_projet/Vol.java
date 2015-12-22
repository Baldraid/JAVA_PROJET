/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_projet;


import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.ArrayList;
import java.util.Map.Entry;
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

    public void setTarif(int tarif) {
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



    
    public Vol(String jourSemaine, Aeroport depart, Aeroport arrive, LocalTime heureDepart, LocalTime heureArrive, float tarif) {
        this.numVol = count.incrementAndGet();
        this.jourSemaine = jourSemaine;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.etat = "en création";
        // Calcule la durée en minute du vol en soustrayant l'heure d'arrivé à l'heure de départ
        this.duree = MINUTES.between(this.heureArrive, this.heureDepart);
        this.tarif = tarif;
        
    }
    
    public void affecterpersonnel (ArrayList a)
    {
        this.personnelaffecte = a;
        
    
        
        
    }
    
    public void affecterAvion (Avion a)
    {
        this.avionaffecte = a;
    }
       
}
