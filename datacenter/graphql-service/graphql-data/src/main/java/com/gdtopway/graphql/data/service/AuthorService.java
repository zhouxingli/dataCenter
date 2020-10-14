package com.gdtopway.graphql.data.service;


import com.gdtopway.graphql.data.entity.Author;

public interface AuthorService {
    Author findAuthorById(Long id);
}
