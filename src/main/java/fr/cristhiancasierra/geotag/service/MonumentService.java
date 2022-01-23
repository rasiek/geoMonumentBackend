package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.Exception.ObjetNotFoundException;
import fr.cristhiancasierra.geotag.entity.Monument;
import fr.cristhiancasierra.geotag.repository.MonumentRepo;

@Service
public class MonumentService {

    private final MonumentRepo monumentRepo;

    @Autowired
    public MonumentService(MonumentRepo monumentRepo) {

        this.monumentRepo = monumentRepo;
    }

    public Monument addMonument(Monument monument) {

        return monumentRepo.save(monument);
    }

    public List<Monument> findAllMonuments() {

        return monumentRepo.findAll();
    }

    public Monument updateMonument(Monument monument) {
        return monumentRepo.save(monument);
    }

    public void deleteMonument(String geoHash) {
        monumentRepo.deleteById(geoHash);
    }

    public Monument getMonument(String geoHash) {
        return monumentRepo.findById(geoHash)
                .orElseThrow(() -> new ObjetNotFoundException("Monument by id" + geoHash + "not found"));
    }

}
