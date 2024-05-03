package org.example.trashhackback.service;

import org.example.trashhackback.entity.UserDao;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(String login, String password) {
        return login + ":" + password;
    }

    public UserDao getFromToken(String token) {
        UserDao user = new UserDao();

        String[] split = token.split(":");
        user.setLogin(split[0]);
        user.setPassword(split[1]);

        return user;
    }
}
