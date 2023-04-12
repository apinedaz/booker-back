package com.api.booker.controllers;

import com.api.booker.models.entity.UserEntity;
import com.api.booker.models.in.Login;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.UserRepository;
import com.api.booker.services.JWTService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import static java.util.Objects.isNull;

@RequestMapping("api/")
@RestController
public class Auth {

    @Autowired
    UserRepository uRepo;

    @Autowired
    JWTService jwtService;
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/auth")
    public ResponseApi auth(@RequestBody Login request){
        try{

            var digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(request.getPassword().getBytes(StandardCharsets.UTF_8));
            var encoded = Base64.getEncoder().encodeToString(hash);

            var user = uRepo.findByUsernameAndPassword(request.getUsername(), encoded);

            if(isNull(user)){
                return new ResponseApi<String>("usuario o clave incorrecto", 404,"Usuario o clave incorrecto",false);
            }
            var token = jwtService.generateToken(user.getUser_id());

            return new ResponseApi<String>(token,200,null,true);

        } catch (Exception e){
            return new ResponseApi<String>(e.getMessage(),500,"Error",false);
        }
    }
}
