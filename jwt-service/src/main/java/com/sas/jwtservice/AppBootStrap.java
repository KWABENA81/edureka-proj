package com.sas.jwtservice;

import com.sas.jwtservice.model.User;
import com.sas.jwtservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppBootStrap implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    public AppBootStrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String...arg) {
        userRepository.save(new User("sas", "pass234"));
        userRepository.save(new User("sask", "pass1234"));
    }
}
