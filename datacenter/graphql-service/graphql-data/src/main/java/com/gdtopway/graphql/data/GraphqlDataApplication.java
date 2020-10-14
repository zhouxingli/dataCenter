package com.gdtopway.graphql.data;


import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients({"org.springblade", "com.gdtopway.graphql.data"})
public class GraphqlDataApplication {
    public static void main(String[] args) {
        BladeApplication.run("graphql-data-zxl",GraphqlDataApplication.class,args);
    }
}
