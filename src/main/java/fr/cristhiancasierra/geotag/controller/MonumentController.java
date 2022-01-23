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

import fr.cristhiancasierra.geotag.entity.Monument;
import fr.cristhiancasierra.geotag.service.MonumentService;

@RestController
@RequestMapping("/monument")
public class MonumentController {

    private MonumentService monumentService;

    public MonumentController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Monument>> getMonuments() {
        List<Monument> monuments = monumentService.findAllMonuments();
        return new ResponseEntity<>(monuments, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Monument> getMonumnentById(@PathVariable("id") String id) {
        Monument monument = monumentService.getMonument(id);

        return new ResponseEntity<>(monument, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Monument> addMonument(@RequestBody Monument monument) {
        Monument newMonument = monumentService.addMonument(monument);
        return new ResponseEntity<>(newMonument, HttpStatus.CREATED);
    }

}
