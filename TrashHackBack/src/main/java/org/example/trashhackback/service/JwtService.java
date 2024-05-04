package org.example.trashhackback.service;

import io.jsonwebtoken.Claims;
import org.example.trashhackback.entity.UserDao;
import org.example.trashhackback.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private JwtUtil jwtUtil;

    public JwtService() {
        this.jwtUtil = new JwtUtil();
    }

    public String generateToken(Long userId) {
        return jwtUtil.generateToken(userId);
    }

    public Boolean validateToken(String token, String username) {
        return jwtUtil.validateToken(token, username);
    }

    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    public Date extractExpiration(String token) {
        return jwtUtil.extractExpiration(token);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return jwtUtil.extractClaim(token, claimsResolver);
    }
}