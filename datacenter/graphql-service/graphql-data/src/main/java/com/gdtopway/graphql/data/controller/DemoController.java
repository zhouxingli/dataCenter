package com.gdtopway.graphql.data.controller;

import com.gdtopway.graphql.data.Util.InfluxdbUtils;
import com.gdtopway.graphql.data.entity.Author;
import com.gdtopway.graphql.data.entity.Book;
import com.gdtopway.graphql.data.entity.Results;
import com.gdtopway.graphql.data.service.AuthorService;
import com.gdtopway.graphql.data.service.BookService;
import com.gdtopway.graphql.data.service.ResultsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@EnableDiscoveryClient
@Data
@Api(value = "示例", tags = "示例")
public class DemoController extends BladeController {

    private AuthorService authorService;

    private BookService bookService;

    private ResultsService resultsService;

    private InfluxDB influxDB;
    @Autowired
    private InfluxdbUtils influxdbUtils;
    //measurement
   // private final String measurement = "results";
    @Value("${spring.influx.database}")
    private String database;

    @GetMapping("/myAuthor/{id}")
    @ApiOperation(value = "作者", notes = "作者")
    @ApiOperationSupport(order = 1)
    @PreAuth("hasRole('administrator')")
    public R<Author> testDemo(@PathVariable Long id){
        Author author=authorService.findAuthorById(id);
        return R.data(author);
    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "书籍", notes = "书籍")
    @ApiOperationSupport(order = 2)
    public R<Book> getBook(@PathVariable Long id){
        Book book=bookService.findBookById(id);
        return R.data(book);
    }


    @GetMapping("getResults")
    @ApiOperation(value = "influxTest", notes = "influxTest")
    public R< List<Results>> getResults(){
        List<Results> allResults = resultsService.findAllResults();
        return  R.data(allResults);
    }

    /**
     * 获取数据
     */
    @GetMapping("test")
    public void datas(){
       // int pageSize = 10;
        // InfluxDB支持分页查询,因此可以设置分页查询条件
       // String pageQuery = " LIMIT " + pageSize + " OFFSET " + (page - 1) * pageSize;

        String queryCondition = "";  //查询条件暂且为空
        // 此处查询所有内容,如果
        String queryCmd = "SELECT * FROM results";


        QueryResult queryResult = influxDB.query(new Query(queryCmd, "mydb"));
        System.out.println("query result => {}:"+ queryResult);
    }

    @GetMapping("data2")
    public void datas2(){
        String queryCondition = "";  //查询条件暂且为空
        // 此处查询所有内容,如果
        String queryCmd2 = "SELECT * FROM results";
      //  List<Object> sensorList = influxdbUtils.fetchRecords(queryCmd2);
        List<Results> sensorList = influxdbUtils.fetchResults(queryCmd2,Results.class);
        System.out.println("query result => {}:"+ sensorList);
    }
}
