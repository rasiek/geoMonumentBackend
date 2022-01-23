package fr.cristhiancasierra.geotag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.cristhiancasierra.geotag.entity.AppUserDetails;
import fr.cristhiancasierra.geotag.entity.AuthenticationRequest;
import fr.cristhiancasierra.geotag.entity.AuthenticationResponse;
import fr.cristhiancasierra.geotag.entity.User;
import fr.cristhiancasierra.geotag.entity.UserDto;
import fr.cristhiancasierra.geotag.service.AppUserDetailsService;
import fr.cristhiancasierra.geotag.service.UserService;
import fr.cristhiancasierra.geotag.util.JwtUtil;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e) {

            throw new Exception("Incorrect username or pass", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        if (userService.existByUserName(userDto.getUserName())) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }

        User user = new User();

        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setIsActive(userDto.getIsActive());

        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
