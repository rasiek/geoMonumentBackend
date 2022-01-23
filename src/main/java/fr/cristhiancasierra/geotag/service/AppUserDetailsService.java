package fr.cristhiancasierra.geotag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.cristhiancasierra.geotag.entity.AppUserDetails;
import fr.cristhiancasierra.geotag.entity.User;
import fr.cristhiancasierra.geotag.repository.UserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));

        return new AppUserDetails(user);

    }

}
