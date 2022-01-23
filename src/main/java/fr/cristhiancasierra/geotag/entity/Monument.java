package fr.cristhiancasierra.geotag.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Monument implements Serializable {

    @Id
    private String geoHash;
    private String nomM;
    private String proprietaire;
    private String typeM;
    private float longitude;
    private float latitude;
    private String codeInsee;
    @ManyToMany(mappedBy = "monuments")
    @JsonIgnore
    private Set<Celebrite> celebrites;

    public Monument() {
    }

    public Monument(String geoHash, String nomM, String proprietaire, String typeM, float longitude, float latitude,
            String codeInsee) {
        this.codeInsee = codeInsee;
        this.geoHash = geoHash;
        this.latitude = latitude;
        this.longitude = longitude;
        this.proprietaire = proprietaire;
        this.typeM = typeM;
        this.nomM = nomM;

    }

    public void setCelebrites(Set<Celebrite> celebrites) {
        this.celebrites = celebrites;
    }

    public Set<Celebrite> getCelebrites() {
        return celebrites;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }

    public String getGeoHash() {
        return geoHash;
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

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getNomM() {
        return nomM;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setTypeM(String typeM) {
        this.typeM = typeM;
    }

    public String getTypeM() {
        return typeM;
    }
}
