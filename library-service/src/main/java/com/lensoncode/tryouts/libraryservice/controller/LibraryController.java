package com.lensoncode.tryouts.libraryservice.controller;

import com.lensoncode.tryouts.libraryservice.dto.AuthorDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookCollectionDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookInfoDTO;
import com.lensoncode.tryouts.libraryservice.service.AuthorService;
import com.lensoncode.tryouts.libraryservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class LibraryController {

    private List<String> hardCodedDemoBooks = List.of(
            "Book1",
            "Book2",
            "Book3",
            "Book4");

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping("book")
    public BookCollectionDTO getAllBooks() {
        List<BookInfoDTO> books = new ArrayList<>();
        hardCodedDemoBooks.forEach(bookName -> {
            BookDTO book = bookService.getBookByName(bookName);
            AuthorDTO author = authorService.getAuthorByName(book);

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
