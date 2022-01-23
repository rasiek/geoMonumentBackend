package fr.cristhiancasierra.geotag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.Celebrite;

public interface CelebriteRepo extends JpaRepository<Celebrite, Integer> {

}
