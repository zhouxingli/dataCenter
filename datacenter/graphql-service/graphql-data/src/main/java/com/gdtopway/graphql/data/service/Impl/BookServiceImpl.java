package com.gdtopway.graphql.data.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.mapper.BookMapper;
import com.gdtopway.graphql.data.service.BookService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<BookMapper,Book> implements BookService{
    @Override
    public Book findBookById(Long id) {
        return baseMapper.findBookById(id);
    }
}
