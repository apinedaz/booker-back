package com.api.booker.services.cast;

import com.api.booker.models.entity.BookEntity;
import com.api.booker.models.in.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CastBookEntity {

    public List<Book> castList(List<BookEntity> books){
        var cast = books.stream().map(book ->
                new Book(book.getBook_id(),book.getName(),book.getUser_id(),book.getDescription(),book.getQuality(),book.getUrl(),book.getReserved())

        ).collect(Collectors.toList());

        return cast;
    }
}
