package com.gdtopway.graphql.data.launcher;

import org.springblade.core.launch.constant.NacosConstant;
import org.springblade.core.launch.service.LauncherService;
import org.springblade.core.launch.utils.PropsUtil;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;


public class GraphLauncherServiceImpl implements LauncherService {
    @Override
    public void launcher(SpringApplicationBuilder builder, String appName, String profile) {
        Properties props = System.getProperties();
        PropsUtil.setProperty(props,"spring.cloud.nacos.config.shared-dataids", NacosConstant.dataId("graphql-data", profile));
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
