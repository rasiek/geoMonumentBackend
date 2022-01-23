package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.Exception.ObjetNotFoundException;
import fr.cristhiancasierra.geotag.entity.Lieu;
import fr.cristhiancasierra.geotag.repository.LieuRepo;

@Service
public class LieuService {

    private LieuRepo lieuRepo;

    @Autowired
    public LieuService(LieuRepo lieuRepo) {

        this.lieuRepo = lieuRepo;

    }

    public Lieu addLieu(Lieu lieu) {

        return this.lieuRepo.save(lieu);
    }

    public List<Lieu> findAllLieux() {
        return this.lieuRepo.findAll();
    }

    public Lieu findLieuById(String id) {
        return this.lieuRepo.findById(id)
                .orElseThrow(() -> new ObjetNotFoundException("Lieu by id " + id + " not found"));
    }

}
