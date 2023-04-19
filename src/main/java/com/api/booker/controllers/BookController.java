package com.api.booker.controllers;

import com.api.booker.models.in.Book;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.BookRepository;
import com.api.booker.services.cast.CastBookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CastBookEntity cast;

    @GetMapping("/get-all")
    public ResponseApi getAll(){
        try{
            var books = bookRepository.findAll();

            var responseBooks = cast.castList(books);
            return new ResponseApi<List<Book>>(responseBooks,200,"Success",true);
        } catch(Exception e){
            return new ResponseApi<String>(null,500,e.getMessage(),false);
        }
    }

}
