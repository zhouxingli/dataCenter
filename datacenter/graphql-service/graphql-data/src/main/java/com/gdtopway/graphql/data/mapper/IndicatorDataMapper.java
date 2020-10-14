package com.gdtopway.graphql.data.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtopway.graphql.data.entity.IndicatorData;
import org.apache.ibatis.annotations.Mapper;
import org.springblade.core.secure.annotation.PreAuth;

@Mapper
@DS("dawn")
@PreAuth(function = "hasTable",param = "ind_indicator_database")
public interface IndicatorDataMapper extends BaseMapper<IndicatorData> {

}
