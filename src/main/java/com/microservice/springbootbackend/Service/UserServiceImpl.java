package com.microservice.springbootbackend.Service;

import com.microservice.springbootbackend.Exception.EmailExistsException;
import com.microservice.springbootbackend.Models.User;
import com.microservice.springbootbackend.Models.UserModel;
import com.microservice.springbootbackend.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(UserModel user) {
        if (userRepository.emailAlreadyExists(user.getEmail())) {
            throw new EmailExistsException("User is already registered with email: " + user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepository.save(newUser);
    }
}
