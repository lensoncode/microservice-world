package com.lensoncode.tryouts.libraryservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    @NonNull
    private String name;
    private int age;
    private int noOfBooksWritten;
}