package com.lensoncode.tryouts.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String name;
    private String author;
    private String yearOfFirstPublish;
    private int pages;
}
