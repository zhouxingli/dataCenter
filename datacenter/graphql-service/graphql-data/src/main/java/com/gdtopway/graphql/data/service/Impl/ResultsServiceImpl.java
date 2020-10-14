package com.gdtopway.graphql.data.service.Impl;

import com.gdtopway.graphql.data.entity.Results;
import com.gdtopway.graphql.data.mapper.ResultsMapper;
import com.gdtopway.graphql.data.service.ResultsService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsServiceImpl extends BaseServiceImpl<ResultsMapper, Results> implements ResultsService {
    @Override
    public List<Results> findAllResults() {
        return baseMapper.findAllResults();
    }
}
