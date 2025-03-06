package com.libarymanagment.libarymanagement.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LoginResponseDTO {

    private String token;
    private String username;
    private Set<String> roles;
}
