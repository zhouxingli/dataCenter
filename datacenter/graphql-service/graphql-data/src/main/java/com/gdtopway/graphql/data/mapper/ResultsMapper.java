package com.gdtopway.graphql.data.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtopway.graphql.data.entity.Results;
import org.apache.ibatis.annotations.Mapper;
import org.influxdb.annotation.Measurement;
import org.springblade.core.secure.annotation.PreAuth;

import java.util.List;

@Mapper
@DS("influx")
@PreAuth(function = "hasTable",param = "results")
public interface ResultsMapper extends BaseMapper<Results> {

    List<Results> findAllResults();
}
