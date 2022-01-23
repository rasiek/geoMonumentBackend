package fr.cristhiancasierra.geotag.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Departement {

    @Id
    private String dep;
    private String nomDep;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chefLieu", referencedColumnName = "codeInsee")
    private Lieu chefLieu;
    private String reg;

    public Departement() {
    }

    public Departement(String dep, String nomDep, Lieu chefLieu, String reg) {

        this.chefLieu = chefLieu;
        this.dep = dep;
        this.nomDep = nomDep;
        this.reg = reg;

    }

    public void setChefLieu(Lieu chefLieu) {
        this.chefLieu = chefLieu;
    }

    public Lieu getChefLieu() {
        return chefLieu;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }
}
