package com.lensoncode.tryouts.libraryservice.service;

import com.lensoncode.tryouts.libraryservice.dto.AuthorDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "authorNotAvailable")
    public AuthorDTO getAuthorByName(BookDTO book) {
        return restTemplate
                .getForObject("http://author-service/author/" + book.getAuthor(), AuthorDTO.class);
    }

    private AuthorDTO authorNotAvailable(BookDTO book) {
        return AuthorDTO.builder()
                .name(book.getAuthor())
                .build();
    }
}
