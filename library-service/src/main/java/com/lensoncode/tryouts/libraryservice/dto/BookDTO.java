package com.lensoncode.tryouts.libraryservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @NonNull
    private String name;

    @NonNull
    private String author;

    private String yearOfFirstPublish;
    private int pages;
}