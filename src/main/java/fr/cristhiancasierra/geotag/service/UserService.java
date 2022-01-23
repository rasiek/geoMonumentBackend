package fr.cristhiancasierra.geotag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.entity.User;
import fr.cristhiancasierra.geotag.repository.UserRepo;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    public User updateUser(User user) {
        return this.userRepo.save(user);
    }

    public User findUserByUsername(String userName) {
        return this.userRepo.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));
    }

    public Boolean existByUserName(String userName) {
        return this.userRepo.existsByUserName(userName);
    }

    public List<User> findUsers() {
        return this.userRepo.findAll();
    }
}
