package com.libarymanagment.libarymanagement.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {

    private String username;
    private String password;
}
//If we use builder behind the scences lombok will generate a builder class for us.
/*
public class LoginRequestDTO {
    private String username;
    private String password;

    LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginRequestDTOBuilder builder() {
        return new LoginRequestDTOBuilder();
    }

    public static class LoginRequestDTOBuilder {
        private String username;
        private String password;

        LoginRequestDTOBuilder() {}

        public LoginRequestDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginRequestDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequestDTO build() {
            return new LoginRequestDTO(username, password);
        }
    }
}
 */
