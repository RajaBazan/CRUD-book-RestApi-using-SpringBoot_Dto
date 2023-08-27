package com.api.book.bootrestbook.data.transfer.object;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private AuthorDto authorDto;
}