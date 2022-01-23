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

import fr.cristhiancasierra.geotag.entity.Celebrite;
import fr.cristhiancasierra.geotag.service.CelebriteService;

@RestController
@RequestMapping(path = "/celeb")
public class CelebriteController {

    private CelebriteService celebriteService;

    public CelebriteController(CelebriteService celebriteService) {
        this.celebriteService = celebriteService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Celebrite>> getDepartements() {
        List<Celebrite> celebrites = celebriteService.findACelebrites();
        return new ResponseEntity<>(celebrites, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Celebrite> getById(@PathVariable("id") String idString) {

        int id = Integer.parseInt(idString);
        Celebrite celebrite = celebriteService.findCelebriteById(id);
        return new ResponseEntity<>(celebrite, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Celebrite> addDepartement(@RequestBody Celebrite celebrite) {
        Celebrite newCelebrite = celebriteService.addCelebrite(celebrite);
        return new ResponseEntity<>(newCelebrite, HttpStatus.CREATED);
    }

}
