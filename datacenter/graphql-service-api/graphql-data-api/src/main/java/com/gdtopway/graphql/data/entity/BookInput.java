package com.gdtopway.graphql.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {
    private String title;

    private String isbn;

    private int pageCount;

    private long authorId;
}
