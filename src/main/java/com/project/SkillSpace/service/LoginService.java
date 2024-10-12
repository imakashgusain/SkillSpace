package com.project.SkillSpace.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    public String generateToken(String username) {
        String SECRET_KEY = "zH8q6PpL1UyFxXnBxBqvFJb5aSNQJDOnPgoqTVBfWsA=";
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
