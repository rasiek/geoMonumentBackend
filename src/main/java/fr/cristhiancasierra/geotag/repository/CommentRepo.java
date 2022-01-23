package fr.cristhiancasierra.geotag.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cristhiancasierra.geotag.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    Optional<List<Comment>> findAllByObjectId(String id);

}
