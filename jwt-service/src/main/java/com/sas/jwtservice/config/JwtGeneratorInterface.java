package com.sas.jwtservice.config;

import com.sas.jwtservice.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}
