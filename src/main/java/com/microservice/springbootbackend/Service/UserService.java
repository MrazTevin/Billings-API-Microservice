package com.microservice.springbootbackend.Service;

import com.microservice.springbootbackend.Models.User;
import com.microservice.springbootbackend.Models.UserModel;

public interface UserService {

  User createUser(UserModel user);
  User readUser(UserModel user);
}
