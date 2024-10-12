package com.project.SkillSpace.controller;

import com.project.SkillSpace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();

        if ("admin".equals(username) && "password".equals(password)) {
            String token = loginService.generateToken(username);
            response.put("message", "User logged in successfully");
            response.put("jwt", token);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }

}
