package com.api.booker.services.cast;

import com.api.booker.models.entity.UserEntity;
import com.api.booker.models.in.User;
import org.springframework.stereotype.Service;

@Service()
public class CastUserEntity {

    public UserEntity cast(User user){
        return new UserEntity(user.getUsername(), user.getPassword(),user.getState());
    }
}
