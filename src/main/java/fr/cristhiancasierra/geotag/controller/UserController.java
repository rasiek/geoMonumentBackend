package fr.cristhiancasierra.geotag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cristhiancasierra.geotag.entity.User;
import fr.cristhiancasierra.geotag.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = this.userService.findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
