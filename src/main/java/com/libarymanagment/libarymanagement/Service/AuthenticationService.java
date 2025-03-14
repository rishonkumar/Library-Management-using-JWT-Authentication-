package com.libarymanagment.libarymanagement.Service;

import com.libarymanagment.libarymanagement.DTO.LoginRequestDTO;
import com.libarymanagment.libarymanagement.DTO.LoginResponseDTO;
import com.libarymanagment.libarymanagement.DTO.RegisterRequestDTO;
import com.libarymanagment.libarymanagement.Entity.User;
import com.libarymanagment.libarymanagement.JWT.JwtService;
import com.libarymanagment.libarymanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;



    public User registerNormalUser(RegisterRequestDTO registerRequestDTO) {

        if(userRepository.findByUserName(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_USER");
        User user = new User();
        user.setUserName(registerRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setRoles(roles);
        return userRepository.save(user);
    }

     public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),loginRequestDTO.getPassword()));

        User user = userRepository.findByUserName(loginRequestDTO.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return LoginResponseDTO.builder()
                .token(token)
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();

    }

    public User registerAdminUser(RegisterRequestDTO registerRequestDTO)  {
        if(userRepository.findByUserName(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");

        User user = new User();
        user.setUserName(registerRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setRoles(roles);
        return userRepository.save(user);

    }
}
