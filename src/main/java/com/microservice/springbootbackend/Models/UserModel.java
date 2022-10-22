package com.microservice.springbootbackend.Models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {
    @NotBlank(message = "Your name is required")
    private String name;

    @NotNull(message = "Email should not be empty")
    private String email;

    @NotNull(message= "password should not be empty")
    @Size(min= 5, message = "Password should be at least 5 characters")
    private String password;

//    private Long age = 0L;
}
