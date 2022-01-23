package fr.cristhiancasierra.geotag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.Lieu;

public interface LieuRepo extends JpaRepository<Lieu, String> {

}
