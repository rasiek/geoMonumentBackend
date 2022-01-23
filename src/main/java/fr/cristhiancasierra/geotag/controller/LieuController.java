package fr.cristhiancasierra.geotag.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cristhiancasierra.geotag.entity.Lieu;
import fr.cristhiancasierra.geotag.service.LieuService;

@RestController
@RequestMapping(path = "/lieu")
public class LieuController {

    private LieuService lieuService;

    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Lieu>> getDepartements() {
        List<Lieu> lieux = lieuService.findAllLieux();
        return new ResponseEntity<>(lieux, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Lieu> getById(@PathVariable("id") String id) {
        Lieu lieu = lieuService.findLieuById(id);
        return new ResponseEntity<>(lieu, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Lieu> addDepartement(@RequestBody Lieu lieu) {
        Lieu newLieu = lieuService.addLieu(lieu);
        return new ResponseEntity<>(newLieu, HttpStatus.CREATED);
    }
}
