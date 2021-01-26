package com.openclassrooms.paymybuddyapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    public String hashPassword(String password){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String hashPassword = encoder.encode(password);
        return hashPassword ;
    }
}
