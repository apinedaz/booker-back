package com.api.booker.controllers;

import com.api.booker.models.in.Login;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.UserRepository;
import com.api.booker.services.EncodeService;
import com.api.booker.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import static java.util.Objects.isNull;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository uRepo;

    @Autowired
    JWTService jwtService;

    @Autowired
    EncodeService encoder;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/")
    public ResponseApi auth(@RequestBody Login request){
        try{

            var pass = encoder.encode(request.getPassword());

            var user = uRepo.findByUsernameAndPassword(request.getUsername(), pass);

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
