package com.lensoncode.tryouts.libraryservice.controller;

import com.lensoncode.tryouts.libraryservice.dto.AuthorDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookCollectionDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {

    private List<String> hardCodedDemoBooks = List.of(
            "Book1",
            "Book2",
            "Book3",
            "Book4");

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("book")
    public BookCollectionDTO getAllBooks() {
        List<BookInfoDTO> books = new ArrayList<>();
        hardCodedDemoBooks.forEach(bookName -> {
            BookDTO book = restTemplate
                    .getForObject("http://book-service/book/" + bookName, BookDTO.class);
            AuthorDTO author = restTemplate
                    .getForObject("http://author-service/author/" + book.getAuthor(), AuthorDTO.class);

            books.add(BookInfoDTO.builder()
                    .book(book)
                    .author(author)
                    .build());
        });

        return BookCollectionDTO.builder()
                .books(books)
                .build();
    }
}
