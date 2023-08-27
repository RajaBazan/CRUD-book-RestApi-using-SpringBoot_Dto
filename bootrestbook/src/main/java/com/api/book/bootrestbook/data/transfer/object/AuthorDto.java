package com.api.book.bootrestbook.data.transfer.object;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private int authorId;
    private String firstName;
    private String lastName;
    private String language;
}