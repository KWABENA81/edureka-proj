package com.sas.jwtservice.service;

import com.sas.jwtservice.exception.UserNotFoundException;
import com.sas.jwtservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}