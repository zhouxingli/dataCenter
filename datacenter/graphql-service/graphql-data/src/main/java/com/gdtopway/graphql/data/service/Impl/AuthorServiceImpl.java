package com.gdtopway.graphql.data.service.Impl;

import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.mapper.AuthorMapper;
import com.gdtopway.graphql.data.service.AuthorService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<AuthorMapper,Author> implements AuthorService{

    @Override
    public Author findAuthorById(Long id) {
        System.out.println("AuthorServiceImpl");
        return baseMapper.findAuthorById(id);
    }
}
