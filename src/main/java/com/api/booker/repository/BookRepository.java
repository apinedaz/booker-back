package com.api.booker.repository;

import com.api.booker.models.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findAll();

    BookEntity save(BookEntity book);
}
