package com.api.booker.services;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service()
public class EncodeService {

    public String encode(String text) throws NoSuchAlgorithmException {

        var digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        var encoded = Base64.getEncoder().encodeToString(hash);
        return encoded;
    }
}
