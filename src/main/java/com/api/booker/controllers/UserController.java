package com.api.booker.controllers;

import com.api.booker.models.entity.UserEntity;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.UserRepository;
import com.api.booker.services.EncodeService;
import com.api.booker.services.cast.CastUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository uRepo;

    @Autowired
    CastUserEntity userCastService;

    @Autowired
    EncodeService encoder;

    @PostMapping("/create")
    public ResponseApi crete(@RequestBody com.api.booker.models.in.User request){
        try{

            var entity = userCastService.cast(request);

            var pass = encoder.encode(request.getPassword());
            entity.setPassword(pass);
            var create = uRepo.save(entity);

            return new ResponseApi<UserEntity>(create, 200,"Usuario creado.",true);

        } catch (Exception e){
            return new ResponseApi("",500,e.getMessage(),false);
        }
    }

}
