package com.api.booker.repository;

import com.api.booker.models.entity.BookEntity;
import com.api.booker.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    @Override
    List<BookEntity> findAll();

    @Override
    <S extends BookEntity> S save(S entity);
}
