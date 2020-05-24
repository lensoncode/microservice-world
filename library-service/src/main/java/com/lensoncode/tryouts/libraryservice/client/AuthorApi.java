package com.lensoncode.tryouts.libraryservice.client;

import com.lensoncode.tryouts.libraryservice.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("author-service")
@RequestMapping("author")
public interface AuthorApi {

    @GetMapping("{author}")
    AuthorDTO getAuthorInfo(@PathVariable("author") String authorName);
}
