package com.example.jwt.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestParam String username, @RequestParam String password) {
        Map<String, String> response = new HashMap<>();
        
        // Simple mock authentication
        if ("admin".equals(username) && "password".equals(password)) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hr expiration
                    .signWith(key)
                    .compact();
            
            response.put("token", token);
            response.put("status", "Success");
        } else {
            response.put("status", "Unauthorized");
        }
        
        return response;
    }
}\n