package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.Exception.ObjetNotFoundException;
import fr.cristhiancasierra.geotag.entity.Celebrite;
import fr.cristhiancasierra.geotag.repository.CelebriteRepo;

@Service
public class CelebriteService {

    private CelebriteRepo celebriteRepo;

    @Autowired
    public CelebriteService(CelebriteRepo celebriteRepo) {

        this.celebriteRepo = celebriteRepo;
    }

    public Celebrite addCelebrite(Celebrite celebrite) {
        return this.celebriteRepo.save(celebrite);
    }

    public List<Celebrite> findACelebrites() {
        return this.celebriteRepo.findAll();
    }

    public Celebrite findCelebriteById(int id) {
        return this.celebriteRepo.findById(id)
                .orElseThrow(() -> new ObjetNotFoundException("Celebrité by id " + id + " not found"));
    }

}
