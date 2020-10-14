package com.gdtopway.graphql.data.service;

import com.gdtopway.graphql.data.entity.Book;

public interface BookService {
    Book findBookById(Long id);
}
