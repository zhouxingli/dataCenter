package com.gdtopway.graphql.data.resolver;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.entity.IndicatorData;
import com.gdtopway.graphql.data.mapper.AuthorMapper;
import com.gdtopway.graphql.data.mapper.BookMapper;
import com.gdtopway.graphql.data.mapper.IndicatorDataMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class Query implements GraphQLQueryResolver {
    @Resource
    private AuthorMapper authorMapper;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private IndicatorDataMapper indicatorDataMapper;

    public Author findAuthorById(Long id) {
        return authorMapper.findAuthorById(id);
    }

    public List<Author> findAllAuthors() {
        return authorMapper.findAll();
    }

    public Long countAuthors() {
        return authorMapper.count();
    }

    public List<Book> findAllBooks() {
        return bookMapper.findAll();
    }

    public Long countBooks() {
        return bookMapper.count();
    }

    public Book findBookById(Long id){
        return bookMapper.findBookById(id);
    }

    public List<IndicatorData> getIndicatorData(String dataDate,String indicatorCode,String deptCode){
        Map<String,Object> map=new HashMap<String,Object>();
        if(dataDate!=null){
            map.put("DATA_DATE",dataDate);
        }
        if(indicatorCode!=null){
            map.put("INDICATOR_CODE",indicatorCode);
        }
        if(deptCode!=null){
            map.put("DEPT_CODE",deptCode);
        }
        return indicatorDataMapper.selectByMap(map);
    }
}
