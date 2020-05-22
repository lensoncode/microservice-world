package com.lensoncode.tryouts.authorservice.controller;

import com.lensoncode.tryouts.authorservice.dto.AuthorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("author")
public class AuthorController {

    private Random random = new Random();

    @GetMapping("{author}")
    public AuthorDTO getAuthorInfo(@PathVariable("author") String authorName) {
        return AuthorDTO.builder()
                .name(authorName)
                .age(random.nextInt(40) + 25)
                .noOfBooksWritten(random.nextInt(50))
                .build();
    }
}
