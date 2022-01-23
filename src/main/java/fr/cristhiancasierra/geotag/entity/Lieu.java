package fr.cristhiancasierra.geotag.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lieu {

    @Id
    private String codeInsee;
    private String nom;
    private float longitude;
    private float latitude;
    private String dep;

    public Lieu() {

    }

    public Lieu(String codeInsee, String nom, float longitude, float latitude, String dep) {

        this.codeInsee = codeInsee;
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dep = dep;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
