package com.lensoncode.tryouts.libraryservice.service;

import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "bookNotAvailable")
    public BookDTO getBookByName(String bookName) {
        return restTemplate
                .getForObject("http://book-service/book/" + bookName, BookDTO.class);
    }

    private BookDTO bookNotAvailable(String bookName) {
        return BookDTO.builder()
                .name(bookName)
                .author("")
                .build();
    }
}
