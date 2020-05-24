package com.lensoncode.tryouts.libraryservice.service;

import com.lensoncode.tryouts.libraryservice.client.AuthorApi;
import com.lensoncode.tryouts.libraryservice.dto.AuthorDTO;
import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorApi authorApi;

    @HystrixCommand(fallbackMethod = "authorNotAvailable")
    public AuthorDTO getAuthorByName(BookDTO book) {
        return authorApi.getAuthorInfo(book.getAuthor());
    }

    private AuthorDTO authorNotAvailable(BookDTO book) {
        return AuthorDTO.builder()
                .name(book.getAuthor())
                .build();
    }
}
