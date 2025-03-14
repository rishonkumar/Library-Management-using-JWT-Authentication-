package com.libarymanagment.libarymanagement.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDTO {

    private String username;
    private String password;
    private String email;
}
