package com.gdtopway.graphql.data.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtopway.graphql.data.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.core.secure.annotation.PreAuth;

import java.util.List;

@Mapper
//@DS("slave")
@PreAuth(function = "hasTable",param = "book")
public interface BookMapper extends BaseMapper<Book> {

    List<Book> findByAuthorId(@Param("id") Long id);

    Book findBookById(@Param("id") Long id);

    Integer save(Book book);

    Integer deleteById(@Param("id") Long id);

    List<Book> findAll();

    Long count();
}
