package fr.cristhiancasierra.geotag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

}
