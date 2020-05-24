package com.lensoncode.tryouts.libraryservice.client;


import com.lensoncode.tryouts.libraryservice.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-service")
@RequestMapping("book")
public interface BookApi {

    @GetMapping("{name}")
    BookDTO getBookInfo(@PathVariable("name") String name);
}
