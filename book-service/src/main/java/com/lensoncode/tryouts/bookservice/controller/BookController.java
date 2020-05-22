package com.lensoncode.tryouts.bookservice.controller;

import com.lensoncode.tryouts.bookservice.dto.BookDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("book")
public class BookController {

    private Random random = new Random();

    private List<String> hardCodedDemoAuthors = List.of(
            "Gabriel",
            "Ayan",
            "Salman",
            "Paulo");

    @GetMapping("{name}")
    public BookDTO getBookInfo(@PathVariable("name") String name) {
        return BookDTO.builder()
                .name(name)
                .author(hardCodedDemoAuthors.get(random.nextInt(4)))
                .yearOfFirstPublish(String.valueOf(random.nextInt(100) + 1919))
                .pages(random.nextInt(1500) + 200)
                .build();
    }
}
