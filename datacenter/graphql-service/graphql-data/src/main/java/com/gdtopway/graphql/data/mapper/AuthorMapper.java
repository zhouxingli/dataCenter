package com.gdtopway.graphql.data.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtopway.graphql.data.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.core.secure.annotation.PreAuth;

import java.util.List;

@Mapper
@PreAuth(function = "hasTable",param = "author")
public interface AuthorMapper  extends BaseMapper<Author> {
    Author findAuthorById(@Param("id") Long id);
    Integer save(Author author);
    Integer deleteById(@Param("id") Long id);

    List<Author> findAll();
    Long count();
}
