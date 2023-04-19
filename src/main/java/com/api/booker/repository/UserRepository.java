package com.api.booker.repository;

import com.api.booker.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsernameAndPassword(String username,String password);

    UserEntity save(UserEntity user);
}
