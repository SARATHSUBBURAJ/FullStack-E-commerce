package com.fullProject.demo.jwt.controller;

import com.fullProject.demo.jwt.configuration.JwtRequestFilter;
import com.fullProject.demo.jwt.entity.JwtRequest;
import com.fullProject.demo.jwt.entity.JwtResponse;
import com.fullProject.demo.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtRequestFilter.createJwtToken(jwtRequest);
    }
}
