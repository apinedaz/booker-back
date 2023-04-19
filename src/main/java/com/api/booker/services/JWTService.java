package com.api.booker.services;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service("jwt")
public class JWTService {

    public String generateToken(int user){
        return Jwts.builder()
                .claim("user",String.valueOf(user))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(60l, ChronoUnit.MINUTES)))
                .compact();
    }
}
