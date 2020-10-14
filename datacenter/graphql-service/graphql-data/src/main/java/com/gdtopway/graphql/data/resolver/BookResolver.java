package com.gdtopway.graphql.data.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.mapper.AuthorMapper;
import com.gdtopway.graphql.data.mapper.BookMapper;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BookResolver extends BaseServiceImpl<BookMapper,Book> implements GraphQLResolver<Book> {

    @Resource
    private AuthorMapper authorMapper;

    public Author getAuthor(Book book) {
        return authorMapper.findAuthorById(book.getAuthorId());
    }

}
