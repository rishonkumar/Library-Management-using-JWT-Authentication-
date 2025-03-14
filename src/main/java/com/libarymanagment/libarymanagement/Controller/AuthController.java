package com.libarymanagment.libarymanagement.Controller;

import com.libarymanagment.libarymanagement.DTO.LoginRequestDTO;
import com.libarymanagment.libarymanagement.DTO.LoginResponseDTO;
import com.libarymanagment.libarymanagement.DTO.RegisterRequestDTO;
import com.libarymanagment.libarymanagement.Entity.User;
import com.libarymanagment.libarymanagement.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/registernnormaluser")
    public ResponseEntity<User> registerNormalUser(@RequestBody RegisterRequestDTO registerRequestDTO) {

        return ResponseEntity.ok(authenticationService.registerNormalUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authenticationService.login(loginRequestDTO));
    }
}
