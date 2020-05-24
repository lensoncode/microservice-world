package com.lensoncode.tryouts.libraryservice.service;

import com.lensoncode.tryouts.libraryservice.client.BookApi;
import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookApi bookApi;

    @HystrixCommand(fallbackMethod = "bookNotAvailable")
    public BookDTO getBookByName(String bookName) {
        return bookApi.getBookInfo(bookName);
    }

    private BookDTO bookNotAvailable(String bookName) {
        return BookDTO.builder()
                .name(bookName)
                .author("")
                .build();
    }
}
