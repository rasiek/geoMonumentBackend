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

import fr.cristhiancasierra.geotag.entity.Departement;
import fr.cristhiancasierra.geotag.service.DepartementService;

@RestController
@RequestMapping(path = "/dep")
public class DepartementController {

    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Departement>> getDepartements() {
        List<Departement> departements = departementService.findAllDepartaments();
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Departement> getById(@PathVariable("id") String id) {
        Departement departement = departementService.findDepartementById(id);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement) {
        Departement newDepartement = departementService.addDepartamnent(departement);
        return new ResponseEntity<>(newDepartement, HttpStatus.CREATED);
    }

}
