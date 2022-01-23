package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.Exception.ObjetNotFoundException;
import fr.cristhiancasierra.geotag.entity.Departement;
import fr.cristhiancasierra.geotag.repository.DepartamentRepo;

@Service
public class DepartementService {

    private DepartamentRepo departamentRepo;

    @Autowired
    public DepartementService(DepartamentRepo departamentRepo) {
        this.departamentRepo = departamentRepo;
    }

    public Departement addDepartamnent(Departement departement) {
        return this.departamentRepo.save(departement);
    }

    public List<Departement> findAllDepartaments() {
        return this.departamentRepo.findAll();
    }

    public Departement findDepartementById(String id) {
        return this.departamentRepo.findById(id)
                .orElseThrow(() -> new ObjetNotFoundException("Departement by id " + id + "not found"));
    }
}
