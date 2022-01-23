package fr.cristhiancasierra.geotag.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Celebrite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numCelebrite;
    private String nom;
    private String prenom;
    private String nationalite;
    private String epoque;
    @ManyToMany
    @JoinTable(name = "associea", joinColumns = @JoinColumn(name = "numc", referencedColumnName = "numcelebrite"), inverseJoinColumns = @JoinColumn(name = "codem", referencedColumnName = "geohash"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "geoHash")
    private Set<Monument> monuments;

    public Celebrite() {

    }

    public Celebrite(String nom, String prenom, String nationalite, String epoque) {

        this.epoque = epoque;
        this.nationalite = nationalite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setEpoque(String epoque) {
        this.epoque = epoque;
    }

    public String getEpoque() {
        return epoque;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNumCelebrite(int numCelebrite) {
        this.numCelebrite = numCelebrite;
    }

    public int getNumCelebrite() {
        return numCelebrite;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setMonuments(Set<Monument> monuments) {
        this.monuments = monuments;
    }

    public Set<Monument> getMonuments() {
        return monuments;
    }

}
