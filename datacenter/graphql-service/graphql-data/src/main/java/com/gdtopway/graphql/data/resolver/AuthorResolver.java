package com.gdtopway.graphql.data.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.mapper.AuthorMapper;
import com.gdtopway.graphql.data.mapper.BookMapper;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class AuthorResolver extends BaseServiceImpl<AuthorMapper,Author> implements GraphQLResolver<Author> {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private BookMapper bookMapper;

    public String getCreatedTime(Author author) {
        return sdf.format(author.getCreateTime());
    }

    public List<Book> getBooks(Author author) {

        return bookMapper.findByAuthorId(author.getId());
    }

}
