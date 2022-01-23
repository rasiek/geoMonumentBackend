package fr.cristhiancasierra.geotag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.Monument;

public interface MonumentRepo extends JpaRepository<Monument, String> {

}
