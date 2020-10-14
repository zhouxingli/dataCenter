package com.gdtopway.graphql.data.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.constant.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
@MapperScan({"org.springblade.**.mapper.**", "com.gdtopway.graphql.**.mapper.**"})
public class GraphqlDataConfiguration {

}

