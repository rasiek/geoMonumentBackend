package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.Exception.ObjetNotFoundException;
import fr.cristhiancasierra.geotag.entity.Comment;
import fr.cristhiancasierra.geotag.repository.CommentRepo;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> findByObjectId(String id) {

        return this.commentRepo.findAllByObjectId(id)
                .orElseThrow(() -> new ObjetNotFoundException("Comments by id " + id + " not found"));
    }

    public Comment addComment(Comment comment) {
        return this.commentRepo.save(comment);
    }

}
