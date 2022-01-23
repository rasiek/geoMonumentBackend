package fr.cristhiancasierra.geotag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.Departement;

public interface DepartamentRepo extends JpaRepository<Departement, String> {

}
