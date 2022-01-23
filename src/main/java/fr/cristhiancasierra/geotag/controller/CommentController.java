package fr.cristhiancasierra.geotag.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cristhiancasierra.geotag.entity.Comment;
import fr.cristhiancasierra.geotag.service.CommentService;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<List<Comment>> findAllbyObjectId(@PathVariable("id") String id) {
        List<Comment> comments = this.commentService.findByObjectId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        comment.setCreatedAt(new Date());
        Comment newComment = this.commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

}
