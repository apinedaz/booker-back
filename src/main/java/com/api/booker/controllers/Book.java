package com.api.booker.controllers;

import com.api.booker.models.entity.BookEntity;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/")
@RestController
public class Book {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book/getAll")
    public ResponseApi getAll(){
        try{
            var books = bookRepository.findAll();

            return new ResponseApi<List<BookEntity>>(books,200,null,true);
        } catch (Exception e){
            return new ResponseApi<String>(e.getMessage(),500,"Error",false);
        }
    }
}
