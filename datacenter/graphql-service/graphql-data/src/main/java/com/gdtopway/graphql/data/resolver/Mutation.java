package com.gdtopway.graphql.data.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.entity.BookInput;
import com.gdtopway.graphql.data.mapper.AuthorMapper;
import com.gdtopway.graphql.data.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Resource
    private AuthorMapper authorMapper;
    @Resource
    private BookMapper bookMapper;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorMapper.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, int pageCount, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        bookMapper.save(book);
        return book;
    }


    public Book saveBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setPageCount(input.getPageCount());
        book.setAuthorId(input.getAuthorId());
        bookMapper.save(book);
        return book;
    }

    public Boolean deleteBook(Long id) {
        bookMapper.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(int pageCount,long id) {
        Book book = bookMapper.findBookById(id);
        book.setPageCount(pageCount);
        bookMapper.save(book);
        return book;
    }

}
