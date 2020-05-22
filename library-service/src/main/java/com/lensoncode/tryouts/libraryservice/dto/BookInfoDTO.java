package com.lensoncode.tryouts.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoDTO {
    private BookDTO book;
    private AuthorDTO author;
}
